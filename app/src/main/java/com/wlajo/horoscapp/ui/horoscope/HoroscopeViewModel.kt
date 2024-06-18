package com.wlajo.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.wlajo.horoscapp.data.providers.HoroscopeProvider
import com.wlajo.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import com.wlajo.horoscapp.domain.model.HoroscopeInfo.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> get() = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}