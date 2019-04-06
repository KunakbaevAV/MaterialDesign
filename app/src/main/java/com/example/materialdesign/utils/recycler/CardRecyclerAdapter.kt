package com.example.materialdesign.utils.recycler

import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import java.util.Collections
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.fragments.FragmentDetails
import com.example.materialdesign.fragments.FragmentRecycler
import com.example.materialdesign.R
import com.example.materialdesign.interfaces.ChosenDeck
import com.example.materialdesign.model.Card
import com.example.materialdesign.model.getCards

internal class CardRecyclerAdapter(private val parent: FragmentRecycler)
    : RecyclerView.Adapter<CardViewHolder>(), ChosenDeck {

    private val cards = getCards()
    val chosenCards = cards

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.textTitle.text = card.title
        holder.textDescription.text = card.description
        holder.imageView.setImageResource(card.image)
        holder.itemView.setOnClickListener { _ -> showDetails(position) }
        holder.chip.setOnCheckedChangeListener { buttonView, isChecked -> myToast("$isChecked") }
    }

    private fun myToast(text: String) {
        Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun delete(pozition: Int) {
        cards.removeAt(pozition)
        notifyItemRemoved(pozition)
    }

    fun move(fromPoz: Int, toPoz: Int) {
        Collections.swap(cards, fromPoz, toPoz)
        notifyItemMoved(fromPoz, toPoz)
    }

    private fun showDetails(pozition: Int) {
        val fragment = FragmentDetails()
        fragment.card = cards[pozition]
        showDetaisFragment(fragment)
    }

    private fun showDetaisFragment(fragment: FragmentDetails) {
        if (parent.fragmentManager != null) {

            val changeBounds = ChangeBounds()
            changeBounds.pathMotion = ArcMotion()
            changeBounds.duration = 500
            changeBounds.interpolator = OvershootInterpolator(1.5f)
            fragment.sharedElementEnterTransition = changeBounds

            parent.fragmentManager!!.beginTransaction()
                    .replace(R.id.container_home, fragment)
                    .addToBackStack("details").commit()
        }
    }

    override fun getDeck(): ArrayList<Card> {
        return cards
    }
}



