package com.calorie.calculator.network.retrofit

import com.calorie.calculator.network.BuildConfig
import com.calorie.calculator.network.NetworkDataSource
import com.calorie.calculator.network.dto.ResponseDto

private const val BASE_URL = BuildConfig.API_URL

internal class RetrofitNetworkDataSource(): NetworkDataSource {

    private val retrofit = buildRetrofit(BASE_URL)
    private val networkApi: NetworkApi = retrofit.create(NetworkApi::class.java)

    override suspend fun getValue(): ResponseDto {
        return networkApi.getValue("1")
    }
}

