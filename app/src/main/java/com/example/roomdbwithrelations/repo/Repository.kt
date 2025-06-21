package com.example.roomdbwithrelations.repo

import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseWithChapters
import com.example.roomdbwithrelations.db.SchoolDb
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val db: SchoolDb) {

    suspend fun insertCourse(
        course: List<Course>,
    ){
        db.getSchoolDao().insertCourse(course)
    }

    suspend fun insertChapters(
        chapters: List<Chapters>,
    ){
        db.getSchoolDao().insertChapters(chapters)
    }

    suspend fun getCourses(): Flow<List<CourseWithChapters>> {
          return db.getSchoolDao().getAllCourses()
    }
}