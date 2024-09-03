package com.example.aichatbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.aichatbox.Components.chatFooter
import com.example.aichatbox.Components.chatHeader
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aichatbox.Components.chatList

@Composable
fun chatBot(
    viewModel: chatBotviewModel=viewModel()
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        chatHeader()
        Box(
            //contentAlignment = Alignment.Center,
            modifier = Modifier.weight(1f),

        ){
            if(viewModel.list.isEmpty()){
                Text(text = "Hello how can I help you!")
            }else {
                chatList(list = viewModel.list)
            }
        }

        chatFooter {
            if(it.isNotEmpty()){
                viewModel.sendmessage(it)
            }
        }
    }
}