package com.example.lab22;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<EmployeeRecyclerAdapter.ViewHolder> {
    
    private ArrayList<Employee2> employees;

    public EmployeeRecyclerAdapter(ArrayList<Employee2> employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee2 employee = employees.get(position);

        if (employee.getFullName() != null) {
            holder.tvFullName.setText(employee.getFullName());
        } else {
            holder.tvFullName.setText("");
        }

        // If this is a manager -> show icon manager. Otherwise, show Staff in tvPosition
        if (employee.isManager()) {
            holder.ivManager.setVisibility(View.VISIBLE);
            holder.tvPosition.setVisibility(View.GONE);
        } else {
            holder.ivManager.setVisibility(View.GONE);
            holder.tvPosition.setVisibility(View.VISIBLE);
            holder.tvPosition.setText("Staff");
        }

        // Show different color backgrounds for 2 continuous employees
        if (position % 2 == 0) {
            holder.llParent.setBackgroundResource(R.color.white);
        } else {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        TextView tvPosition;
        ImageView ivManager;
        LinearLayout llParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.item_employee_tv_fullname);
            tvPosition = itemView.findViewById(R.id.item_employee_tv_position);
            ivManager = itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = itemView.findViewById(R.id.llParent);
        }
    }
}

