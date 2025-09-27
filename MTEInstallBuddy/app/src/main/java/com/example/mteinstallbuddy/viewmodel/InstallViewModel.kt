package com.example.mteinstallbuddy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mteinstallbuddy.data.AppDatabase
import com.example.mteinstallbuddy.data.InstallSheet
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class InstallViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).installSheetDao()

    val installs = dao.getAll().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val uniqueMakes = dao.getUniqueMakes().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val uniqueModels = dao.getUniqueModels().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val uniqueTypes = dao.getUniqueTypes().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun saveInstall(sheet: InstallSheet) {
        viewModelScope.launch {
            dao.insert(sheet)
        }
    }
}

class InstallViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InstallViewModel(application) as T
    }
}