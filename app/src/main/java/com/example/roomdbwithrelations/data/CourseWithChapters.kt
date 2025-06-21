package com.example.roomdbwithrelations.data

import androidx.room.Embedded
import androidx.room.Relation

data class CourseWithChapters(
    @Embedded
    val course: Course,

    @Relation(
        parentColumn = "courseId",
        entityColumn = "courseOwnerId"
    )
    val chapters : List<Chapters>
)
