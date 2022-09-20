package com.joshMuleshi.ecodim.data.repository

import com.joshMuleshi.ecodim.data.model.Student
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ResultatRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) {
    private val currentUser by lazy {
        firebaseAuth.currentUser
    }

    fun getResult() = callbackFlow{
        firestore.collection("users").document(currentUser!!.uid)
            .addSnapshotListener { value, error ->
                if (error != null && value == null) {
                    close(error)
                }

                trySend(value?.toObject<Student>())
            }
        awaitClose()
        }.catch {
            throw it
        }.flowOn(Dispatchers.IO)
}

