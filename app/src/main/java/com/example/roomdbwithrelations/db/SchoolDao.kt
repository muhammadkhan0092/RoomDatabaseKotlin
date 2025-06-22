package com.example.roomdbwithrelations.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseFullData
import com.example.roomdbwithrelations.data.StudentCourseCross
import com.example.roomdbwithrelations.data.Students
import kotlinx.coroutines.flow.Flow

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: List<Course>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: List<Students>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossRef(crossRef: List<StudentCourseCross>)

    @Insert
    suspend fun insertChapters(chapters: List<Chapters>)

    @Transaction
    @Query("SELECT * FROM Course")
     fun getAllCourses() : Flow<List<CourseFullData>>
}