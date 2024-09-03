package com.example.aichatbox

sealed interface chatBotState {
    data object Ideal:chatBotState
    data object  Loading:chatBotState
    data class  Error(val chatError:String):chatBotState
    data class  success(val chatData:String):chatBotState
}