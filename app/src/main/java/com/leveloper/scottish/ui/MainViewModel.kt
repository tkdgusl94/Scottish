package com.leveloper.scottish.ui

import androidx.lifecycle.*
import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.model.ChatRoom
import com.leveloper.scottish.domain.repository.ChatRepository
import com.leveloper.scottish.domain.usecase.test.CreateChatRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ChatRepository,
    private val createChatRoom: CreateChatRoom
) : ViewModel() {

    val abc: LiveData<List<ChatRoom>> = liveData {
        emitSource(
            repository.getAllChatRoom().asLiveData().map { result ->
                val data = if (result is Result.Success) result.data else emptyList()
                data
            }
        )
    }

    init {
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
        createChatRoom(CreateChatRoom.Param(System.currentTimeMillis().toString()), viewModelScope)
    }
}