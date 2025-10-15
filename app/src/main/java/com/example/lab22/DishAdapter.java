package com.example.lab22;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;

    public DishAdapter(Activity context, int layoutID, List<Dish> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, null, false);
        }

        // Get item
        Dish dish = getItem(position);

        // Get view
        ImageView ivThumbnail = convertView.findViewById(R.id.ivThumbnail);
        TextView tvDishName = convertView.findViewById(R.id.tvDishName);
        ImageView ivStar = convertView.findViewById(R.id.ivStar);

        // Set data
        if (dish != null) {
            if (dish.getThumbnail() != null) {
                ivThumbnail.setImageResource(dish.getThumbnail().getImg());
            }
            
            tvDishName.setText(dish.getName());
            
            // Enable marquee
            tvDishName.setSelected(true);

            // Show star if promotion
            if (dish.isPromotion()) {
                ivStar.setVisibility(View.VISIBLE);
            } else {
                ivStar.setVisibility(View.GONE);
            }
        }

        return convertView;
    }
}

