package com.example.effectivemobiletest.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletest.R
import com.example.effectivemobiletest.ui.theme.Glass

@Composable
fun RatingBadge(
    rate: String,
    date: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .height(22.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BadgeChip(
            iconRes = R.drawable.star_rate_icon,
            text = rate,
            iconTint = MaterialTheme.colorScheme.secondary,
        )

        BadgeChip(
            text = date,
        )
    }
}

@Composable
private fun BadgeChip(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null,
    iconTint: Color = MaterialTheme.colorScheme.onPrimary,
) {
    val gradientBrush =
        Brush.horizontalGradient(
            colors = listOf(Glass, Glass),
            startX = 15.0f,
            endX = 16.0f,
        )
    Row(
        modifier =
            modifier
                .clip(RoundedCornerShape(24.dp))
                .background(brush = gradientBrush)
                .padding(horizontal = 6.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (iconRes != null) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(16.dp),
            )
        }

        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}
