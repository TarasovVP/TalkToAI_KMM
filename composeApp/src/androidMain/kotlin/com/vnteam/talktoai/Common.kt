package com.vnteam.talktoai

import android.text.TextPaint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.MutableLiveData
import domain.Constants.ERROR_MESSAGE
import domain.models.InfoMessage
import theme.Primary300
import theme.Primary700
import kotlin.math.ceil
import kotlin.math.roundToInt

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
fun OrDivider(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .weight(1f)
                .background(Primary300)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "Или",
            fontSize = 16.sp,
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .wrapContentSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .weight(1f)
                .background(Primary300)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun ShapeableImage(modifier: Modifier, drawableResId: Int, contentDescription: String) {
    ContextCompat.getDrawable(LocalContext.current, drawableResId)?.toBitmap()?.asImageBitmap()
        ?.let { painterResource(id = drawableResId) }?.let {
        Image(
            painter = it,
            contentDescription = contentDescription,
            modifier = modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Primary700),
            contentScale = ContentScale.Inside
        )
    }
}

@Composable
fun EmptyState(text: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text, textAlign = TextAlign.Center, modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Primary300, shape = RoundedCornerShape(18.dp))
                .padding(16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.empty_state),
            contentDescription = "Empty state",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 16.dp)
        )
    }
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
fun textLinesCount(text: String, paddings: Float, textSize: Float) : Int {
    val charsInLine = charsInLine(paddings, textSize)
    return charsInLine.takeIf { it > 0 }?.let { ceil((text.length / it).toDouble()).toInt() } ?: 1
}

@Composable
fun charsInLine(paddings: Float, textSize: Float) : Float {
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