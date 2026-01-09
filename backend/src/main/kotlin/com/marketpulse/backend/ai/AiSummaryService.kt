package com.marketpulse.backend.ai

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay
import org.springframework.http.codec.ServerSentEvent
import org.springframework.stereotype.Service

@Service
class AiSummaryService(
    private val openAiClient: OpenAiClient
) {

    fun summarizeStream(
        symbol: String,
        description: String
    ): Flow<ServerSentEvent<String>> = flow {

        emit(sse("start", "Market summary started"))

        val prompt = """
            Summarize the following market event in a concise,
            professional market analysis style.

            - $symbol: $description
        """.trimIndent()

        openAiClient.streamCompletion(prompt)
            .collect { token ->
                emit(sse("chunk", token))
                delay(30) // suaviza UX y evita bursts
            }

        emit(sse("end", "Market summary completed"))
    }

    private fun sse(event: String, data: String): ServerSentEvent<String> =
        ServerSentEvent.builder<String>()
            .event(event)
            .data(data)
            .build()
}