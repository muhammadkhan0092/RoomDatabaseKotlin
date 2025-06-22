package com.example.roomdbwithrelations.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.StudentCourseCross
import com.example.roomdbwithrelations.data.Students


@Database(entities = [Course::class, Chapters::class, Students::class, StudentCourseCross::class], version = 1)
abstract class SchoolDb : RoomDatabase() {
    abstract fun getSchoolDao() : SchoolDao
}