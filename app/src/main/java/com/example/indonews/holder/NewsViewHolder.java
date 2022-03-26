package com.example.indonews.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indonews.R;
import com.google.android.material.card.MaterialCardView;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView title, publishedAt;
    public MaterialCardView cvNews;
    public View view;

    public NewsViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        cvNews = itemView.findViewById(R.id.cvNews);
        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        publishedAt = itemView.findViewById(R.id.publishedAt);
        this.view = itemView;


    }
}
