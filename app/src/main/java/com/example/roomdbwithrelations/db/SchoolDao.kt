package com.example.roomdbwithrelations.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseWithChapters
import kotlinx.coroutines.flow.Flow

@Dao
interface SchoolDao {

    @Insert
    suspend fun insertCourse(course: List<Course>)

    @Insert
    suspend fun insertChapters(chapters: List<Chapters>)

    @Transaction
    @Query("SELECT * FROM Course")
     fun getAllCourses() : Flow<List<CourseWithChapters>>
}