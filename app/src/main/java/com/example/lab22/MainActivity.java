package com.example.lab22;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBai1, btnBai2, btnBai3, btnBai4, btnBai5, btnBai6, btnBai7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);
        btnBai3 = findViewById(R.id.btnBai3);
        btnBai4 = findViewById(R.id.btnBai4);
        btnBai5 = findViewById(R.id.btnBai5);
        btnBai6 = findViewById(R.id.btnBai6);
        btnBai7 = findViewById(R.id.btnBai7);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai1Activity.class);
                startActivity(intent);
            }
        });

        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai2Activity.class);
                startActivity(intent);
            }
        });

        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai3Activity.class);
                startActivity(intent);
            }
        });

        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai4Activity.class);
                startActivity(intent);
            }
        });

        btnBai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai5Activity.class);
                startActivity(intent);
            }
        });

        btnBai6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai6Activity.class);
                startActivity(intent);
            }
        });

        btnBai7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai7Activity.class);
                startActivity(intent);
            }
        });
    }
}