package com.vnteam.talktoai

import android.text.TextPaint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import domain.Constants.ERROR_MESSAGE
import domain.models.InfoMessage
import resources.StringResources
import resources.getStringResourcesByLocale
import kotlin.math.ceil

@Composable
fun ExceptionMessageHandler(
    messageState: MutableState<InfoMessage?>,
    exceptionLiveData: MutableLiveData<String>,
) {
    val exceptionState = exceptionLiveData.observeAsState()
    LaunchedEffect(exceptionState.value) {
        exceptionState.value.takeIf { exceptionState.value.isNullOrEmpty().not() }?.let {
            messageState.value = InfoMessage(
                exceptionState.value.orEmpty(),
                ERROR_MESSAGE
            )
            exceptionLiveData.value = null
        }
    }
}

@Composable
fun ProgressVisibilityHandler(
    progressVisibilityState: MutableState<Boolean>,
    progressVisibilityLiveData: MutableLiveData<Boolean>,
) {
    val progressProcessState = progressVisibilityLiveData.observeAsState()
    LaunchedEffect(progressProcessState.value) {
        progressProcessState.value?.let {
            progressVisibilityState.value = it
        }
    }
    Log.e(
        "progressTAG",
        "Common ProgressVisibilityHandler progressVisibilityState ${progressVisibilityState.value} progressVisibilityLiveData ${progressVisibilityLiveData.value}"
    )
}

@Composable
fun MainProgress(progressVisibilityState: MutableState<Boolean>) {
    Log.e(
        "progressTAG",
        "Common MainProgress progressVisibilityState ${progressVisibilityState.value}"
    )
    if (progressVisibilityState.value) {
        /*Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = Primary700,
                strokeWidth = 5.dp
            )
        }*/
        //TODO uncomment
        /*val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.main_progress))
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()) {
            LottieAnimation(
                composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .fillMaxSize(0.6f)
            )
        }*/
    }
}

@Composable
fun textLinesCount(text: String, paddings: Float, textSize: Float): Int {
    val charsInLine = charsInLine(paddings, textSize)
    return charsInLine.takeIf { it > 0 }?.let { ceil((text.length / it).toDouble()).toInt() } ?: 1
}

@Composable
fun charsInLine(paddings: Float, textSize: Float): Float {
    val screenWidth = measureScreenWidth() - paddings
    val charWidth = measureCharWidth(textSize)
    return charWidth.takeIf { it > 0 }?.let { screenWidth / it } ?: 0f
}

@Composable
fun measureScreenWidth(): Float {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp
    return screenWidthDp.value
}

@Composable
fun measureCharWidth(textSize: Float): Float {
    val density = LocalDensity.current.density
    val textPaint = TextPaint().apply {
        this.textSize = textSize * density
    }
    return textPaint.measureText(" ")
}

@Composable
fun getDimensionResource(resId: Int): Dp {
    val resources = LocalContext.current.resources
    val density = LocalDensity.current.density
    val sizeInPixels = resources.getDimension(resId)
    return (sizeInPixels / density).dp
}

@Composable
fun stringRes(): StringResources {
    return getStringResourcesByLocale(Locale.current.language)
}