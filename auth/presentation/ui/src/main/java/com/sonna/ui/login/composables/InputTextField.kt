package com.sonna.ui.login.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sonna.common.composables.BaseTextField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputTextField(
    label: String = "label",
    placeholder: String = "placeholder",
    isValid: Boolean = false,
    errorMessage: String = "errorMessage",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: ImageVector? = null,
    onTrailingClick: () -> Unit = {},
) {
    Column {
        Text(text = label, style = MaterialTheme.typography.titleLarge)
        BaseTextField(
            placeholder = placeholder,
            trailingIcon = trailingIcon,
            onTrailingClick = onTrailingClick,
            visualTransformation = visualTransformation
        )
        if (isValid) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.labelSmall.copy(color = Color.Red)
            )
        }
    }
}

@Preview
@Composable
fun InputTextFieldPreview() {
    InputTextField()
}