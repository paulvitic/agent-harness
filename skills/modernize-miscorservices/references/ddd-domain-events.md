# DDD Domain Events

Use this module when naming events, deciding raise-versus-dispatch rules, and defining publication timing.

## Focus

- Distinguish domain events from integration events.
- Keep event naming in past tense.
- Decide whether aggregates accumulate pending events or expose them another way.
- Decide when application services publish events relative to transaction success.

## Questions to answer

- Which state changes deserve explicit domain events?
- How are domain events represented in Kotlin?
- When are events published in Quarkus transaction flow?
- When does an event become an integration event for another service?