# agent-harness

A collection of agent harnesses, including:

- skills
- agents
- instructions
- prompts

## Repository structure

- `skills/` — self-contained folders with a `SKILL.md` file plus any bundled assets
- `agents/` — agent definitions, typically published as `*.agent.md`
- `instructions/` — reusable instruction files, typically published as `*.instructions.md`
- `prompts/` — reusable prompt templates and prompt assets

## Authoring model

This repository is initialized around four complementary harness primitives:

| Primitive | Purpose | Typical shape |
| --- | --- | --- |
| Skills | Package instructions with supporting assets for repeatable tasks | `skill-name/SKILL.md` plus scripts, templates, or references |
| Agents | Define specialized agent personas and workflows | `name.agent.md` |
| Instructions | Capture reusable behavior or coding guidance that can be applied automatically | `name.instructions.md` |
| Prompts | Store reusable prompt text, prompt packs, and supporting context | `name.prompt.md` or related assets |

## Initialization guidance

- Add skills as folders so instructions and bundled resources stay together.
- Add agents as focused, single-purpose definitions with any required tool or environment expectations documented in the file.
- Add instructions as reusable guidance that can be applied across repositories or tasks.
- Add prompts as reusable templates, examples, or seed material that support the other harness types.

## Reference points

The repository structure and terminology are informed by:

- [Agent Skills specification](https://agentskills.io/specification)
- [Agents.md](https://agents.md/)
- [OpenAI tools and skills guidance](https://developers.openai.com/api/docs/guides/tools-skills)
- [github/awesome-copilot](https://github.com/github/awesome-copilot)