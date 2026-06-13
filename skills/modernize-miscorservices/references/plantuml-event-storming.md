# PlantUML Event Storming

Use PlantUML to express the business flow behind each important use case.

## Modeling rules

- Prefer the `eventstorming` library from `tmorin/plantuml-libs` when the environment can fetch remote includes.
- Use the library's event-storming elements such as `Person`, `Command`, `Aggregate`, `DomainEvent`, `Policy`, `ReadModel`, and `System`.
- Connect elements with ordinary PlantUML arrows so the causality chain stays explicit.
- Show actor intent first.
- Distinguish commands from domain events.
- Represent policies or process managers when they react to events.
- Call out aggregates only when they help explain state change responsibility.
- Include external systems only where they influence or observe the business flow.
- Keep infrastructure details secondary.

## Required elements

- Actor or trigger
- Command
- Aggregate or decision point when relevant
- Domain event
- Policy or reaction step when relevant
- Read model or externally visible outcome when relevant

## PlantUML starter template

```plantuml
@startuml
!include https://raw.githubusercontent.com/tmorin/plantuml-libs/master/distribution/eventstorming/single.puml

Title("Example Event Storming Flow", "Order submission")

Person(customer, "Customer")
Command(submitOrder, "Submit Order")
Aggregate(order, "Order")
DomainEvent(orderSubmitted, "Order Submitted")
Policy(reserveInventory, "Reserve Inventory")
Command(reserveStock, "Reserve Stock")
DomainEvent(inventoryReserved, "Inventory Reserved")
ReadModel(orderReady, "Order Ready For Fulfillment")

customer --> submitOrder
submitOrder --> order
order --> orderSubmitted
orderSubmitted --> reserveInventory
reserveInventory --> reserveStock
reserveStock --> inventoryReserved
inventoryReserved --> orderReady

@enduml
```

When using the eventstorming library, keep the diagram focused on business flow rather than infrastructure sequencing.

If remote includes are blocked, vendor the library locally and update the include path to your local copy of `distribution/eventstorming/single.puml`.

If you see a generic syntax error with `Assumed diagram type: class`, first check that the `!include` loaded successfully. If it did not, PlantUML will not know the `Title`, `Person`, `Command`, or `DomainEvent` procedures.

## Diagram naming

Use lowercase hyphenated filenames derived from the use case name.

Examples:

- `submit-customer-order.puml`
- `approve-refund-request.puml`

## Review checklist

- The diagram can be understood without reading code.
- Events are phrased in past tense.
- Commands are phrased as intent.
- Policies clearly react to prior events.
- The flow shows the business outcome, not just transport hops.