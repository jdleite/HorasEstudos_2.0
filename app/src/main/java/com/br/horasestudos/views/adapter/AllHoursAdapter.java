package com.br.horasestudos.views.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.br.horasestudos.R;
import com.br.horasestudos.views.entity.Discipline;
import com.br.horasestudos.views.viewHolder.AllHoursViewHolder;

import java.util.List;

public class AllHoursAdapter extends RecyclerView.Adapter<AllHoursViewHolder> {

    List<Discipline> mDisciplines;

    public AllHoursAdapter(List<Discipline> disciplines){
        mDisciplines = disciplines;
    }
    @NonNull
    @Override
    public AllHoursViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_all_hours,viewGroup,false);


        return new AllHoursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllHoursViewHolder allHoursViewHolder, int i) {

        Discipline  discipline = mDisciplines.get(i);

        allHoursViewHolder.bindData(discipline);

    }

    @Override
    public int getItemCount() {
        return mDisciplines.size();
    }
}
