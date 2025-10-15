package com.example.lab22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Bai5Activity extends AppCompatActivity {

    EditText etDishName;
    Spinner spThumbnail;
    CheckBox cbPromotion;
    Button btnAddDish;
    GridView gvDishes;
    
    ArrayList<Thumbnail> thumbnails;
    ThumbnailAdapter thumbnailAdapter;
    
    ArrayList<Dish> dishes;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        etDishName = findViewById(R.id.etDishName);
        spThumbnail = findViewById(R.id.spThumbnail);
        cbPromotion = findViewById(R.id.cbPromotion);
        btnAddDish = findViewById(R.id.btnAddDish);
        gvDishes = findViewById(R.id.gvDishes);

        // Khởi tạo danh sách thumbnails cho spinner
        thumbnails = new ArrayList<>(Arrays.asList(Thumbnail.values()));
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_selected_thumbnail, thumbnails);
        thumbnailAdapter.setDropDownViewResource(R.layout.item_thumbnail);
        spThumbnail.setAdapter(thumbnailAdapter);

        // Khởi tạo danh sách món ăn mẫu
        dishes = new ArrayList<>();
        dishes.add(new Dish("Dish 01", Thumbnail.Thumbnail1, true));
        dishes.add(new Dish("Dish 02", Thumbnail.Thumbnail2, false));

        // Khởi tạo adapter cho GridView
        dishAdapter = new DishAdapter(this, R.layout.item_dish, dishes);
        gvDishes.setAdapter(dishAdapter);

        // Xử lý sự kiện thêm món ăn
        btnAddDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewDish();
            }
        });
    }

    private void addNewDish() {
        String name = etDishName.getText().toString().trim();
        
        if (name.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên món ăn", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy thumbnail được chọn từ spinner
        Thumbnail selectedThumbnail = (Thumbnail) spThumbnail.getSelectedItem();
        
        // Lấy trạng thái promotion
        boolean isPromotion = cbPromotion.isChecked();

        // Tạo món ăn mới
        Dish newDish = new Dish(name, selectedThumbnail, isPromotion);
        
        // Thêm vào danh sách
        dishes.add(newDish);
        
        // Cập nhật giao diện
        dishAdapter.notifyDataSetChanged();

        // Reset form
        etDishName.setText("");
        spThumbnail.setSelection(0);
        cbPromotion.setChecked(false);

        Toast.makeText(this, "Added successfully!", Toast.LENGTH_SHORT).show();
    }
}

