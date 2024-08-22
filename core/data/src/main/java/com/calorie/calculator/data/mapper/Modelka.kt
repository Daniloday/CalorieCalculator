package com.calorie.calculator.data.mapper

import com.calorie.calculator.model.Modelka
import com.calorie.calculator.network.dto.ResponseDto


internal fun ResponseDto.asModel() = Modelka(
    value = timeTaken.toString()
)