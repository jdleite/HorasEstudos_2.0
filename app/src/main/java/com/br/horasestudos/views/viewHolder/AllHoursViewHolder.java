package com.br.horasestudos.views.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.br.horasestudos.R;
import com.br.horasestudos.views.entity.Discipline;

public class AllHoursViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, txtHours;

    public AllHoursViewHolder(@NonNull View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txt_all_hours_name);
        txtHours = itemView.findViewById(R.id.txt_hours);

    }

    public void bindData(Discipline discipline) {
        txtName.setText(discipline.getName());
        txtHours.setText(String.valueOf(discipline.changeToHour()));
    }
}