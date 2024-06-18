package com.wlajo.horoscapp.data.providers

import com.wlajo.horoscapp.domain.model.HoroscopeInfo
import com.wlajo.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagitarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}