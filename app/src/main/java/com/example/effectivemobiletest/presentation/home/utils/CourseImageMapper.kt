package com.example.effectivemobiletest.presentation.home.utils

import com.example.effectivemobiletest.R

fun getCourseImage(id: Int): Int {
    return when (id) {
        1 -> R.drawable.cover
        2 -> R.drawable.cover
        else -> R.drawable.cover
    }
}
