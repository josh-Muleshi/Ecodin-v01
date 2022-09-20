package com.joshMuleshi.ecodim.data.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StudentRepository @Inject constructor(private val firebaseAuth: FirebaseAuth) {
    suspend fun register(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
    }
}