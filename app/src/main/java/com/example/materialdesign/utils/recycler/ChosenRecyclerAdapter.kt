package com.example.materialdesign.utils.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.model.Card
import java.util.*

internal class ChosenRecyclerAdapter(private val parent: Fragment)
    : RecyclerView.Adapter<CardViewHolder>() {

    private val chosenCards = ArrayList<Card>()

    init {
        chosenCards.add(Card("Разведчик", "Исследует космос", R.drawable.ship01, R.drawable.icon_coin))
        chosenCards.add(Card("Торговец", "Добывает деньги", R.drawable.ship02, R.drawable.icon_coin))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chosenCards.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = chosenCards[position]
        holder.textTitle.text = card.title
        holder.textDescription.text = card.description
        holder.imageView.setImageResource(card.image)
        holder.chip.setOnClickListener { myToast(holder) }
    }

    private fun myToast(holder: CardViewHolder) {
        Toast.makeText(parent.context, "hi " + holder.textTitle.text, Toast.LENGTH_SHORT).show()
    }

    fun delete(pozition: Int) {
        chosenCards.removeAt(pozition)
        notifyItemRemoved(pozition)
    }

    fun move(fromPoz: Int, toPoz: Int) {
        Collections.swap(chosenCards, fromPoz, toPoz)
        notifyItemMoved(fromPoz, toPoz)
    }
}