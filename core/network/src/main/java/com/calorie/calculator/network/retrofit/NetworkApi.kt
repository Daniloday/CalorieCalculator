package com.calorie.calculator.network.retrofit

import com.calorie.calculator.network.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NetworkApi {

    @GET("price")
    suspend fun getValue(
        @Query("ids") query: String? = null,
    ): ResponseDto

}