package com.example.roomdbwithrelations.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course


@Database(entities = [Course::class, Chapters::class], version = 1)
abstract class SchoolDb : RoomDatabase() {
    abstract fun getSchoolDao() : SchoolDao
}