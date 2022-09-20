package com.joshMuleshi.ecodim.presentation.auth.business

sealed class AuthState {
    object Uninitialized: AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
    object Success: AuthState()
}