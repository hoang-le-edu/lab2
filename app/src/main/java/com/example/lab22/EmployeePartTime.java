package com.example.lab22;

public class EmployeePartTime extends Employee {

    public EmployeePartTime(String id, String name) {
        super(id, name);
    }

    @Override
    public double tinhLuong() {
        return 150.0;
    }

    @Override
    public String toString() {
        return id + " - " + name + " -->PartTime=" + tinhLuong();
    }
}

