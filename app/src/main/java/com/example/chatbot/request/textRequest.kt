package com.example.chatbot.request

data class textRequest(
    val max_tokens: Int,
    val model: String,
    val prompt: String,
    val temperature: Double
)