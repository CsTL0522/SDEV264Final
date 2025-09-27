package com.example.mteinstallbuddy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InstallSheet::class], version = 1)
abstract class InstallDatabase : RoomDatabase() {
    abstract fun installSheetDao(): InstallSheetDao

    companion object {
        @Volatile private var INSTANCE: InstallDatabase? = null

        fun getDatabase(context: Context): InstallDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    InstallDatabase::class.java,
                    "install_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}