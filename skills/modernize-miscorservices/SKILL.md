---
name: modernize-miscorservices
description: 'Workflow for documenting and modernizing legacy Quarkus Kotlin microservice codebases. Use when asked to analyze or modernize a Quarkus microservice system, populate docs/codebase first, identify business use cases, create PlantUML event-storming diagrams, and later prepare DDD tactical and hexagonal modernization work.'
---

# Modernize legacy Quarkus Kotlin microservices through staged codebase knowledge, use-case discovery, and architecture-led modernization.

## When to Use This Skill

- User wants to modernize a legacy Quarkus Kotlin microservice codebase.
- User needs the current system documented before planning or rewriting code.
- User wants business use cases extracted from source and represented as event-storming diagrams.
- User wants modernization work to follow DDD tactical patterns and hexagonal architecture.

## Prerequisite Gate

This skill has a hard prerequisite: the repository root must already contain `docs/codebase/` populated by the `acquire-codebase-knowledge` skill.

Treat the upstream skill's output contract as mandatory baseline input. Before continuing, confirm that `docs/codebase/` contains exactly these required baseline documents:

- `STACK.md`
- `STRUCTURE.md`
- `ARCHITECTURE.md`
- `CONVENTIONS.md`
- `INTEGRATIONS.md`
- `TESTING.md`
- `CONCERNS.md`

If `docs/codebase/` is missing or clearly incomplete:

1. Stop the modernization workflow.
2. Tell the user to use the GitHub `acquire-codebase-knowledge` skill first:
   https://github.com/github/awesome-copilot/tree/main/skills/acquire-codebase-knowledge
3. Resume this skill only after the folder has been populated.

Do not invent missing architectural knowledge from sparse code reads when this prerequisite has not been met.

## Expected Inputs

- A legacy codebase using Quarkus and Kotlin.
- A microservice-oriented repository or multi-repository workspace.
- A populated `docs/codebase/` folder containing the seven baseline documents from the upstream skill.
- Baseline documents whose claims are evidence-backed, with unknowns marked as `[TODO]` and intent-dependent gaps marked as `[ASK USER]`.

## Expected Documentation Outputs

Preserve the upstream skill's seven baseline files as the source-of-truth documentation set in `docs/codebase/`:

- `docs/codebase/STACK.md`
- `docs/codebase/STRUCTURE.md`
- `docs/codebase/ARCHITECTURE.md`
- `docs/codebase/CONVENTIONS.md`
- `docs/codebase/INTEGRATIONS.md`
- `docs/codebase/TESTING.md`
- `docs/codebase/CONCERNS.md`

This skill may extend that baseline with additional downstream artifacts, but it should not redefine or replace the upstream contract.

Additional outputs produced by this skill:

- `docs/codebase/use-cases/` with one markdown file per identified business use case.
- `docs/codebase/event-storming/` with one PlantUML diagram per significant use case or domain flow.
- `docs/codebase/modernization-readiness.md` summarizing modernization constraints, bounded-context candidates, and migration seams.

Use the reference files in this skill as the default structure and quality bar.

## Companion Skills

This skill sits in the middle of a staged modernization workflow.

- `acquire-codebase-knowledge` — prerequisite companion skill. Use it first to populate the required seven-file baseline in `docs/codebase/`.
- Future DDD tactical design skill — downstream companion skill. Use it after use cases and event-storming diagrams exist to define aggregates, value objects, domain services, repositories, and boundaries.
- Future hexagonal architecture implementation skill — downstream companion skill. Use it after the domain model is clear to guide ports, adapters, package structure, and modernization code changes.

Companion skills help sequence the workflow, but they do not affect automatic skill discovery. Triggering still depends on this skill's frontmatter description.

## Step-by-Step Workflows

### Phase 1: Validate and normalize codebase knowledge

