package com.example.materialdesign.utils.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.interfaces.DraggableViewHolder
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.item_card.view.*

internal class CardViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView), DraggableViewHolder {

    var textTitle: TextView
    var textDescription: TextView
    var imageView: ImageView
    var chip: Chip

    init {
        textTitle = itemView.findViewById(R.id.card_title)
        textDescription = itemView.findViewById(R.id.card_description)
        imageView = itemView.findViewById(R.id.card_image)
        chip = itemView.card_chip
    }

    override fun onSelected() {
        itemView.animate().scaleX(0.8f).scaleY(0.8f).duration = 400
    }

    override fun onClear() {
        itemView.animate().scaleX(1f).scaleY(1f).duration = 400
    }
}