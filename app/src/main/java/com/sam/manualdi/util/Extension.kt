package com.sam.manualdi.util

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun String.getOutcome():String{
    return when(this){
        " X" -> "Draw"
        " 1" -> "Home"
        " 2" -> "Away"
        else -> this
    }
}

fun Modifier.smallPadding(): Modifier {
    return padding(4.dp)
}