package com.example.roomdbwithrelations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbwithrelations.repo.Repository
import com.example.roomdbwithrelations.vm.MainVm
import javax.inject.Inject

class MainVmf @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainVm(repository) as T
    }
}