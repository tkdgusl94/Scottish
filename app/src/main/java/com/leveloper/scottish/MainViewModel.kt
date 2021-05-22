package com.leveloper.scottish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leveloper.library.utils.onError
import com.leveloper.library.utils.onSuccess
import com.leveloper.scottish.usecase.test.InsertTest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val insertTest: InsertTest
) : ViewModel() {

    init {
        insertTest(System.currentTimeMillis().toString())
    }

    private fun insertTest(value: String) {
        insertTest(InsertTest.Param(value), viewModelScope) {
            it.onSuccess(::handleSuccess).onError(::handleError)
        }
    }

    private fun handleSuccess(value: Long) {
        println("success: $value")
    }

    private fun handleError(e: Exception) {
        println("error: $e")
    }
}