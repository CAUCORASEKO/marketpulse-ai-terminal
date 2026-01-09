package com.marketpulse.backend.ai

sealed class OpenAiException(message: String) : RuntimeException(message) {

    class Unauthorized :
        OpenAiException("Invalid or missing OpenAI API key")

    class RateLimited :
        OpenAiException("OpenAI rate limit reached. Please retry shortly")

    class ServerError :
        OpenAiException("OpenAI service is temporarily unavailable")

    class Unknown(message: String) :
        OpenAiException(message)
}