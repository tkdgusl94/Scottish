package com.leveloper.scottish.domain.usecase.test

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.UnitTest
import com.leveloper.scottish.domain.model.Sample
import com.leveloper.scottish.domain.repository.SampleRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class InsertSampleTest : UnitTest() {

    private lateinit var insertSample: InsertSample

    @MockK
    private lateinit var repository: SampleRepository

    @Before
    fun before() {
        insertSample = InsertSample(repository)
    }

    @Test
    fun `test01 test insert, success`() {
        coEvery { repository.insert(VALUE) } returns Result.Success(Sample(1L, VALUE))

        runBlocking { insertSample.run(InsertSample.Param(VALUE)) }

        verify(exactly = 1) { repository.insert(VALUE) }
    }

    @Test
    fun `test02 test insert, error`() {
        coEvery { repository.insert(VALUE) } returns Result.Error(Exception())

        runBlocking { insertSample.run(InsertSample.Param(VALUE)) }

        verify(exactly = 1) { repository.insert(VALUE) }
    }

    companion object {
        private const val VALUE = "sample"
    }
}