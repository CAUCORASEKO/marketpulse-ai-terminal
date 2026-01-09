# MarketPulse AI Terminal

MarketPulse is a compact, end-to-end **AI-powered market analytics terminal** built to explore
**reactive backend architectures**, **Server-Sent Events (SSE)**, and **real-time LLM integration**
within a realistic trading-oriented context.

The project combines a **Kotlin + Spring WebFlux reactive backend** with a **Node.js-based terminal UI**
that streams AI-generated market analysis in real time, simulating the experience of a lightweight
professional trading terminal.

MarketPulse is intentionally designed as a **focused technical exploration**, prioritizing
architecture clarity, streaming correctness, and developer experience over feature breadth.

---

## Motivation

This repository was created as a **hands-on technical experiment** following the development of
a production-grade desktop analytics application (WhaleScope).

The primary goals of MarketPulse are to:

- Validate **Kotlin-based reactive backends** in real-world scenarios
- Explore **non-blocking AI integrations** using streaming responses
- Build a realistic **market-style interface** without enterprise-level overhead
- Experiment with **LLM-assisted workflows** applied to financial event analysis

Rather than aiming for a production system, MarketPulse serves as a **reference implementation**
for modern reactive + AI-driven architectures.

---

## Project Scope

MarketPulse is intentionally **small in scope**.

It is **not** a production trading platform, but a compact, end-to-end system that demonstrates:

- Reactive backend development with **Kotlin + Spring WebFlux**
- **Server-Sent Events (SSE)** for real-time streaming responses
- Clean API design for market-style event data
- Practical **LLM integration** for AI-generated market summaries
- A terminal-based UI that consumes live AI streams
- Emphasis on **correctness, observability, and developer ergonomics**

The focus is on **how the system behaves**, not how many features it exposes.

---

## Architecture Overview

At a high level, the system is composed of:

- A **reactive backend** that:
  - Accepts market events
  - Calls an LLM API asynchronously
  - Streams the generated analysis back to the client via SSE

- A **terminal-based client** that:
  - Connects to the backend using EventSource
  - Renders the AI output incrementally
  - Handles reconnection and stream lifecycle events
  - Presents a clean, trading-terminal-inspired UX

This architecture ensures:
- Zero blocking threads
- Backpressure-friendly streaming
- Clear separation between AI generation and presentation

This design mirrors patterns used in professional trading and analytics platforms,
where latency, responsiveness, and incremental insight delivery are critical.

---

## Screenshots

### Reactive Backend Bootstrap (Spring Initializr)

The backend was bootstrapped using Spring Initializr with a fully reactive stack,
selecting Kotlin, Spring WebFlux, and a non-blocking architecture from day one.

![Reactive Backend Bootstrap](backend/docs/image/reactive-backend-bootstrap.png)

### Project Generation & Structure

The initial project structure was generated using Spring Initializr and imported
directly into the workspace, serving as the foundation for the reactive backend
and AI streaming components.

![Project Bootstrap Generation](backend/docs/image/project-bootstrap-generation.png)

### Live AI Market Summary (Terminal UI)

The MarketPulse terminal consumes Server-Sent Events (SSE) from the backend and
renders AI-generated market analysis incrementally, simulating a real-time
professional trading terminal experience.

This includes connection lifecycle events, streaming output, and clean completion
signaling.

![MarketPulse AI Terminal Streaming](backend/docs/image/2%20-Captura%20de%20pantalla%202026-01-09%20a%20la(s)%2006.35.01.png)


---

## Tech Stack

### Backend
- Kotlin
- Spring Boot (WebFlux)
- Reactive WebClient
- Server-Sent Events (SSE)
- Gradle
- PostgreSQL (R2DBC-ready)

### Terminal Client
- Node.js
- EventSource (SSE client)
- ANSI-based terminal UI (colors, status indicators, streaming output)

### AI / LLM
- OpenAI (Responses API)
- Prompt-driven market summaries
- Deterministic, structured prompts for consistent output
- Streaming-friendly AI response handling

### Tooling & Dev Experience
- Gradle Kotlin DSL
- Local development via Spring Boot
- Clear logging and observability for AI requests
- GitHub-ready project structure

---

## Example: Live AI Market Summary

The terminal UI consumes AI output **as it is generated**, producing a live market summary experience:

- Connection status
- Stream lifecycle events
- Incremental AI-generated analysis
- Clean completion signaling

This closely mirrors how professional analytics terminals present
real-time insights to traders and analysts.

---

## What This Project Is (and Is Not)

**MarketPulse is:**
- A realistic technical demo
- A reference for reactive + AI streaming architectures
- A portfolio-quality exploration project

**MarketPulse is not:**
- A production trading platform
- A full-featured market data system
- A frontend-heavy UI showcase

---

## Status

MarketPulse is considered **feature-complete for its intended scope**.

Future improvements may include:
- Multi-event batching
- Persistent event storage
- More advanced prompt strategies
- Web-based UI variants

---

## License

MIT License

---

*MarketPulse AI Terminal — exploring reactive systems and real-time AI integration in a market-driven context.*