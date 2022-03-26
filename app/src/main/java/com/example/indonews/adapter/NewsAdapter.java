package com.example.indonews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.indonews.R;
import com.example.indonews.holder.NewsViewHolder;
import com.example.indonews.model.ModelNews;
import com.example.indonews.utils.TimeUnits;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<ModelNews> newsList;
    private Context mContext;
    private NewsAdapter.onSelectData onSelectData;

    public interface onSelectData {
        void onSelected(ModelNews mdlNews);
    }

    public NewsAdapter(List<ModelNews> newsList, Context mContext, NewsAdapter.onSelectData onSelectData) {
        this.newsList = newsList;
        this.mContext = mContext;
        this.onSelectData = onSelectData;
    }

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_berita, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsViewHolder holder, int position) {
        final ModelNews berita = newsList.get(position);
        Glide.with(mContext)
                .load(berita.getUrlToImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_baseline_image_24)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.image);

        holder.title.setText(berita.getTitle());
        holder.publishedAt.setText(TimeUnits.getTimeAgo(berita.getPublishedAt()));
        holder.cvNews.setOnClickListener(v -> onSelectData.onSelected(berita));

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
