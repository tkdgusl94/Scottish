package com.leveloper.scottish.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.leveloper.library.utils.onSuccess
import com.leveloper.scottish.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val current = System.currentTimeMillis()

        vm.abc.observe(this) {
            println("result: $it")
            println("time: ${System.currentTimeMillis() - current}")
        }
    }
}