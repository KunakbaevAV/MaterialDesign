package com.example.materialdesign


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog

class FragmentNotifications : Fragment() {
    lateinit var messageCount: SharedPreferences
    lateinit var message: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        val bell = view.findViewById<ImageView>(R.id.bell)
        message = view.findViewById(R.id.message)
        bell.setOnClickListener { showDialog() }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateMessageBadge()
    }

    private fun showDialog() {
        val materialDialog = context?.let { MaterialDialog(it) }
        materialDialog?.show() {
            icon(R.drawable.ic_android_green_600_36dp)
            title(text = "Оповещения")
            message(text = "Что сделать?")
            positiveButton(text = "Добавить оповещение") { addMessage() }
            negativeButton(text = "Сбросить оповещение") { deleteMessages() }
        }
    }

    fun addMessage() {
        messageCount = view!!.context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE)
        var number = messageCount.getInt(MESSAGE_COUNT, 0)
        val editor = messageCount.edit()
        editor.putInt(MESSAGE_COUNT, ++number)
        editor.apply()
        updateMessageBadge()
    }

    fun deleteMessages() {
        messageCount = view!!.context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE)
        val editor = messageCount.edit()
        editor.putInt(MESSAGE_COUNT, 0)
        editor.apply()
        updateMessageBadge()
    }

    fun updateMessageBadge() {
        messageCount = view!!.context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE)
        val number = messageCount.getInt(MESSAGE_COUNT, 0)

        message.text = number.toString()
        if (number == 0) message.alpha = 0f
        else message.alpha = 1f
    }
}
