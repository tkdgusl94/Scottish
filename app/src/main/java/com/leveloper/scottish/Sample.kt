package com.leveloper.scottish

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class Sample
@Inject constructor(
    @ApplicationContext val context: Context
) {
    val abc = 0
}