package com.example.hardwareapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hardwareapp.data.repository.HardwareRepository

class HardwareViewModelFactory(private val repository: HardwareRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HardwareViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HardwareViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}