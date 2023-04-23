package com.sam.manualdi

import com.sam.manualdi.data.FreeTipRepository
import com.sam.manualdi.data.FreeTipRepositoryImpl


interface AppContainer{
    val freeTipsRepository : FreeTipRepository
}

class DefaultAppContainer():AppContainer{
    override val freeTipsRepository: FreeTipRepository
        get() = FreeTipRepositoryImpl()
}