package com.wlajo.horoscapp.data

import android.util.Log
import com.wlajo.horoscapp.data.network.HoroscopeApiService
import com.wlajo.horoscapp.domain.Repository
import com.wlajo.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService) :
    Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching{ apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("wlad", "Ha ocurrido un error ${it.message}") }

        return null
    }
}