package com.example.effectivemobiletest.domain.repository

import com.example.effectivemobiletest.domain.model.Course

interface CoursesRepository {
    suspend fun getCourses(): List<Course>
}
