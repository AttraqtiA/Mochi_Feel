package com.example.mochi_feel.ui.screen.journalingEntry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mochi_feel.data.AuthRepositoryImpl
import com.example.mochi_feel.model.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NewEntryViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {
    fun addEntries(
        title: String,
        content: String,
        date: Date,
        tagsList: MutableList<Tag>
    ) {
        viewModelScope.launch {
//            repository.addEntries(title, content, date, tagsList)
            repository.addEntries(title, content, date, null)
        }
    }

    fun addTag(
        name:String
    ) {
        viewModelScope.launch {
            repository.addTag(name)
        }
    }
}