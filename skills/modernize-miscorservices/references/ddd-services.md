# DDD Services

Use this module when distinguishing application services from domain services and deciding where orchestration belongs.

## Focus

- Keep use-case orchestration in application services.
- Keep pure cross-aggregate or cross-value-object computation in domain services.
- Avoid ambiguous `*Service` classes with mixed responsibilities.
- Keep transaction ownership explicit.

## Questions to answer

- Does the logic coordinate a use case or compute domain behavior?
- Does the logic need repositories, event publication, or I/O?
- Should the logic stay on the aggregate instead?
- Where should the transaction boundary live?