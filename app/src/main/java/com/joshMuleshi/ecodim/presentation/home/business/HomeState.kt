package com.joshMuleshi.ecodim.presentation.home.business

import com.joshMuleshi.ecodim.data.model.Student

sealed class HomeState {
    object Uninitialized: HomeState()
    object Loading : HomeState()
    data class Error(val message: String) : HomeState()
    data class Success(val student: Student?) : HomeState()
}