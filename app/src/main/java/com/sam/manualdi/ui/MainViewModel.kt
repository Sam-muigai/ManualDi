package com.sam.manualdi.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sam.manualdi.data.FreeTipRepository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.sam.manualdi.ManualDiApplication
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    private val freeTipRepository: FreeTipRepository
):ViewModel(){
    val freeTips = freeTipRepository.freeTips()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

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