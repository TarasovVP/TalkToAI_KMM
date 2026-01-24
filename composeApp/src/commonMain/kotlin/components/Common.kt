package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.Constants.ERROR_MESSAGE
import domain.models.InfoMessage
import kotlinx.coroutines.flow.MutableStateFlow
import resources.StringResources
import resources.getStringResourcesByLocale
import theme.Primary300
import theme.Primary700
import kotlin.math.ceil


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
fun ShapeableImage(
    icon: Painter,
    modifier: Modifier,
    drawableResId: Int,
    contentDescription: String,
) {
    Image(
        painter = icon,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(Primary700),
        contentScale = ContentScale.Inside
    )
}

@Composable
fun EmptyState(text: String, icon: Painter, modifier: Modifier) {
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
            painter = icon,
            contentDescription = "Empty state",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 16.dp)
        )
    }
}

@Composable
fun ExceptionMessageHandler(
    messageState: MutableState<InfoMessage?>,
    exceptionStateFlow: MutableStateFlow<String>,
) {
    val exceptionState = exceptionStateFlow.collectAsState()
    LaunchedEffect(exceptionState.value) {
        exceptionState.value.takeIf { exceptionState.value.isNotEmpty() }?.let {
            messageState.value = InfoMessage(
                exceptionState.value.orEmpty(),
                ERROR_MESSAGE
            )
            exceptionStateFlow.value = null
        }
    }
}

@Composable
fun ProgressVisibilityHandler(
    progressVisibilityState: MutableState<Boolean>,
    progressVisibilityStateFlow: MutableStateFlow<Boolean>,
) {
    val progressProcessState = progressVisibilityStateFlow.collectAsState()
    LaunchedEffect(progressProcessState.value) {
        progressVisibilityState.value = progressProcessState.value
    }
    println(
        "progressTAG Common ProgressVisibilityHandler progressVisibilityState ${progressVisibilityState.value} progressVisibilityLiveData ${progressVisibilityStateFlow.value}"
    )
}

@Composable
fun MainProgress(progressVisibilityState: MutableState<Boolean>) {
    println(
        "progressTAG Common MainProgress progressVisibilityState ${progressVisibilityState.value}"
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