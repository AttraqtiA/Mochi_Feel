package com.example.mochi_feel.viewmodel.Journaling_Entry

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
import javax.inject.Inject

@HiltViewModel
class EntryListViewModel @Inject constructor(
    private val repository: AuthRepositoryImpl
) : ViewModel() {
    private val _userData = MutableStateFlow<User?>(null)
    private val _entriesData = MutableStateFlow<MutableList<EntryBox>?>(null)

    val userData: StateFlow<User?> = _userData
    val entriesData : StateFlow<MutableList<EntryBox>?> = _entriesData

    private val _selectedTags : MutableList<Tag> = mutableListOf()
    val selectedTags = _selectedTags

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

    fun sortDateAscending() {
        val uid = userManager.getUserUid()
        viewModelScope.launch {
            val result = uid?.let { repository.fetchUserData(it) }
            val sortedEntries =
                result?.entries?.toMutableList()?.sortedBy { it.current_date }

            _entriesData.value = sortedEntries as MutableList<EntryBox>?
        }
    }
}