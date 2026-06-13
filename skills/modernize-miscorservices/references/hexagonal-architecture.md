# Hexagonal Architecture

Use this module when translating the discovered domain model into ports, adapters, and implementation boundaries.

## Focus

- Define inbound and outbound ports.
- Define adapter responsibilities and package placement.
- Define anti-corruption boundaries between contexts or services.
- Keep domain and application code isolated from transport and persistence mechanics.

## Questions to answer

- Which interfaces are true ports in this codebase?
- Which adapters wrap databases, messaging, HTTP clients, or schedulers?
- Which external models require anti-corruption translation?
- How should the target package or module structure reflect those boundaries?