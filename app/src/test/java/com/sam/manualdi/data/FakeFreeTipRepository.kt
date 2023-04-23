package com.sam.manualdi.data

import com.sam.manualdi.model.FreeTip
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FakeFreeTipRepository : FreeTipRepository {


    private val fakeTips = mutableListOf<FreeTip>()

    fun addFakeTip(tip: FreeTip) {
        fakeTips.add(tip)
    }

    override fun freeTips(): Flow<List<FreeTip>> {
        return flow {
            emit(fakeTips)
        }
    }
}