# DDD Repositories

Use this module when designing repository interfaces, aggregate loading and saving rules, and persistence translation boundaries.

## Focus

- Define repository interfaces around aggregate access patterns.
- Decide whether repository interfaces live in the domain layer or a dedicated port package.
- Keep persistence models and ORM details behind the repository implementation.
- Avoid leaking query infrastructure into aggregate-facing APIs.

## Questions to answer

- Which repository operations are required by the use cases?
- What should repository method signatures return?
- How are domain models translated to persistence models in Kotlin and Quarkus?
- Which queries belong in repositories versus read-model access paths?