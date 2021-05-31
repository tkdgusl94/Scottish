package com.leveloper.scottish.data.repository.source.impl

import com.leveloper.scottish.data.db.dao.SampleDao
import com.leveloper.scottish.data.repository.source.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val sampleDao: SampleDao
) : LocalDataSource {

}