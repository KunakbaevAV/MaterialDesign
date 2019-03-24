package com.example.materialdesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CardViewHolder> {
    private ArrayList<Card> cards;

    public MyRecyclerAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.textTitle.setText(card.getTitle());
        holder.textDescription.setText(card.getDescription());
        holder.imageView.setImageResource(card.getImage());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void delete(int pozition) {
        cards.remove(pozition);
        notifyItemRemoved(pozition);
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;
        ImageView imageView;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.card_title);
            textDescription = itemView.findViewById(R.id.card_description);
            imageView = itemView.findViewById(R.id.card_image);
        }

    }

}



