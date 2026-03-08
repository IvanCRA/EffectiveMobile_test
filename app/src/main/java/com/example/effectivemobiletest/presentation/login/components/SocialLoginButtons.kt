package com.example.effectivemobiletest.presentation.login.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletest.R
import com.example.effectivemobiletest.ui.theme.OkColor
import com.example.effectivemobiletest.ui.theme.VkColor
import com.example.effectivemobiletest.ui.theme.White

private const val VK_URL = "https://vk.com/"
private const val OK_URL = "https://ok.ru/"

@Composable
fun SocialLoginButtons() {
    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        IconButton(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(60.dp),
            colors =
                IconButtonDefaults.iconButtonColors(
                    containerColor = VkColor,
                    contentColor = White,
                ),
            onClick = {
                openUrl(context, url = VK_URL)
            },
        ) {
            Icon(
                painter = painterResource(R.drawable.vk_icon),
                contentDescription = "VK",
            )
        }

        IconButton(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(60.dp),
            colors =
                IconButtonDefaults.iconButtonColors(
                    containerColor = OkColor,
                    contentColor = White,
                ),
            onClick = {
                openUrl(context, url = OK_URL)
            },
        ) {
            Icon(
                painter = painterResource(R.drawable.ok_icon),
                contentDescription = "Одноклассники",
            )
        }
    }
}

private fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
