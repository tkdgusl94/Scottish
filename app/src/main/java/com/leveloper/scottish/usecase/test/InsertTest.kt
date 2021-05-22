package com.leveloper.scottish.usecase.test

import com.leveloper.library.utils.Result
import com.leveloper.scottish.repository.TestRepository
import com.leveloper.scottish.usecase.UseCase
import javax.inject.Inject

class InsertTest @Inject constructor(
    private val testRepository: TestRepository
) : UseCase<Long, InsertTest.Param>() {

    override suspend fun run(params: Param): Result<Long> {
        return testRepository.insert(params.value)
    }

    data class Param(val value: String)
}