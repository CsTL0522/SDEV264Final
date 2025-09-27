package com.example.mteinstallbuddy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface InstallSheetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sheet: InstallSheet)

    @Query("SELECT * FROM install_sheets ORDER BY timestamp DESC")
    fun getAll(): Flow<List<InstallSheet>>

    @Query("SELECT DISTINCT make FROM install_sheets ORDER BY make ASC")
    fun getUniqueMakes(): Flow<List<String>>

    @Query("SELECT DISTINCT model FROM install_sheets ORDER BY model ASC")
    fun getUniqueModels(): Flow<List<String>>

    @Query("SELECT DISTINCT type FROM install_sheets ORDER BY type ASC")
    fun getUniqueTypes(): Flow<List<String>>
}