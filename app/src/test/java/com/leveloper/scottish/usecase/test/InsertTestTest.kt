package com.leveloper.scottish.usecase.test

import com.leveloper.library.utils.Result
import com.leveloper.scottish.UnitTest
import com.leveloper.scottish.domain.usecase.test.InsertTest
import com.leveloper.scottish.repository.TestRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class InsertTestTest : UnitTest() {

    private lateinit var insertTest: InsertTest

    @MockK
    private lateinit var repository: TestRepository

    @Before
    fun before() {
        insertTest = InsertTest(repository)
    }

    @Test
    fun `test01 test insert, success`() {
        coEvery { repository.insert(VALUE) } returns Result.Success(1L)

        runBlocking { insertTest.run(InsertTest.Param(VALUE)) }

        verify(exactly = 1) { repository.insert(VALUE) }
    }

    @Test
    fun `test02 test insert, error`() {
        coEvery { repository.insert(VALUE) } returns Result.Error(Exception())

        runBlocking { insertTest.run(InsertTest.Param(VALUE)) }

        verify(exactly = 1) { repository.insert(VALUE) }
    }

    companion object {
        private const val VALUE = "sample"
    }
}