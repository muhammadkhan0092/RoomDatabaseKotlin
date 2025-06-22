package com.example.roomdbwithrelations.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CourseFullData(
    @Embedded
    val course: Course,


    @Relation(
        parentColumn = "courseId",
        entityColumn = "courseOwnerId"
    )
    val chapters: List<Chapters>,


    @Relation(
        parentColumn = "courseId",
        entityColumn = "studentId",
        associateBy = Junction(StudentCourseCross::class)
    )
    val student : List<Students>
)
