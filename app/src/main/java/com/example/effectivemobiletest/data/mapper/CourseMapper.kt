package com.example.effectivemobiletest.data.mapper

import com.example.effectivemobiletest.data.model.CourseDto
import com.example.effectivemobiletest.domain.model.Course

fun CourseDto.toDomain(): Course{
    return Course(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = hasLike,
        publishDate = publishDate
    )
}
