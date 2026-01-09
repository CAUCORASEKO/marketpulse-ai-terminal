package com.marketpulse.backend.ai

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class OpenAiClient(
    @Value("\${openai.api-key}")
    private val apiKey: String,

    @Value("\${openai.model:gpt-4o-mini}")
    private val model: String,

    private val objectMapper: ObjectMapper
) {

    private val webClient = WebClient.builder()
        .baseUrl("https://api.openai.com/v1")
        .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer $apiKey")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build()

    /**
     * 🔥 Streaming REAL token-by-token desde OpenAI
     */
    fun streamCompletion(prompt: String): Flow<String> = flow {

        val requestBody = mapOf(
            "model" to model,
            "input" to prompt,
            "stream" to true
        )

        webClient.post()
            .uri("/responses")
            .bodyValue(requestBody)
            .retrieve()
            .bodyToFlux(String::class.java)
            .collect { rawChunk ->
                parseToken(rawChunk)?.let { emit(it) }
            }
    }

    private fun parseToken(rawJson: String): String? {
        return try {
            val root: JsonNode = objectMapper.readTree(rawJson)

            root.path("output")
                .firstOrNull()
                ?.path("content")
                ?.firstOrNull()
                ?.takeIf { it.path("type").asText() == "output_text" }
                ?.path("text")
                ?.asText()
        } catch (_: Exception) {
            null
        }
    }
}