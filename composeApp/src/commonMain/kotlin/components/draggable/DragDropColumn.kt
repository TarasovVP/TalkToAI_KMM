package components.draggable

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T : Any> DragDropColumn(
    modifier: Modifier,
    items: List<T>,
    onSwap: (Int, Int) -> Unit,
    onDragEnd: () -> Unit,
    itemContent: @Composable LazyItemScope.(item: T, isDragging: Boolean) -> Unit,
) {
    val overscrollJob = remember { mutableStateOf<Job?>(null) }
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val dragDropState = rememberDragDropState(listState) { fromIndex, toIndex ->
        onSwap(fromIndex, toIndex)
    }

    UpdateViewConfiguration(
        longPressTimeoutMillis = 200L
    ) {

        LazyColumn(
            modifier = modifier
                .pointerInput(dragDropState) {
                    detectDragGesturesAfterLongPress(
                        onDrag = { change, offset ->
                            change.consume()
                            dragDropState.onDrag(offset = offset)

                            if (overscrollJob.value?.isActive == true)
                                return@detectDragGesturesAfterLongPress

                            dragDropState
                                .checkForOverScroll()
                                .takeIf { it != 0f }
                                ?.let {
                                    overscrollJob.value =
                                        scope.launch {
                                            dragDropState.state.animateScrollBy(
                                                it * 1.3f, tween(easing = FastOutLinearInEasing)
                                            )
                                        }
                                }
                                ?: run { overscrollJob.value?.cancel() }
                        },
                        onDragStart = { offset -> dragDropState.onDragStart(offset) },
                        onDragEnd = {
                            dragDropState.onDragInterrupted()
                            overscrollJob.value?.cancel()
                            onDragEnd.invoke()
                        },
                        onDragCancel = {
                            dragDropState.onDragInterrupted()
                            overscrollJob.value?.cancel()
                            onDragEnd.invoke()
                        }
                    )
                },
            state = listState,
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items = items) { index, item ->
                DraggableItem(
                    dragDropState = dragDropState,
                    index = index, Modifier
                ) { isDragging ->
                    itemContent(item, isDragging)
                }
            }
        }
    }
}