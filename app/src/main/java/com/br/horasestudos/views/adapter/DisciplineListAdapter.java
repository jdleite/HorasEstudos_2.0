package com.br.horasestudos.views.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.horasestudos.R;
import com.br.horasestudos.views.listener.DisciplineListener;
import com.br.horasestudos.views.repository.Discipline;
import com.br.horasestudos.views.viewHolder.DisciplineViewHolder;

import java.util.List;

public class DisciplineListAdapter extends RecyclerView.Adapter<DisciplineViewHolder> {

    private List<Discipline> disciplineList;
    private DisciplineListener listener;

    public DisciplineListAdapter(List<Discipline> disciplines,DisciplineListener adapterListener){
        disciplineList = disciplines;
        listener = adapterListener;
    }


    @NonNull
    @Override
    public DisciplineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View disciplineView = inflater.inflate(R.layout.row_discipline,viewGroup,false);
        return new DisciplineViewHolder(disciplineView,context);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplineViewHolder disciplineViewHolder, int i) {
        Discipline discipline = disciplineList.get(i);
        disciplineViewHolder.bindData(discipline,listener);

    }

    @Override
    public int getItemCount() {
        return disciplineList.size();
    }
}
