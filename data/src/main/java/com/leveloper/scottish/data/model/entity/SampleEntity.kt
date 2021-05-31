package com.leveloper.scottish.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leveloper.scottish.domain.model.Sample

@Entity(tableName = "sample")
data class SampleEntity(

    @field:PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id")
    var id: Long = 0,

    @field:ColumnInfo(name = "name")
    var name: String = ""
)

fun SampleEntity.map(): Sample {
    return Sample(id, name)
}

fun Sample.map(): SampleEntity {
    return SampleEntity(id, value)
}