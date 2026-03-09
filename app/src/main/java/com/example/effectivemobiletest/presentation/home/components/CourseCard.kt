package com.example.effectivemobiletest.presentation.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletest.R
import com.example.effectivemobiletest.domain.model.Course
import com.example.effectivemobiletest.presentation.home.utils.formatPublishDate
import com.example.effectivemobiletest.presentation.home.utils.getCourseImage
import com.example.effectivemobiletest.ui.theme.Glass

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CourseCard(
    course: Course,
    onFavoriteClick: (() -> Unit)? = null,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surface)
                .height(236.dp),
    ) {
        Box {
            Image(
                painter = painterResource(getCourseImage(course.id)),
                contentDescription = course.title,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(114.dp)
                        .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
            )

            RatingBadge(
                rate = course.rate,
                date = formatPublishDate(course.publishDate),
                modifier =
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 12.dp, bottom = 12.dp),
            )

            Box(
                modifier =
                    Modifier
                        .padding(top = 6.dp, end = 6.dp)
                        .align(Alignment.TopEnd)
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(Glass)
                        .clickable {
                            onFavoriteClick?.invoke()
                        },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter =
                        if (course.hasLike) {
                            painterResource(R.drawable.bookmark_enabled_icon)
                        } else {
                            painterResource(R.drawable.bookmark_icon)
                        },
                    contentDescription = "Favorite",
                    tint =
                        if (course.hasLike) {
                            MaterialTheme.colorScheme.secondary
                        } else {
                            MaterialTheme.colorScheme.onPrimary
                        },
                )
            }
        }

        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = course.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = course.text,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = course.price + " ₽",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium,
                )
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Подробнее",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.displaySmall,
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(R.drawable.more_icon),
                        contentDescription = "More",
                        tint = MaterialTheme.colorScheme.secondary,
                        // modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
