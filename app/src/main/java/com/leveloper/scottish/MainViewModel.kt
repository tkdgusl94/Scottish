package com.leveloper.scottish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leveloper.scottish.data.LvError
import com.leveloper.scottish.data.LvLoading
import com.leveloper.scottish.data.LvSuccess
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
        val param = InsertTest.Param(value)
        insertTest(param, viewModelScope) {
            when (it) {
                is LvSuccess -> {
                    println("success: ${it.data}")
                }
                is LvError -> {
                    println("error")
                }
                is LvLoading -> Unit
            }
        }
    }
}