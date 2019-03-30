package com.example.materialdesign;

import android.content.Context;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.PathMotion;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.materialdesign.interfaces.CardOpener;
import com.example.materialdesign.interfaces.DraggableViewHolder;
import com.example.materialdesign.model.Card;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.materialdesign.model.DeckKt.getCards;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {
    private ArrayList<Card> cards = getCards();
    private FragmentHome parent;

    public CardRecyclerAdapter(FragmentHome parent) {
        this.parent = parent;
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
        holder.itemView.setOnClickListener(v -> showDetails(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void delete(int pozition) {
        cards.remove(pozition);
        notifyItemRemoved(pozition);
    }

    public void move(int fromPoz, int toPoz) {
        Collections.swap(cards, fromPoz, toPoz);
        notifyItemMoved(fromPoz, toPoz);
    }

    private void showDetails(int pozition) {
        FragmentDetails fragment = new FragmentDetails();
        fragment.setCard(cards.get(pozition));
        showDetaisFragment(fragment);
    }

    private void showDetaisFragment(FragmentDetails fragment) {
        if (parent.getFragmentManager() != null) {

            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setPathMotion(new ArcMotion());
            changeBounds.setDuration(500);
            changeBounds.setInterpolator(new OvershootInterpolator(1.5f));
            fragment.setSharedElementEnterTransition(changeBounds);

            parent.getFragmentManager().beginTransaction()
                    .replace(R.id.container_home, fragment)
                    .addToBackStack("details").commit();
        }
    }

    class CardViewHolder extends RecyclerView.ViewHolder implements DraggableViewHolder {
        TextView textTitle;
        TextView textDescription;
        ImageView imageView;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.card_title);
            textDescription = itemView.findViewById(R.id.card_description);
            imageView = itemView.findViewById(R.id.card_image);
        }

        @Override
        public void onSelected() {
            itemView.animate().scaleX(0.8f).scaleY(0.8f).setDuration(400);
        }

        @Override
        public void onClear() {
            itemView.animate().scaleX(1f).scaleY(1f).setDuration(400);
        }
    }

}



