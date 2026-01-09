package com.marketpulse.backend.service

import com.marketpulse.backend.model.MarketEvent
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class MarketEventService {

	suspend fun getEvents(): List<MarketEvent> {
		return listOf(
			MarketEvent(
				id = "evt-1",
				symbol = "AAPL",
				type = "VOLUME_SPIKE",
				timestamp = Instant.now(),
				description = "Unusual volume detected"
			),
			MarketEvent(
				id = "evt-2",
				symbol = "TSLA",
				type = "PRICE_MOVEMENT",
				timestamp = Instant.now(),
				description = "Sharp price movement"
			)
		)
	}
}