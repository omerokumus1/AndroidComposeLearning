package com.example.androidcomposelearning

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val networkState = mutableStateOf(NetworkState.NONE)

    private val _categoryState = mutableStateOf<CategoriesResponse?>(null)
    val categoryState: State<CategoriesResponse?> = _categoryState


    fun fetchCategories() {
        viewModelScope.launch {
            networkState.value = NetworkState.LOADING
            try {
                val response = recipeService.getCategories()
                _categoryState.value = response
                networkState.value = NetworkState.SUCCESS
            } catch (e: Exception) {
                networkState.value = NetworkState.ERROR
            }

        }
    }
}


enum class NetworkState {
    NONE,
    LOADING,
    SUCCESS,
    ERROR
}