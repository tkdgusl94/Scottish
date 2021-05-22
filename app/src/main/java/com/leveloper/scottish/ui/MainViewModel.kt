package com.leveloper.scottish.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leveloper.library.utils.onError
import com.leveloper.library.utils.onSuccess
import com.leveloper.scottish.domain.model.Sample
import com.leveloper.scottish.domain.usecase.test.InsertSample
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val insertSample: InsertSample
) : ViewModel() {

    init {
        insertTest(System.currentTimeMillis().toString())
    }

    private fun insertTest(value: String) {
        insertSample(InsertSample.Param(value), viewModelScope) {
            it.onSuccess(::handleSuccess).onError(::handleError)
        }
    }

    private fun handleSuccess(value: Sample) {
        println("success: $value")
    }

    private fun handleError(e: Exception) {
        println("error: $e")
    }
}