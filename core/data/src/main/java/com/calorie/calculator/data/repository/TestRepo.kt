package com.calorie.calculator.data.repository

import com.calorie.calculator.model.Modelka

interface TestRepo {
    suspend fun getValue(): Modelka
}