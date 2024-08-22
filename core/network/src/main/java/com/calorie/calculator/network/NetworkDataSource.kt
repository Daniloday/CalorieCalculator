package com.calorie.calculator.network

import com.calorie.calculator.network.dto.ResponseDto

interface NetworkDataSource {
    suspend fun getValue(): ResponseDto
}