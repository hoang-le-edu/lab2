package com.example.lab22;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    
    private ArrayList<Hero> mHeros;
    
    public HeroAdapter(ArrayList<Hero> mHeros) {
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View heroView = inflater.inflate(R.layout.item_hero, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = mHeros.get(position);
        holder.mImageHero.setImageResource(hero.getImage());
        holder.mTextName.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }

    // Tạo class ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageHero;
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageHero = itemView.findViewById(R.id.image_hero);
            mTextName = itemView.findViewById(R.id.text_name);
        }
    }
}

