# DDD Aggregates

Use this module when defining aggregate boundaries, invariants, identity strategy, and lifecycle methods.

## Focus

- Decide aggregate boundaries from the use cases and event-storming artifacts.
- Put invariant enforcement close to the aggregate root.
- Decide creation, rehydration, and mutation patterns.
- Decide how aggregates reference other aggregates.

## Questions to answer

- What consistency boundary does this aggregate own?
- Which invariants must always hold?
- Which operations belong on the aggregate rather than in a service?
- How does the aggregate expose state changes or domain events?