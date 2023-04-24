package com.sam.manualdi

import com.sam.manualdi.model.FreeTip

data class UiState(
    val loading:Boolean = false,
    val data:List<FreeTip> = emptyList()
)
