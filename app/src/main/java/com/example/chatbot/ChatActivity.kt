package com.example.chatbot

import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatbot.chat.MessageModel
import com.example.chatbot.databinding.ActivityChatBinding
import com.example.chatbot.request.textRequest
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.RequestBody
import com.example.chatbot.Response.chatModel
import com.google.gson.GsonBuilder
import retrofit2.Response
import kotlinx.coroutines.withContext as withContext

class ChatActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChatBinding
    var List=ArrayList<MessageModel>()
    private lateinit var adapter:MessageAdapter
    private lateinit var mlayoutManager:LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mlayoutManager= LinearLayoutManager(this)
        mlayoutManager.stackFromEnd=true
        adapter= MessageAdapter(List)
        binding.rcv.layoutManager=mlayoutManager
        binding.rcv.adapter=adapter
        binding.ask.setOnClickListener(){
            if(binding.query.text!!.isEmpty()){
                Toast.makeText(this,"please write something",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val inputMethodManager =
                    getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

                // Hide the soft keyboard
                inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
                List.add(MessageModel(true, binding.query.text.toString()))
                adapter.notifyItemInserted(List.size - 1)
                binding.rcv.recycledViewPool.clear()
                binding.rcv.smoothScrollToPosition(List.size - 1)
                // Delay the API call and response processing
                lifecycleScope.launch {
                    // Add a delay before making the API call
                    kotlinx.coroutines.delay(200)
                    callApi()
                }
            }
        }
    }

    private fun callApi() {
        val gson = GsonBuilder().create()
        val requestBody=RequestBody.create(MediaType.parse("application/json"), gson.toJson(textRequest(
            250,"text-davinci-003",binding.query.text.toString(),0.7
        )))
        lifecycleScope.launch(Dispatchers.IO) {
           try {

               val response =
                   apiUtilites.chatinstance.getChat(
                       "application/json",
                       "Bearer $API_KEY",
                       requestBody
                   )
               val textResponse =response.choices.first().text
               withContext(Dispatchers.Main) {
                   List.add(MessageModel(false, textResponse.toString()))
                   adapter.notifyItemInserted(List.size - 1)
                   binding.rcv.recycledViewPool.clear()
                   binding.rcv.smoothScrollToPosition(List.size - 1)
               }
           }
           catch (e:Exception){
               withContext(Dispatchers.Main){
                   Toast.makeText(this@ChatActivity,e.message,Toast.LENGTH_SHORT).show()
               }
           }
        }
        binding.query.text.clear()

    }
}