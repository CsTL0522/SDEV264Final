package com.example.mteinstallbuddy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "install_sheets")
data class InstallSheet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val make: String,
    val model: String,
    val type: String,
    val technician: String,
    val notes: String,
    val photoUri: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)