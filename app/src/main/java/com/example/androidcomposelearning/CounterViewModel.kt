package com.example.androidcomposelearning

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    val count = mutableIntStateOf(0)

    fun increase() {
        count.intValue++
    }

    fun decrease() {
        count.intValue--
    }
}