package com.sermage.surfteam.ui.elements.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sermage.surfteam.data.employees
import com.sermage.surfteam.ui.elements.common.OverlappingRow
import com.sermage.surfteam.ui.theme.SurfTeamTheme
import com.sermage.surfteam.ui.theme.White

private const val MAX_SIZE = 3

@Composable
fun AvatarRow(
    modifier: Modifier = Modifier,
    photos: List<String>,
    photoSize: Int = 34,
) {
    OverlappingRow(
        modifier = modifier,
        overlapFactor = 0.7f
    ) {
        photos.forEachIndexed { index, photoUrl ->
            if (index < MAX_SIZE) {
                Image(
                    painter = rememberImagePainter(data = photoUrl) {
                        transformations(CircleCropTransformation())
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .size(photoSize.dp)
                        .border(width = 1.dp, color = White, shape = CircleShape)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AvatarsRowPreview() {
    SurfTeamTheme {
        AvatarRow(photos = employees.map { it.photoUrl })
    }
}