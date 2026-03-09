package com.example.effectivemobiletest.presentation.home.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun formatPublishDate(date: String): String {
    val localDate = LocalDate.parse(date)

    val formatter =
        DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            Locale("ru"),
        )

    val formatted = localDate.format(formatter)

    return formatted.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale("ru")) else it.toString()
    }
}
