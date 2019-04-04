package com.example.materialdesign.fragments


import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.materialdesign.R
import com.example.materialdesign.model.Card

class FragmentDetails() : Fragment() {
    lateinit var card: Card
    lateinit var title: TextView
    lateinit var description: TextView
    lateinit var image: ImageView
    lateinit var icon_type: ImageView
    lateinit var icon_number: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        initUI(view)
        updateUI()
//        useSpannebleString()

        return view
    }

    private fun useSpannebleString() {
        val spannableString = SpannableString(title.text)
        val backgroundColorSpan = BackgroundColorSpan(Color.parseColor("#71FFFF9A"))
        spannableString.setSpan(backgroundColorSpan, 0, title.text.length, Spanned.SPAN_COMPOSING)
        title.text = spannableString
    }

    private fun updateUI() {
        title.text = card.title
        description.text = card.description
        image.setImageResource(card.image)
        icon_type.setImageResource(card.iconType)
        icon_number.text = "1"
    }

    private fun initUI(view: View) {
        title = view.findViewById(R.id.card_title)
        description = view.findViewById(R.id.card_description)
        image = view.findViewById(R.id.card_image)
        icon_type = view.findViewById(R.id.icon_type)
        icon_number = view.findViewById(R.id.icon_number)
    }
}
