package com.calorie.calculator.domain

import com.calorie.calculator.data.repository.TestRepo

class TestUseCase(
    private val repo: TestRepo
) {
    suspend operator fun invoke() = repo.getValue()
}