package com.example.lab22;

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
    String[] names = {"Tèo", "Tý", "Bìn", "Bo"};

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
                String selectedItem = names[position];
                tvSelection.setText("Vị trí: " + (position + 1) + " - Giá trị: " + selectedItem);
            }
        });
    }
}

