package com.example.hardwareapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hardware_table")
data class HardwareEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,
    val specs: String,
    val description: String,
    val performanceScore: Float,
    val imageResId: Int
)