1. Confirm that `docs/codebase/` exists and contains the seven required baseline files from the upstream skill.
2. Review those baseline artifacts and identify obvious gaps in service inventory, domain language, integrations, data ownership, and runtime flows.
3. Extend the existing knowledge into this skill's downstream artifacts without breaking the upstream file contract.
4. Record assumptions explicitly instead of burying them inside summaries.

Use [knowledge normalization guidance](./references/knowledge-normalization.md) to decide whether the prerequisite is sufficient.

### Phase 2: Identify and document business use cases

1. Inspect the normalized codebase knowledge and source code to enumerate end-to-end business use cases.
2. Group use cases by bounded context, upstream trigger, and observable outcome.
3. Create one markdown document per use case under `docs/codebase/use-cases/`.
4. Capture actors, commands, domain events, policies, aggregates, external systems, and failure paths.

Use [use-case extraction guidance](./references/use-case-extraction.md) for the required structure.

### Phase 3: Create PlantUML event-storming diagrams

1. For each significant use case, produce a PlantUML event-storming diagram.
2. Model the sequence from trigger to domain outcome with explicit commands, events, policies, read models, and external systems.
3. Keep the diagram focused on business flow, not infrastructure call stacks.
4. Store each diagram under `docs/codebase/event-storming/`.

Use [PlantUML event-storming guidance](./references/plantuml-event-storming.md) for conventions and a starter template.

### Phase 4: Prepare modernization execution

1. Do not start implementation until phases 1 through 3 are complete.
2. Create a dedicated git branch for modernization work only after the documentation baseline exists.
3. Summarize candidate aggregates, ports, adapters, anti-corruption boundaries, and migration seams.
4. Follow future skill references for DDD tactical design and hexagonal implementation rules when those instructions are added.

At this stage, branch creation is allowed, but implementation guidance is intentionally incomplete. If the user asks for code modernization before the later references exist, state that the documentation and branch setup are ready but the implementation rules for the rewrite phase still need to be defined.

## Gotchas

- **Never** skip the `docs/codebase/` prerequisite. This skill depends on prior knowledge capture and should not reconstruct the entire system ad hoc.
- **Do not** replace the upstream seven-file contract with custom top-level docs. Build on `STACK.md`, `STRUCTURE.md`, `ARCHITECTURE.md`, `CONVENTIONS.md`, `INTEGRATIONS.md`, `TESTING.md`, and `CONCERNS.md`.
- **Do not** confuse technical endpoints with business use cases. A single business use case may cross several services and adapters.
- **Do not** draw event-storming diagrams as request/response sequence diagrams. Focus on domain intent, commands, events, policies, and outcomes.
- **Avoid** premature target architecture design during phases 1 through 3. First document the current system accurately.
- **Branch creation comes late** in this workflow. Do not create a modernization branch before the documentation baseline is stable enough to guide the rewrite.

## Troubleshooting

| Issue | Solution |
|-------|----------|
| `docs/codebase/` does not exist | Stop and direct the user to the `acquire-codebase-knowledge` skill before continuing. |
| One or more baseline files are missing from `docs/codebase/` | Treat the prerequisite as incomplete and send the user back to the upstream skill to complete the seven-file contract. |
| Existing codebase docs are shallow or inconsistent | Normalize what exists, list the gaps explicitly, and continue only if the missing pieces do not block use-case discovery. |
| Microservice boundaries are unclear | Reconstruct service responsibilities from deployment descriptors, endpoints, messaging, persistence ownership, and existing docs before writing use cases. |
| Diagram becomes too technical | Rewrite it around actor intent, commands, events, and policies using the PlantUML reference. |
| User asks for modernization code immediately | Explain that this skill currently defines the documentation and discovery phases plus branch preparation, while detailed rewrite rules will be added later. |

## References

- [Knowledge normalization](./references/knowledge-normalization.md)
- [Use-case extraction](./references/use-case-extraction.md)
- [PlantUML event storming](./references/plantuml-event-storming.md)