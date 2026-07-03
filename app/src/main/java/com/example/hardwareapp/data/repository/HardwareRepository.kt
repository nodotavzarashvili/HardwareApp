package com.example.hardwareapp.data.repository

import com.example.hardwareapp.data.local.HardwareDao
import com.example.hardwareapp.data.local.HardwareEntity
import kotlinx.coroutines.flow.Flow

class HardwareRepository(private val hardwareDao: HardwareDao) {
    val allHardware: Flow<List<HardwareEntity>> = hardwareDao.getAllHardware()

    suspend fun insert(hardware: HardwareEntity) {
        hardwareDao.insertHardware(hardware)
    }

    suspend fun clearAll() {
        hardwareDao.deleteAll()
    }
}
