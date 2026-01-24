package presentation.onboarding

import presentation.base.BaseViewModel
import domain.usecases.OnBoardingUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class OnBoardingViewModel(
    private val onBoardingUseCase: OnBoardingUseCase,
) : BaseViewModel() {

    val onBoardingSeenStateFlow = MutableStateFlow(false)

    fun setOnBoardingSeen() {
        launch {
            onBoardingUseCase.setOnBoardingSeen(true)
            onBoardingSeenStateFlow.value = true
        }
    }
}