package com.example.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.chatbot.chat.MessageModel

class MessageAdapter(val List:ArrayList<MessageModel>):
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    class MessageViewHolder(view: View):ViewHolder(view){
            val msgText=view.findViewById<TextView>(R.id.show_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        var view:View?=null
        var from=LayoutInflater.from(parent.context)
        if(viewType==0){
            view=from.inflate(R.layout.chatright,parent,false)
        }
        else
        {
            view=from.inflate(R.layout.chatleft,parent,false)
        }
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.msgText.text=List[position].message
    }

    override fun getItemViewType(position: Int): Int {
        val message=List[position]
        if(message.isUser)return 0
        else return 1
    }
}