package com.calorie.calculator.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto(
    val timeTaken: Double
)
