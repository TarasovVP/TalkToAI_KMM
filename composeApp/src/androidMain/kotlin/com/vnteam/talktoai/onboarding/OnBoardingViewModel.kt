package com.vnteam.talktoai.onboarding

import android.app.Application
import com.vnteam.talktoai.base.BaseViewModel
import domain.usecases.OnBoardingUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class OnBoardingViewModel(
    application: Application,
    private val onBoardingUseCase: OnBoardingUseCase,
) : BaseViewModel(application) {

    val onBoardingSeenLiveData = MutableStateFlow(false)

    fun setOnBoardingSeen() {
        launch {
            onBoardingUseCase.setOnBoardingSeen(true)
            onBoardingSeenLiveData.value = true
        }
    }
}