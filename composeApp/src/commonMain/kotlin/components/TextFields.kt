package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.CommonExtensions.EMPTY
import theme.Neutral600
import theme.Primary500
import theme.Primary900

@Composable
fun PrimaryTextField(
    placeHolder: String,
    inputValue: MutableState<TextFieldValue>,
) {
    TextField(value = inputValue.value,
        onValueChange = { newValue ->
            inputValue.value = newValue
        }, placeholder = { Text(text = placeHolder) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Primary500, shape = RoundedCornerShape(16.dp))
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ),
        maxLines = 1
    )
}

@Composable
fun SecondaryTextField(
    inputValue: MutableState<TextFieldValue>,
    placeHolder: String,
) {
    TextField(
        value = inputValue.value,
        onValueChange = { inputValue.value = it },
        placeholder = { Text(text = placeHolder) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun PasswordTextField(inputValue: MutableState<TextFieldValue>, placeHolder: String) {
    val passwordVisible = remember { mutableStateOf(false) }

    TextField(
        value = inputValue.value,
        onValueChange = { newValue ->
            inputValue.value = newValue
        },
        placeholder = { Text(text = placeHolder) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Primary500, shape = RoundedCornerShape(16.dp))
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ),
        maxLines = 1,
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = { passwordVisible.value = passwordVisible.value.not() }
            ) {
                Icon(
                    painter = painterRes(if (passwordVisible.value) "ic_toggle_password_enabled" else "ic_toggle_password_disabled"),
                    contentDescription = if (passwordVisible.value) "Hide password" else "Show password"
                )
            }
        }
    )
}

@Composable
fun TextFieldWithButton(
    isEnabled: Boolean,
    onSendClick: (String) -> Unit,
) {

    val inputValue: MutableState<TextFieldValue> = remember {
        mutableStateOf(TextFieldValue())
    }

    val focusManager = LocalFocusManager.current
    LaunchedEffect(inputValue.value) {
        if (inputValue.value.text.isEmpty()) focusManager.clearFocus()
    }

    TextField(value = inputValue.value,
        onValueChange = { newValue ->
            inputValue.value = newValue
        }, placeholder = { Text(text = "Enter request") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                1.dp,
                if (isEnabled) Primary500 else Neutral600,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(enabled = isEnabled) {},
        maxLines = 6,
        trailingIcon = {
            IconButton(enabled = isEnabled && inputValue.value.text.isNotBlank(), onClick = {
                onSendClick.invoke(inputValue.value.text.trim())
                inputValue.value = TextFieldValue(String.EMPTY)
            }) {
                Icon(
                    painter = painterRes("ic_message_send"),
                    contentDescription = "Send message button",
                    tint = if (isEnabled) Primary900 else Neutral600
                )
            }
        }
    )
}

@Composable
fun TruncatableText(
    message: String,
    isTruncated: MutableState<Boolean>,
    linesCount: Int,
) {
    Column(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()) {
        Text(
            text = message,
            //TODO uncomment
            //fontSize = getDimensionResource(resId = R.dimen.default_text_size).value.sp,
            color = Color.White,
            maxLines = if (isTruncated.value) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis
        )
        if (linesCount > 2) {
            Text(text = if (isTruncated.value) "More" else "Hide",
                color = Color.LightGray,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .clickable(onClick = {
                        isTruncated.value = isTruncated.value.not()
                    })
            )
        }
    }
}