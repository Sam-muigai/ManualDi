package com.sam.manualdi.data

import com.sam.manualdi.model.FreeTip
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FreeTipRepositoryImpl:FreeTipRepository{
    override fun freeTips():Flow<List<FreeTip>> = flow {
        val freeTip = FreeTipsApi.getTips.getFreeTips()
        emit(freeTip.freeTips)
    }
}