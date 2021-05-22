package com.leveloper.scottish.domain.repository

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.model.Sample

interface SampleRepository {
    fun insert(value: String): Result<Sample>
}