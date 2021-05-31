package com.leveloper.scottish.data.model.dto

import com.leveloper.scottish.domain.model.ChatRoom

data class ChatRoomDto(
    val name: String
) {
    companion object {
        fun map(source: Map<String, Any>): ChatRoomDto {
            return ChatRoomDto(
                name = source["name"].toString()
            )
        }
    }
}

fun ChatRoomDto.map(id: String): ChatRoom {
    return ChatRoom(
        id = id,
        name = this.name
    )
}