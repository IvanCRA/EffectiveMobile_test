package com.example.effectivemobiletest.domain.usecase

import com.example.effectivemobiletest.domain.repository.GreetingRepository
import javax.inject.Inject

class GetGreetingUseCase @Inject constructor(
    private val repository: GreetingRepository,
) {
    operator fun invoke(): String = repository.getGreeting()
}
