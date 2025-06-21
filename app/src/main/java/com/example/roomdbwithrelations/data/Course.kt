package com.example.roomdbwithrelations.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Course")
data class Course(
    @PrimaryKey(autoGenerate = true)
    val courseId : Int,
    val title : String
)