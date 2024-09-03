package com.example.aichatbox

data class chatData(
    val message  :String,
    val role : String //kon kisko bhej raha h
)
enum class chatRoleEnum(val role:String){
    USER("user"),
    MODEL("model") //gemini
}
