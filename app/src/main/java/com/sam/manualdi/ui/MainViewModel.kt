package com.sam.manualdi.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sam.manualdi.data.FreeTipRepository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.sam.manualdi.ManualDiApplication
import com.sam.manualdi.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val freeTipRepository: FreeTipRepository
):ViewModel(){
    private var _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        getFreeTips()
    }

    private fun getFreeTips(){
        viewModelScope.launch(Dispatchers.IO){
            _uiState.value = _uiState.value.copy(
                loading = true
            )
            try {
                freeTipRepository.freeTips().collect{
                    val games = it.filter {freeTip ->
                        freeTip.league != ""
                    }
                    _uiState.value = _uiState.value.copy(
                        loading = false,
                        data = games
                    )
                }
            }catch (e :Exception){
                _uiState.value = _uiState.value.copy(
                    loading = false
                )
            }
        }
    }

    companion object{
        val factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ManualDiApplication)
                val freeTipRepository = application.container.freeTipsRepository
                MainViewModel(freeTipRepository)
            }
        }
    }
}