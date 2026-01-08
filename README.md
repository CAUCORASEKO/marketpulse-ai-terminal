# MarketPulse AI Terminal

MarketPulse is a compact full-stack market analytics terminal built to explore
reactive backend architectures and practical AI-assisted development workflows
in a trading-oriented context.

The project combines a Kotlin-based Spring WebFlux backend with a React + TypeScript frontend,
providing a small but realistic trading-style interface for viewing market events and generating
AI-powered summaries.

This repository was created as a focused technical exploration following the development
of a production-grade desktop analytics application (WhaleScope).

The goal of this project is to validate Kotlin-based reactive backends, modern frontend
integration, and LLM-powered features within a realistic market analytics domain,
without the overhead of a large production system.

## Project Scope

MarketPulse is intentionally small in scope.

It is not a production system, but a compact, end-to-end implementation that demonstrates:
- Reactive backend development with Kotlin and Spring WebFlux
- Clean API design for market-style data
- A modern React + TypeScript frontend
- Practical integration of LLM APIs for market summaries and insights
- AI-assisted development workflows and tooling experiments
- The emphasis is on clarity of architecture, correctness, and developer experience rather
  than feature completeness.

## Tech Stack

### Backend
- Kotlin
- Spring WebFlux
- PostgreSQL
- R2DBC
- Gradle

### Frontend
- React
- TypeScript
- Vite
- Modern hooks-based architecture

### AI / LLM
- OpenAI / Claude (via API)
- Prompt-driven market summaries and anomaly explanations
- Structured context injection for consistent LLM outputs

### Tooling
- Docker (local development)
- GitHub Actions (basic CI)

