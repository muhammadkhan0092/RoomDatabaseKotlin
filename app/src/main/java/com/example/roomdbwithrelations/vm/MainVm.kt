package com.example.roomdbwithrelations.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseFullData
import com.example.roomdbwithrelations.data.CourseWithChapters
import com.example.roomdbwithrelations.data.StudentCourseCross
import com.example.roomdbwithrelations.data.Students
import com.example.roomdbwithrelations.repo.Repository
import com.example.roomdbwithrelations.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class MainVm(private val repository: Repository) : ViewModel() {

    private val _insertCourse = MutableStateFlow<Resource<String>>(Resource.Unspecified())
    val insertCourse: StateFlow<Resource<String>> = _insertCourse.asStateFlow()

    private val _insertChapters = MutableStateFlow<Resource<String>>(Resource.Unspecified())
    val insertChapters: StateFlow<Resource<String>> = _insertChapters.asStateFlow()


    private val _insertStudents = MutableStateFlow<Resource<String>>(Resource.Unspecified())
    val insertStudents: StateFlow<Resource<String>> = _insertStudents.asStateFlow()

    private val _insertCross = MutableStateFlow<Resource<String>>(Resource.Unspecified())
    val insertCross: StateFlow<Resource<String>> = _insertCross.asStateFlow()

    private val _getAllCourses = MutableStateFlow<Resource<List<CourseFullData>>>(Resource.Unspecified())
    val getAllCourses: StateFlow<Resource<List<CourseFullData>>> = _getAllCourses.asStateFlow()

    fun insertCourses(course: List<Course>) {
        viewModelScope.launch {
            try {
                repository.insertCourse(course)
                _insertCourse.emit(Resource.Success("Course inserted successfully"))
            } catch (e: Exception) {
                _insertCourse.emit(Resource.Error("Failed to insert course: ${e.message}"))
            }
        }
    }

    fun insertChapters(chapters: List<Chapters>) {
        viewModelScope.launch {
            try {
                repository.insertChapters(chapters)
                _insertChapters.emit(Resource.Success("Chapters inserted successfully"))
            } catch (e: Exception) {
                _insertChapters.emit(Resource.Error("Failed to insert chapters: ${e.message}"))
            }
        }
    }

    fun insertStudents(students: List<Students>) {
        viewModelScope.launch {
            try {
                repository.insertStudents(students)
                _insertStudents.emit(Resource.Success("Student inserted successfully"))
            } catch (e: Exception) {
                _insertStudents.emit(Resource.Error("Failed to insert students: ${e.message}"))
            }
        }
    }

    fun insertCross(cross: List<StudentCourseCross>) {
        viewModelScope.launch {
            try {
                repository.insertCross(cross)
                _insertCross.emit(Resource.Success("Cross inserted successfully"))
            } catch (e: Exception) {
                _insertCross.emit(Resource.Error("Failed to insert cross: ${e.message}"))
            }
        }
    }

    fun getAllCourses() {
        viewModelScope.launch {
            try {
                repository.getCourses().collect { list ->
                    _getAllCourses.emit(Resource.Success(list))
                }
            } catch (e: Exception) {
                _getAllCourses.emit(Resource.Error("Failed to fetch courses: ${e.message}"))
            }
        }
    }
}
