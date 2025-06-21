package com.example.roomdbwithrelations.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Chapters")
data class Chapters(
    @PrimaryKey(autoGenerate = true)
    val chaptersId : Int,
    val courseOwnerId : Int,
    val name : String
)
