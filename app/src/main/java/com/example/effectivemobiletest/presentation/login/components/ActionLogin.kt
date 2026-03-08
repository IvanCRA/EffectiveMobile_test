package com.example.effectivemobiletest.presentation.login.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun ActionLogin(
    onRegisterClick: () -> Unit,
) {
    val annotatedText =
        buildAnnotatedString {
            append("Нету аккаунта? ")

            pushStringAnnotation(
                tag = "REGISTER",
                annotation = "register",
            )

            withStyle(
                style =
                    SpanStyle(
                        color = MaterialTheme.colorScheme.secondary,
                    ),
            ) {
                append("Регистрация")
            }

            pop()
        }

    ClickableText(
        text = annotatedText,
        style =
            MaterialTheme.typography.displaySmall.copy(
                color = MaterialTheme.colorScheme.onBackground,
            ),
        onClick = { offset ->

            annotatedText
                .getStringAnnotations(
                    tag = "REGISTER",
                    start = offset,
                    end = offset,
                )
                .firstOrNull()?.let {
                    onRegisterClick()
                }
        },
    )
}
