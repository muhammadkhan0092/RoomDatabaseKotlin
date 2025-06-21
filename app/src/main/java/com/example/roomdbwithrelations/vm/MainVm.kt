package com.example.roomdbwithrelations.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseWithChapters
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

    private val _getAllCourses = MutableStateFlow<Resource<List<CourseWithChapters>>>(Resource.Unspecified())
    val getAllCourses: StateFlow<Resource<List<CourseWithChapters>>> = _getAllCourses.asStateFlow()

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
