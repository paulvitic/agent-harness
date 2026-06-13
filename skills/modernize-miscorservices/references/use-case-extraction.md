# Use-Case Extraction

Document business use cases, not just APIs or handlers.

## One file per use case

Store each use case as a markdown file under `docs/codebase/use-cases/`.

## Required sections

### Name

Use a business-oriented verb phrase.

Examples:

- Submit customer order
- Approve refund request
- Recalculate subscription invoice

### Goal

State the business outcome.

### Primary actor

Name the user, system, or scheduled trigger that starts the flow.

### Preconditions

List the state or business rules that must already hold.

### Main flow

Write the happy path in numbered steps.

### Alternate flows

List important variations, retries, compensations, or validation failures.

### Commands and domain events

Identify the domain commands issued and the domain events emitted.

### Services and adapters involved

Name the participating services, repositories, consumers, publishers, and external systems.

### Evidence

Reference the source material that supports the use case, such as endpoints, consumers, scheduled jobs, handlers, or existing docs.

## Heuristics

- Prefer user intent over transport protocol.
- Merge duplicate endpoint variants into one use case when the business outcome is the same.
- Split a use case when separate aggregates, policies, or event chains imply distinct business responsibilities.
- If a flow exists only for technical maintenance, do not promote it to a core business use case unless the user explicitly wants operational flows documented too.