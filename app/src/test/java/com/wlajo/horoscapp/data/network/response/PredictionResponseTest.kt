package com.wlajo.horoscapp.data.network.response

import com.wlajo.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest {

    @Test
    fun `toDomain shold return a correct PredictionModel`() {
        val predictionResponse = anyResponse.copy(sign = "libra")

        val predictionModel = predictionResponse.toDomain()

        predictionModel.sign shouldBe predictionResponse.sign
        predictionModel.horoscope shouldBe predictionResponse.horoscope
    }
}