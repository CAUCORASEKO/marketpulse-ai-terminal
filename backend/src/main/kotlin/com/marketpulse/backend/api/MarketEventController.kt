package com.marketpulse.backend.api

import com.marketpulse.backend.model.MarketEvent
import com.marketpulse.backend.service.MarketEventService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
class MarketEventController(
	private val marketEventService: MarketEventService
) {

	@GetMapping
	suspend fun getEvents(): List<MarketEvent> {
		return marketEventService.getEvents()
	}
}