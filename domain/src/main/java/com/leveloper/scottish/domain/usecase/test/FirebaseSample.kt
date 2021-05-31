package com.leveloper.scottish.domain.usecase.test

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.repository.SampleRepository
import com.leveloper.scottish.domain.usecase.UseCase
import javax.inject.Inject

class FirebaseSample @Inject constructor(
    private val sampleRepository: SampleRepository
) : UseCase<Unit, Unit>() {

    override suspend fun run(params: Unit): Result<Unit> {
        sampleRepository.abc()
        return Result.Success(Unit)
    }
}