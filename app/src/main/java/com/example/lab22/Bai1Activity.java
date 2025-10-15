package com.example.lab22;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai1Activity extends AppCompatActivity {

    TextView tvSelection;
    ListView lvNames;
    ArrayAdapter<String> adapter;
    String[] names = {"Tèo", "Tý", "Bin", "Bo"};
    View previousSelectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        tvSelection = findViewById(R.id.tvSelection);
        lvNames = findViewById(R.id.lvNames);

        // Tạo adapter và gán dữ liệu cho ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        lvNames.setAdapter(adapter);

        // Xử lý sự kiện khi click vào item trong ListView
        lvNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Reset màu của item trước đó về trắng
                if (previousSelectedView != null) {
                    previousSelectedView.setBackgroundColor(Color.TRANSPARENT);
                }

                // Set màu xanh lá cho item được chọn
                view.setBackgroundColor(Color.parseColor("#00FF00"));
                
                // Lưu view hiện tại để reset sau
                previousSelectedView = view;

                // Hiển thị thông tin
                String selectedItem = names[position];
                tvSelection.setText("Position: " + (position + 1) + " - Value: " + selectedItem);
            }
        });
    }
}

