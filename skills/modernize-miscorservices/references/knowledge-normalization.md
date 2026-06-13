# Knowledge Normalization

Use this reference after the `docs/codebase/` prerequisite has been satisfied.

## Goal

Normalize existing codebase knowledge into a consistent baseline that supports use-case discovery and later modernization planning.

## Minimum acceptance criteria

- The list of services is explicit.
- Each service has a stated responsibility.
- Each service documents its inputs and outputs.
- Data ownership is described at least at a service or bounded-context level.
- Synchronous and asynchronous integrations are called out.
- Known gaps and assumptions are listed in their own section.

## Suggested output sections

### Service inventory

- Service name
- Responsibility
- Entry points
- Outbound dependencies
- Persistence ownership
- Operational notes

### Domain glossary

- Term
- Meaning in this codebase
- Related service or bounded context
- Known ambiguity or overload

### Modernization readiness

- Current coupling hotspots
- Transaction boundaries
- Messaging or event seams
- Candidate bounded contexts
- Kotlin or Quarkus version constraints
- Unknowns that still require research

## Decision rule

If the existing `docs/codebase/` artifacts do not let you answer these questions with reasonable confidence, stop and ask for the prerequisite acquisition step to be completed more thoroughly.