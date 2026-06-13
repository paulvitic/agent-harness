# DDD Value Objects

Use this module when designing typed IDs, immutable value types, validation rules, and normalization behavior.

## Focus

- Replace primitive obsession with domain-specific types.
- Decide when Kotlin `value class`, `data class`, or regular class is appropriate.
- Keep validation and normalization close to the type.
- Keep persistence mapping concerns out of the domain type unless the project explicitly chooses otherwise.

## Questions to answer

- Which primitive fields should become value objects?
- Which identifiers should become typed wrappers?
- Where should normalization happen?
- How should persistence mapping be translated in Quarkus and Kotlin?