package com.example.hardwareapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hardwareapp.R
import com.example.hardwareapp.data.local.HardwareEntity
import com.example.hardwareapp.data.repository.HardwareRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HardwareViewModel(private val repository: HardwareRepository) : ViewModel() {

    val hardwareList: StateFlow<List<HardwareEntity>> = repository.allHardware.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addSampleData() {
        viewModelScope.launch {

            repository.clearAll()
            
            repository.insert(HardwareEntity(
                name = "Intel Core Ultra 9 185H",
                type = "CPU",
                specs = "16 Cores, 22 Threads, 5.1 GHz",
                description = "AI-powered mobile processor for maximum efficiency.",
                performanceScore = 85f,
                imageResId = R.drawable.intel_i9
            ))

            repository.insert(HardwareEntity(
                name = "NVIDIA GeForce RTX 4090",
                type = "GPU",
                specs = "24GB GDDR6X",
                description = "Flagship GPU for extreme 4K gaming and flawless ShadowPlay clipping.",
                performanceScore = 98f,
                imageResId = R.drawable.rtx_4090
            ))

            repository.insert(HardwareEntity(
                name = "Intel Core i9-14900K",
                type = "CPU",
                specs = "24 Cores, 32 Threads, 6.0 GHz",
                description = "High-end desktop processor for intense multitasking.",
                performanceScore = 92f,
                imageResId = R.drawable.intel_i9
            ))
        }
    }
}
