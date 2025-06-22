package com.example.roomdbwithrelations.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Students")
data class Students(
    @PrimaryKey(autoGenerate = true)
    val studentId : Int,
    val studentName : String
)
