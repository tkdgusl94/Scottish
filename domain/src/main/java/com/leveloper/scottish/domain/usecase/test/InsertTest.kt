package com.leveloper.scottish.domain.usecase.test

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.model.Sample
import com.leveloper.scottish.domain.repository.SampleRepository
import com.leveloper.scottish.domain.usecase.UseCase
import javax.inject.Inject

class InsertTest @Inject constructor(
    private val sampleRepository: SampleRepository
) : UseCase<Sample, InsertTest.Param>() {

    override suspend fun run(params: Param): Result<Sample> {
        return sampleRepository.insert(params.value)
    }

    data class Param(val value: String)
}