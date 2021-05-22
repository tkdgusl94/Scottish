package com.leveloper.scottish.domain.repository

import com.leveloper.library.utils.Result

interface TestRepository {
    fun insert(value: String): Result<Long>
}