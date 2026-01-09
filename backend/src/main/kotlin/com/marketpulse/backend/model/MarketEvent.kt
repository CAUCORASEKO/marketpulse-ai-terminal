package com.marketpulse.backend.model

import java.time.Instant

data class MarketEvent(
    val id: String,
    val symbol: String,
    val type: String,
    val timestamp: Instant,
    val description: String
)