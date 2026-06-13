# DDD Foundations

Use this module when deciding layering, bounded-context structure, dependency direction, and naming conventions.

## Focus

- Define the bounded-context package or module layout.
- Define which layers may depend on which other layers.
- Define how application services, domain services, repositories, resources, and adapters are named.
- Keep domain code free of framework annotations unless an explicit project rule says otherwise.

## Questions to answer

- What is the bounded-context unit in this codebase: package, module, service, or another slice?
- Where do domain, application, infrastructure, and interface concerns live?
- Where do repository interfaces live?
- What naming rules prevent ambiguous `*Service` classes?

## Output expectation

Produce a short project-specific layering contract before implementing aggregates, repositories, or services.