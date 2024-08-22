package com.calorie.calculator.data.repository_impl

import com.calorie.calculator.data.mapper.asModel
import com.calorie.calculator.data.repository.TestRepo
import com.calorie.calculator.model.Modelka
import com.calorie.calculator.network.NetworkDataSource

internal class TestRepoImpl(
    private val networkDataSource: NetworkDataSource
): TestRepo {

    override suspend fun getValue(): Modelka {
        return networkDataSource.getValue().asModel()
    }

}