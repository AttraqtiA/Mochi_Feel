package com.example.mochi_feel.viewmodel.Journaling_Entry

import android.icu.util.Calendar
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.mochi_feel.data.AuthRepositoryImpl
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NewEntryViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {

    private val _entriesData = MutableStateFlow<MutableList<EntryBox>?>(null)
    private val _tagSelected = MutableStateFlow<MutableList<Tag>>(mutableListOf())

    val entriesData : StateFlow<MutableList<EntryBox>?> = _entriesData
    val tagSelected : StateFlow<MutableList<Tag>> = _tagSelected.asStateFlow()

    fun addNewEntry(title: String, content:String, tags: MutableList<Tag>){
//    add and push it into the database here i guess
    }

    fun addNewTag(name: String){
//    make new tag with this name
    }

    fun selectTag(tag: Tag){

    }

    fun unselectTag(tag: Tag){

    }
}

fun Date?.isSameDayAs(other: Date?): Boolean {
    if (this == null || other == null) return false

    val cal1 = Calendar.getInstance().apply { time = this@isSameDayAs }
    val cal2 = Calendar.getInstance().apply { time = other }

    return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
            cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
}