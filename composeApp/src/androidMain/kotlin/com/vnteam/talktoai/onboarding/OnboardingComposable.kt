package com.vnteam.talktoai.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vnteam.talktoai.stringRes
import components.PrimaryButton
import components.painterRes
import domain.models.ScreenState
import domain.sealed_classes.NavigationScreen
import org.koin.androidx.compose.koinViewModel
import resources.DrawableResources
import theme.Neutral50
import theme.Primary500

@Composable
fun OnboardingContent(screenState: ScreenState) {

    val viewModel: OnBoardingViewModel = koinViewModel()
    val pageState = remember {
        mutableIntStateOf(0)
    }
    val onBoardingSeenState = viewModel.onBoardingSeenLiveData.collectAsState()
    LaunchedEffect(onBoardingSeenState.value) {
        if (onBoardingSeenState.value) {
            screenState.currentScreenState.value = NavigationScreen.LoginScreen().route
            viewModel.onBoardingSeenLiveData.value = false
        }
    }
    OnboardingPage(pageState.value) {
        if (pageState.value == 3) {
            viewModel.setOnBoardingSeen()
        } else {
            pageState.value++
        }
    }
}

@Composable
fun OnboardingPage(page: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .background(color = Primary500, shape = RoundedCornerShape(16.dp))
        ) {
            Text(
                text = when (page) {
                    1 -> stringRes().ONBOARDING_INTRO
                    2 -> stringRes().ONBOARDING_FILTER_CONDITIONS
                    3 -> stringRes().ONBOARDING_INFO
                    else -> stringRes().ONBOARDING_PERMISSIONS
                },
                textAlign = TextAlign.Center,
                color = Neutral50,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        Image(
            painter = painterRes(DrawableResources.ONBOARDING_INTRO),
            contentDescription = stringRes().ONBOARDING_ICON,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 16.dp)
        )
        Image(
            painter = painterRes(
                when (page) {
                    1 -> DrawableResources.IC_TAB_TWO
                    2 -> DrawableResources.IC_TAB_THREE
                    3 -> DrawableResources.IC_TAB_FOUR
                    else -> DrawableResources.IC_TAB_ONE
                }
            ), contentDescription = "${stringRes().ONBOARDING_SCREEN} $page", modifier = Modifier
                .fillMaxWidth()
        )
        PrimaryButton(
            text = if (page == 3) stringRes().AUTHORIZATION_ENTER else stringRes().BUTTON_NEXT,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            onClick = onClick
        )
    }
}