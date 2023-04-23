package com.sam.manualdi.data

import com.sam.manualdi.model.FreeTip
import kotlinx.coroutines.flow.Flow

interface FreeTipRepository {

    fun freeTips(): Flow<List<FreeTip>>

}