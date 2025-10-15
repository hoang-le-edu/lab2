package com.example.lab22;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai2Activity extends AppCompatActivity {

    EditText etName;
    Button btnAdd;
    TextView tvSelection;
    ListView lvNames;
    ArrayList<String> names;
    ArrayAdapter<String> adapter;
    View previousSelectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);
        tvSelection = findViewById(R.id.tvSelection);
        lvNames = findViewById(R.id.lvNames);

        // Tạo ArrayList và thêm dữ liệu mẫu
        names = new ArrayList<>();
        names.add("teo");
        names.add("ty");
        names.add("bin");

        // Tạo adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        lvNames.setAdapter(adapter);

        // Xử lý sự kiện nút Nhập
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                if (!name.isEmpty()) {
                    // Thêm dữ liệu vào ArrayList
                    names.add(name);
                    // Cập nhật giao diện
                    adapter.notifyDataSetChanged();
                    // Xóa nội dung EditText
                    etName.setText("");
                    Toast.makeText(Bai2Activity.this, "Đã thêm: " + name, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Bai2Activity.this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện khi click vào item
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
                String selectedItem = names.get(position);
                tvSelection.setText("Vị trí: " + (position + 1) + " - Giá trị: " + selectedItem);
            }
        });

        // Xử lý sự kiện long click để xóa
        lvNames.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String removedItem = names.get(position);
                names.remove(position);
                adapter.notifyDataSetChanged();
                
                // Reset previousSelectedView vì item có thể đã bị xóa
                previousSelectedView = null;
                
                Toast.makeText(Bai2Activity.this, "Đã xóa: " + removedItem, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

