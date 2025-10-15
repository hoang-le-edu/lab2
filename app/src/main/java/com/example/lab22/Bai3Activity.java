package com.example.lab22;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity {

    EditText etMaNV, etTenNV;
    RadioGroup rgLoaiNV;
    RadioButton rbChinhThuc, rbThoiVu;
    Button btnNhapNV;
    ListView lvEmployees;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        etMaNV = findViewById(R.id.etMaNV);
        etTenNV = findViewById(R.id.etTenNV);
        rgLoaiNV = findViewById(R.id.rgLoaiNV);
        rbChinhThuc = findViewById(R.id.rbChinhThuc);
        rbThoiVu = findViewById(R.id.rbThoiVu);
        btnNhapNV = findViewById(R.id.btnNhapNV);
        lvEmployees = findViewById(R.id.lvEmployees);

        // Tạo ArrayList và thêm dữ liệu mẫu
        employees = new ArrayList<>();
        employees.add(new EmployeeFullTime("m1", "Nguyen Thi Teo"));
        employees.add(new EmployeePartTime("m2", "Tran Van Ty"));
        employees.add(new EmployeeFullTime("m3", "Ho DO"));

        // Tạo adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        lvEmployees.setAdapter(adapter);

        // Xử lý sự kiện nút Nhập NV
        btnNhapNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });
    }

    private void addNewEmployee() {
        // Lấy dữ liệu từ EditText
        String id = etMaNV.getText().toString().trim();
        String name = etTenNV.getText().toString().trim();

        // Kiểm tra dữ liệu
        if (id.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy id của RadioButton được checked
        int radId = rgLoaiNV.getCheckedRadioButtonId();
        Employee employee;

        if (radId == R.id.rbChinhThuc) {
            // Tạo instance là FullTime
            employee = new EmployeeFullTime(id, name);
        } else {
            // Tạo instance là PartTime
            employee = new EmployeePartTime(id, name);
        }

        // FullTime hay PartTime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);

        // Đưa employee vào ArrayList
        employees.add(employee);

        // Cập nhật giao diện
        adapter.notifyDataSetChanged();

        // Xóa nội dung EditText
        etMaNV.setText("");
        etTenNV.setText("");

        Toast.makeText(this, "Đã thêm nhân viên: " + name, Toast.LENGTH_SHORT).show();
    }
}

