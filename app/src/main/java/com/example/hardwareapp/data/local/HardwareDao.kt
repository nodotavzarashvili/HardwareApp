package com.example.hardwareapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HardwareDao {
    @Query("SELECT * FROM hardware_table")
    fun getAllHardware(): Flow<List<HardwareEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHardware(hardware: HardwareEntity)

    @Query("DELETE FROM hardware_table")
    suspend fun deleteAll()
}
