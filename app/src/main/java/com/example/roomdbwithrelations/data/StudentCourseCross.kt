package com.example.roomdbwithrelations.data

import androidx.room.Entity


@Entity(primaryKeys = ["studentId","courseId"])
data class StudentCourseCross(
    val studentId : Int,
    val courseId : Int
)
