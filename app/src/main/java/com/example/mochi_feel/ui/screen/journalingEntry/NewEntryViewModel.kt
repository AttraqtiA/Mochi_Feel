package com.example.mochi_feel.ui.screen.journalingEntry

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mochi_feel.data.AuthRepositoryImpl
import com.example.mochi_feel.model.EntryBox
import com.example.mochi_feel.model.Tag
import com.example.mochi_feel.model.User
import com.example.mochi_feel.model.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NewEntryViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {

    private val _selectedTags : MutableList<Tag> = mutableListOf()
    val selectedTags = _selectedTags

    private val _userData = MutableStateFlow<User?>(null)
    private val _entriesData = MutableStateFlow<MutableList<EntryBox>?>(null)

    val userData: StateFlow<User?> = _userData
    val entriesData : StateFlow<MutableList<EntryBox>?> = _entriesData

    @Inject
    lateinit var userManager: UserManager

    fun initiate() {
        val uidrepo = repository.getUserUID()
        if (uidrepo != null) {
            userManager.setUserUid(uidrepo)
        }
        val uid = userManager.getUserUid()

        if (uid != null) {
            fetchUserData(uid)
        }
    }

    fun fetchUserData(uid: String) {
        viewModelScope.launch {
            val result = repository.fetchUserData(uid)
            _userData.value = result

            val sortedEntries = result?.entries?.toMutableList()?.sortedByDescending { it.current_date }

            _entriesData.value = sortedEntries as MutableList<EntryBox>?
        }
    }
    fun addEntries(
        title: String,
        content: String,
        date: Date,
        tagsList: MutableList<Tag>
    ) {
        viewModelScope.launch {
//            repository.addEntries(title, content, date, tagsList)
            repository.addEntries(title, content, date, tagsList)
        }
    }

    fun addTag(
        name:String
    ) {
        viewModelScope.launch {
            repository.addTag(name)
        }
    }

    fun selectTag(tag: Tag){
        _selectedTags.add(tag)
    }

    fun unselectTag(tag: Tag){
        _selectedTags.remove(tag)
    }
}
