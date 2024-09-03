package com.example.aichatbox

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class chatBotviewModel:ViewModel() {
    val list by lazy {
        mutableStateListOf<chatData>()
    }

    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = APIKey
        )
    }
    fun sendmessage(message: String) = viewModelScope.launch {
        val chat=genAI.startChat();
        list.add(chatData(message,chatRoleEnum.USER.role))

        chat.sendMessage(
            content (chatRoleEnum.USER.role){text(message)  }
        ).text?.let {
            list.add(chatData(it,chatRoleEnum.MODEL.role))
        }
//        var response=genAI.startChat().sendMessage(prompt = message).text
//        Log.d("AI_ANS",response.toString())
    }
}