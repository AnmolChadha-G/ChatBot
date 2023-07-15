package com.example.chatbot

import com.example.chatbot.Response.chatModel
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL="https://api.openai.com/v1/"
const val API_KEY="***********************************"
interface chatInterface {
    @POST("completions")
    suspend fun getChat(
        @Header("Content-Type")contentType:String,
        @Header("Authorization") authorization:String,
        @Body requestBody: RequestBody
    ):chatModel
}
object apiUtilites{
    val chatinstance:chatInterface
    init{
        val retrofit:Retrofit=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        chatinstance=retrofit.create(chatInterface::class.java)
    }
}