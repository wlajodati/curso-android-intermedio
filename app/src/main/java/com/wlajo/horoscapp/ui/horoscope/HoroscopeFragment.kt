package com.wlajo.horoscapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wlajo.horoscapp.databinding.FragmentHoroscopeBinding
import com.wlajo.horoscapp.domain.model.HoroscopeInfo
import com.wlajo.horoscapp.domain.model.HoroscopeInfo.*
import com.wlajo.horoscapp.domain.model.HoroscopeModel
import com.wlajo.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val zodiac = when (it) {
                Aquarius -> HoroscopeModel.Aries
                Aries -> HoroscopeModel.Taurus
                Cancer -> HoroscopeModel.Gemini
                Capricorn -> HoroscopeModel.Cancer
                Gemini -> HoroscopeModel.Leo
                Leo -> HoroscopeModel.Virgo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Scorpio
                Sagitarius -> HoroscopeModel.Sagitarius
                Scorpio -> HoroscopeModel.Capricorn
                Taurus -> HoroscopeModel.Aquarius
                Virgo -> HoroscopeModel.Pisces
            }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(zodiac)
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {horoscopeList ->
                    horoscopeAdapter.updateList(horoscopeList)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}