package com.example.effectivemobiletest.domain.usecase

import com.example.effectivemobiletest.domain.repository.CoursesRepository
import javax.inject.Inject

class GetCoursesUseCase @Inject constructor(
    private val coursesRepository: CoursesRepository
) {
    suspend operator fun invoke() = coursesRepository.getCourses()
}
