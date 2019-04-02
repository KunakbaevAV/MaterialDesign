package com.example.materialdesign.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.example.materialdesign.MESSAGE_COUNT
import com.example.materialdesign.MY_PREFERENCES
import com.example.materialdesign.R
import com.google.android.material.button.MaterialButton

class FragmentNotifications : Fragment() {
    lateinit var messageCount: SharedPreferences
    lateinit var message: TextView
    lateinit var buttonReg: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        initBellUI(view)
        initButtonReg(view)
        return view
    }

    private fun initButtonReg(view: View) {
        buttonReg = view.findViewById(R.id.button_reg)
        buttonReg.setOnClickListener {
            Toast.makeText(context, "Пока не реализовано", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initBellUI(view: View) {
        val bell = view.findViewById<ImageView>(R.id.bell)
        bell.setOnClickListener { showDialogBell() }
        message = view.findViewById(R.id.message)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateMessageBadge()
    }

    private fun showDialogBell() {
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
