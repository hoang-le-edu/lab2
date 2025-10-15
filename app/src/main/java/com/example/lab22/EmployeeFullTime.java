package com.example.lab22;

public class EmployeeFullTime extends Employee {

    public EmployeeFullTime(String id, String name) {
        super(id, name);
    }

    @Override
    public double tinhLuong() {
        return 500.0;
    }

    @Override
    public String toString() {
        return id + " - " + name + " -->FullTime=" + tinhLuong();
    }
}

