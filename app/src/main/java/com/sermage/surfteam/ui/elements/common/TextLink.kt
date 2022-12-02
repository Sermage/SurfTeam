package com.sermage.surfteam.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sermage.surfteam.ui.theme.Blue
import com.sermage.surfteam.ui.theme.SurfTeamTheme

private const val URL_TAG = "URL"

@Composable
fun TextLink(
    modifier: Modifier = Modifier,
    text: String,
    link: String,
) {
    val annotatedText = buildAnnotatedString {

        pushStringAnnotation(tag = URL_TAG, annotation = link)
        withStyle(
            SpanStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append(text)
        }
        pop()
    }
    val uriHandler = LocalUriHandler.current
    val density = LocalDensity.current
    var textWidth by remember { mutableStateOf(0.dp) }

    Column(modifier = modifier) {
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = URL_TAG, start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        uriHandler.openUri(annotation.item)
                    }
            },
            onTextLayout = {
                with(density) {
                    textWidth = it.size.width.toDp()
                }
            })
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 8f), 0f)

        Canvas(
            modifier = Modifier
                .width(textWidth)
                .height(4.dp)
        ) {
            drawLine(
                color = Blue,
                strokeWidth = 2f,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TextLinkPreview() {
    SurfTeamTheme {
        TextLink(text = "ссылка на гитхаб", link = "link")
    }
}