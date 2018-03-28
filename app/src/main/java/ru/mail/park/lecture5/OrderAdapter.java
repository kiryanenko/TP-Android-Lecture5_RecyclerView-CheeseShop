package ru.mail.park.lecture5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kiryanenko on 21.03.18.
 */

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Cheese> cart;


    public OrderAdapter() {
        cart = new ArrayList<>();
        cart.addAll(Cheeses.getShoppingCart());
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View cardView = LayoutInflater.from(context).inflate(R.layout.item_cheese_card, parent, false);
        return new OrderAdapter.CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Cheese cheese = cart.get(position);
        Context context = holder.itemView.getContext();
        CardViewHolder cardHolder = ((CardViewHolder) holder);

        cardHolder.textView.setText(cheese.getTitle());
        cardHolder.price.setText(context.getString(R.string.price, cheese.getPrice()));

        int imageResId = cheese.getImageResId();
        Glide.with(context).load(imageResId).into(cardHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }


    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView price;

        CardViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.price);
        }
    }
}
