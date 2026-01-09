package com.marketpulse.backend.ai

import com.marketpulse.backend.model.MarketEvent
import kotlinx.coroutines.flow.Flow
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/api/ai")
class AiController(
    private val aiSummaryService: AiSummaryService
) {

    /**
     * 🔹 Resumen normal (JSON)
     */
    @PostMapping(
        "/summary",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    suspend fun summarize(
        @RequestBody events: List<MarketEvent>
    ): Map<String, String> =
        mapOf("summary" to aiSummaryService.summarize(events))

    /**
     * 🔹 Resumen en streaming (SSE) → GET + query params
     */
    @GetMapping(
        "/summary/stream",
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
    )
    fun summarizeStream(
        @RequestParam symbol: String,
        @RequestParam description: String
    ): Flow<String> =
        aiSummaryService.summarizeStream(
            listOf(
                MarketEvent(
                    id = "evt-stream",
                    symbol = symbol,
                    type = "STREAM",
                    timestamp = Instant.now(),
                    description = description
                )
            )
        )
}