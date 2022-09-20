package com.joshMuleshi.ecodim.presentation.auth.business

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joshMuleshi.ecodim.data.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val studentRepository: StudentRepository,
    private val sharedPreferences: SharedPreferences
    ) : ViewModel() {

    private val _state = MutableStateFlow<AuthState>(AuthState.Uninitialized)
    val state: StateFlow<AuthState>
        get() = _state

    @ExperimentalCoroutinesApi
    fun register(email: String, password: String) = viewModelScope.launch {
        _state.emit(AuthState.Loading)
        try {
            studentRepository.register(email, password)
            val editor = sharedPreferences.edit()
            editor.apply {
                putBoolean("is-auth", true)
            }.apply()
            _state.emit(AuthState.Success)
        } catch (t: Throwable) {
            _state.emit(AuthState.Error(t.message.toString()))
        }
    }
}