package presentation.base


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel() : ViewModel() {

    val exceptionLiveData = MutableStateFlow<String?>(null)
    val progressVisibilityLiveData = MutableStateFlow(false)

    fun showProgress() {
        progressVisibilityLiveData.value = true
    }

    fun hideProgress() {
        progressVisibilityLiveData.value = false
    }

    protected fun launch(
        onError: (Throwable, suspend CoroutineScope.() -> Unit) -> Any? = ::onError,
        block: suspend CoroutineScope.() -> Unit,
    ): Job = viewModelScope.launch(CoroutineExceptionHandler { _, exception ->
        onError(exception, block)
    }) {
        withContext(Dispatchers.Unconfined) {
            block()
        }
    }

    protected open fun onError(throwable: Throwable, block: suspend CoroutineScope.() -> Unit) {
        hideProgress()
        throwable.printStackTrace()
        println("exceptionTAG BaseViewModel onError throwable ${throwable.message}")
        exceptionLiveData.value = throwable.message.orEmpty()
    }
}