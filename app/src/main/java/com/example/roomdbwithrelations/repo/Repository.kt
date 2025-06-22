package com.example.roomdbwithrelations.repo

import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseFullData
import com.example.roomdbwithrelations.data.CourseWithChapters
import com.example.roomdbwithrelations.data.StudentCourseCross
import com.example.roomdbwithrelations.data.Students
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

    suspend fun insertStudents(
        students:  List<Students>,
    ){
        db.getSchoolDao().insertStudent(students)
    }

    suspend fun insertCross(
        cross: List<StudentCourseCross>,
    ){
        db.getSchoolDao().insertCrossRef(cross)
    }

    suspend fun getCourses(): Flow<List<CourseFullData>> {
          return db.getSchoolDao().getAllCourses()
    }
}