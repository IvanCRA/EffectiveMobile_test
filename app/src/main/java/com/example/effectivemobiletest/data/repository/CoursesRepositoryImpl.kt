package com.example.effectivemobiletest.data.repository

import com.example.effectivemobiletest.data.mapper.toDomain
import com.example.effectivemobiletest.data.remote.ApiService
import com.example.effectivemobiletest.domain.model.Course
import com.example.effectivemobiletest.domain.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CoursesRepository {
    override suspend fun getCourses(): List<Course> {
        return apiService.getCourses().courses.map { it.toDomain() }
    }
}
