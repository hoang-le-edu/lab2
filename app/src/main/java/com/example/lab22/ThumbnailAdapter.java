package com.example.lab22;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Activity context;

    public ThumbnailAdapter(Activity context, int layoutID, List<Thumbnail> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // Sử dụng view item_thumbnail.xml để hiển thị nội dung thumbnail trong dropdown (dạng dialog)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
        }

        Thumbnail thumbnail = getItem(position);

        ImageView ivThumbnail = convertView.findViewById(R.id.ivThumbnail);
        TextView tvThumbnailName = convertView.findViewById(R.id.tvThumbnailName);

        if (thumbnail != null) {
            ivThumbnail.setImageResource(thumbnail.getImg());
            tvThumbnailName.setText(thumbnail.getName());
        }

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Sử dụng view item_selected_thumbnail.xml để hiển thị nội dung thumbnail được chọn lên spinner
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail, parent, false);
        }

        Thumbnail thumbnail = getItem(position);

        TextView tvThumbnailName = convertView.findViewById(R.id.tvThumbnailName);

        if (thumbnail != null) {
            tvThumbnailName.setText(thumbnail.getName());
        }

        return convertView;
    }
}

