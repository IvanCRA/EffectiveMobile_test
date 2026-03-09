package com.example.effectivemobiletest.data.local.mapper

import com.example.effectivemobiletest.data.local.entity.FavoriteCourseEntity
import com.example.effectivemobiletest.domain.model.Course

fun Course.toFavoriteEntity(): FavoriteCourseEntity {
    return FavoriteCourseEntity(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = true,
        publishDate = publishDate,
    )
}

fun FavoriteCourseEntity.toDomain(): Course {
    return Course(
        id = id,
        title = title,
        text = text,
        price = price,
        rate = rate,
        startDate = startDate,
        hasLike = true,
        publishDate = publishDate,
    )
}
