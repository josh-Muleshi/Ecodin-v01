@file:OptIn(ExperimentalCoroutinesApi::class)

package cd.wapupdotdev.util.extension

import cd.wapupdotdev.util.Result
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber


inline fun <reified T> DocumentReference.collectAsFlow(): Flow<Result<T>> {
    return callbackFlow {
        addSnapshotListener { value, error ->
            if (error != null || value == null) {
                if (!isClosedForSend) {
                    Timber.e(error)
                    trySend(Result.Error(Exception(error)))
                }
                close(error)
                return@addSnapshotListener
            }

            if (!isClosedForSend) {
                try {
                    value.toObject<T>()?.let { data -> trySend(Result.Success(data)) }
                } catch (e: Exception) {
                    close(e)
                    Timber.e(e)
                    trySend(Result.Error(Exception(e)))
                }
            }
        }
        awaitClose()
    }
}

inline fun <reified T> DocumentReference.collectAsFlowNullable(): Flow<Result<T?>> {
    return callbackFlow {
        addSnapshotListener { value, error ->
            if (error != null || value == null) {
                if (!isClosedForSend) {
                    Timber.e(error)
                    trySend(Result.Error(Exception(error)))
                }
                close(error)
                return@addSnapshotListener
            }

            if (!isClosedForSend) {
                try {
                    trySend(Result.Success(value.toObject<T>()))
                } catch (e: Exception) {
                    close(e)
                    Timber.e(e)
                    trySend(Result.Error(Exception(e)))
                }
            }
        }
        awaitClose()
    }
}


inline fun <reified T : Any> Query.collectAsFlow(
    crossinline action: ((List<T>) -> List<T>) = { data -> data }
): Flow<Result<List<T>>> {
    return callbackFlow {
        addSnapshotListener { value, error ->
            if (error != null || value == null) {
                if (!isClosedForSend) {
                    Timber.e(error)
                    trySend(Result.Error(Exception(error)))
                }
                close(error)
                return@addSnapshotListener
            }

            if (!isClosedForSend) {
                try {
                    trySend(Result.Success(action(value.filterValidItem())))
                } catch (e: Exception) {
                    close(e)
                    Timber.e(e)
                    trySend(Result.Error(Exception(e)))
                }
            }
        }
        awaitClose()
    }
}

inline fun <reified T: Any> QuerySnapshot.filterValidItem(): List<T> {
    return buildList {
        for (doc in this@filterValidItem) {
            try {
                add(doc.toObject())
            } catch (e: Exception) {
                continue
            }
        }
    }
}
