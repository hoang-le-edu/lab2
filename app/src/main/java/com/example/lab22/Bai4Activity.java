package com.example.lab22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai4Activity extends AppCompatActivity {

    EditText etId, etFullName;
    CheckBox cbIsManager;
    Button btnAdd;
    ListView lvEmployees;
    ArrayList<Employee2> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        etId = findViewById(R.id.etId);
        etFullName = findViewById(R.id.etFullName);
        cbIsManager = findViewById(R.id.cbIsManager);
        btnAdd = findViewById(R.id.btnAdd);
        lvEmployees = findViewById(R.id.lvEmployees);

        // Tạo ArrayList và thêm dữ liệu mẫu
        employees = new ArrayList<>();
        employees.add(new Employee2("Nhan", "", false));
        employees.add(new Employee2("Van", "", true));
        employees.add(new Employee2("An", "", false));
        employees.add(new Employee2("Binh", "", false));

        // Tạo custom adapter
        adapter = new EmployeeAdapter(this, R.layout.item_employee, employees);
        lvEmployees.setAdapter(adapter);

        // Xử lý sự kiện nút Add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });
    }

    private void addNewEmployee() {
        // Lấy dữ liệu từ EditText
        String id = etId.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();

        // Kiểm tra dữ liệu
        if (id.isEmpty() || fullName.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy trạng thái checkbox
        boolean isManager = cbIsManager.isChecked();

        // Tạo employee mới
        Employee2 employee = new Employee2(id, fullName, isManager);

        // Đưa employee vào ArrayList
        employees.add(employee);

        // Cập nhật giao diện
        adapter.notifyDataSetChanged();

        // Xóa nội dung
        etId.setText("");
        etFullName.setText("");
        cbIsManager.setChecked(false);

        Toast.makeText(this, "Đã thêm: " + fullName, Toast.LENGTH_SHORT).show();
    }
}

