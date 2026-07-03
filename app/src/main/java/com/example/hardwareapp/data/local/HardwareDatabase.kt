package com.example.hardwareapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HardwareEntity::class], version = 3, exportSchema = false)
abstract class HardwareDatabase : RoomDatabase() {
    abstract fun hardwareDao(): HardwareDao

    companion object {
        @Volatile
        private var INSTANCE: HardwareDatabase? = null

        fun getDatabase(context: Context): HardwareDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HardwareDatabase::class.java,
                    "hardware_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}