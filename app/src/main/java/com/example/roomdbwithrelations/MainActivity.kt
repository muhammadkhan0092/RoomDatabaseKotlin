package com.example.roomdbwithrelations

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.roomdbwithrelations.data.Chapters
import com.example.roomdbwithrelations.data.Course
import com.example.roomdbwithrelations.data.CourseWithChapters
import com.example.roomdbwithrelations.databinding.ActivityMainBinding
import com.example.roomdbwithrelations.di.SchoolApp
import com.example.roomdbwithrelations.utils.Resource
import com.example.roomdbwithrelations.vm.MainVm
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
     lateinit var vmf : MainVmf
    private lateinit var vm : MainVm
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inject()
    }

    private fun inject() {
        val component = (application as SchoolApp).appComponent
        component.inject(this)
        vm = ViewModelProvider(this,vmf)[MainVm::class.java]
        onSetListener()
        onGetListener()
        observeOnGet()
        observeChaptersInset()
        observeCoursesInsert()
    }

    private fun observeOnGet() {
        lifecycleScope.launch {
            vm.getAllCourses.collectLatest {
                when(it){
                    is Resource.Error<*> -> {
                        Log.d("KHAN","ERROR GETTING ${it.message}")
                        binding.textView.text = ""
                    }
                    is Resource.Loading<*> ->{
                       binding.textView.text = "Loading ..."
                    }
                    is Resource.Success<*> -> {
                        setData(it.data!!)
                    }
                    is Resource.Unspecified<*> -> {

                    }
                }
            }
        }
    }

    private fun setData(data: List<CourseWithChapters>) {
        var text = "COURSE \t CHAPTERS\n"
        data.forEach {
            text+="${it.course.title} \t \t"
            it.chapters.forEach {chapters->
                text+="${chapters.name}   "
            }
            text+="\n"
        }
        binding.textView.text = text
    }

    private fun observeChaptersInset() {
        lifecycleScope.launch {
            vm.insertChapters.collectLatest {
                when(it){
                    is Resource.Error<*> -> {
                        Log.d("KHAN","ERROR INSERTING CHAPTERS ${it.message}")
                        binding.textView.text = ""
                    }
                    is Resource.Loading<*> ->{
                        binding.textView.text = "Loading ..."
                    }
                    is Resource.Success<*> -> {
                        binding.textView.text = ""
                        Log.d("KHAN","DATA CHAPTERS SET SUCCESSFULL")
                    }
                    is Resource.Unspecified<*> -> {

                    }
                }
            }
        }
    }

    private fun observeCoursesInsert() {
        lifecycleScope.launch {
            vm.insertCourse.collectLatest {
                when(it){
                    is Resource.Error<*> -> {
                        Log.d("KHAN","ERROR INSERTING COURSE ${it.message}")
                        binding.textView.text = ""
                    }
                    is Resource.Loading<*> ->{
                        binding.textView.text = "Loading ..."
                    }
                    is Resource.Success<*> -> {
                        binding.textView.text = ""
                        Log.d("KHAN","DATA COURSE SET SUCCESSFULL")
                    }
                    is Resource.Unspecified<*> -> {

                    }
                }
            }
        }
    }

    private fun onGetListener() {
        binding.btnGet.setOnClickListener {
            vm.getAllCourses()
        }
    }

    private fun onSetListener() {
        binding.btnSet.setOnClickListener {
            val courses = listOf(
                Course(courseId = 1, title = "Math"),
                Course(courseId = 2, title = "Physics"),
                Course(courseId = 3, title = "Computer Science")
            )

            val chapters = listOf(
                Chapters( 0, courseOwnerId = 1, name = "Algebra"),
                Chapters(0, courseOwnerId = 1, name = "Geometry"),

                Chapters(0, courseOwnerId = 2, name = "Mechanics"),
                Chapters(0, courseOwnerId = 2, name = "Optics"),

                Chapters(0, courseOwnerId = 3, name = "Data Structures"),
                Chapters(0, courseOwnerId = 3, name = "Operating Systems")
            )
            vm.insertCourses(courses)
            vm.insertChapters(chapters)
        }
    }


}