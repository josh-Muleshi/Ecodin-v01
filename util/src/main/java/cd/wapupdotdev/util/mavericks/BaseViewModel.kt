package cd.wapupdotdev.util.mavericks

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S: MavericksState, A: Any>(
    val initialState: S
) : MavericksViewModel<S>(initialState) {
    protected val pendingActions = MutableSharedFlow<A>()

    fun submitAction(action: A){
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }
}

abstract class BaseViewModelV2<S : MavericksState, A : Any, E: Any>(
    val initialState: S
) : MavericksViewModel<S>(initialState) {

    protected val pendingActions = MutableSharedFlow<A>()
    private val sideEffects = Channel<E>(Channel.BUFFERED)

    val effects: Flow<E>
        get() = sideEffects.receiveAsFlow()

    fun submitAction(action: A) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    fun sendEffect(sideEffect: E) {
        viewModelScope.launch {
            sideEffects.trySend(sideEffect)
        }
    }
}