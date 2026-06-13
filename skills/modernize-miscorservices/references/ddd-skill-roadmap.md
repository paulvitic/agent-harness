# DDD Module Roadmap

This reference defines the intended internal modernization modules for the parent workflow skill.

## Goal

Use external DDD skill repositories as source material, not as copy-paste inputs. Derive a Quarkus-and-Kotlin-specific skill set that matches this project's conventions and disagrees where necessary.

## Adoption rule

- Reuse the decomposition ideas and pressure-tested problem framing.
- Do not reuse wording blindly.
- Do not inherit conventions the target project does not agree with.
- Prefer rules that can be justified from the target codebase and the modernization goals.
- Use external examples only as illustrative inspiration, not as the target architecture by default.

## Recommended internal module split

Keep the current `modernize-miscorservices` skill as the parent workflow skill. Add focused internal modules only for the modernization phase.

Suggested modules:

- `ddd-foundations` — layering map, bounded-context structure, dependency directions, naming rules.
- `ddd-aggregates` — aggregate responsibilities, invariants, identity strategy, lifecycle methods, aggregate boundaries.
- `ddd-value-objects` — typed IDs, immutable value types, validation, normalization, equality by value.
- `ddd-services` — application service vs domain service distinction, transaction ownership, orchestration rules.
- `ddd-repositories` — repository interface design, aggregate loading and saving rules, persistence translation boundaries.
- `ddd-domain-events` — event naming, raise vs dispatch rules, publication timing, integration vs domain event separation.
- `hexagonal-architecture` — ports, adapters, anti-corruption boundaries, module/package layout, modernization target structure.

## Why this split

- `modernize-miscorservices` should stay focused on discovery, use-case extraction, event storming, and modernization readiness.
- The DDD rules are reusable across multiple modernization efforts without forcing a separate top-level activation surface yet.
- Repositories and domain events are large enough concepts to justify their own internal modules.
- Quarkus-specific and Kotlin-specific guidance can be phrased in the modules without bloating the parent workflow body.

## Likely conventions to decide explicitly

These are the areas where the downstream skills should choose a project-specific rule instead of inheriting one automatically from the source repos:
These are the areas where the internal modules should choose a project-specific rule instead of inheriting one automatically from upstream examples:

- Package structure by bounded context
- Kotlin data class vs regular class vs value class usage in the domain model
- Whether repository interfaces live in `domain` or a dedicated port package
- Whether aggregates expose pending events or return events explicitly
- Domain event publication mechanism in Quarkus and the exact transaction boundary semantics
- How persistence models map to domain models in Kotlin with Quarkus and Panache or Hibernate ORM
- How DTOs, commands, and REST resources are named

## Authoring order

Create the internal modules in this order:

1. `ddd-foundations`
2. `ddd-value-objects`
3. `ddd-aggregates`
4. `ddd-services`
5. `ddd-repositories`
6. `ddd-domain-events`
7. `hexagonal-architecture`

That order keeps the vocabulary and layering rules stable before writing more specific guidance.

## How to use the source repos well

- Mine them for trigger patterns, anti-pattern framing, and boundary decisions.
- Extract the useful decision points into your own rule tables.
- Replace Java-only assumptions with Kotlin-aware guidance where needed.
- Add missing modules rather than overloading a single module with unrelated rules.
- Validate each module against example Quarkus/Kotlin code before treating it as finished.