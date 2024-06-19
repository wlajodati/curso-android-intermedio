package com.wlajo.horoscapp.domain

import com.wlajo.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}