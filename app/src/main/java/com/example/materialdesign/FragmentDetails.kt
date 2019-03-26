package com.example.materialdesign


import android.os.Bundle
import android.transition.ChangeBounds
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.transition.ArcMotion
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        title = view.findViewById(R.id.card_title)
        description = view.findViewById(R.id.card_description)
        image = view.findViewById(R.id.card_image)
        icon_type = view.findViewById(R.id.icon_type)
        icon_number = view.findViewById(R.id.icon_number)

        title.text = card.title
        description.text = card.description
        image.setImageResource(card.image)
        icon_type.setImageResource(card.iconType)
        icon_number.text = "1"

        return view
    }
}
