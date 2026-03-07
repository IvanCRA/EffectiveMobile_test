package com.example.effectivemobiletest.data.repository

import com.example.effectivemobiletest.domain.repository.GreetingRepository
import javax.inject.Inject

class GreetingRepositoryImpl @Inject constructor() : GreetingRepository {
    override fun getGreeting(): String = "Hilt + Clean Architecture works"
}