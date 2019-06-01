package com.br.horasestudos.views.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.horasestudos.R;
import com.br.horasestudos.views.adapter.AllHoursAdapter;
import com.br.horasestudos.views.adapter.DisciplineListAdapter;
import com.br.horasestudos.views.banco.MyApp;
import com.br.horasestudos.views.business.DisciplineBusiness;
import com.br.horasestudos.views.entity.Discipline;
import com.br.horasestudos.views.listener.DisciplineListener;

import java.util.ArrayList;
import java.util.List;


public class AllHoursFragment extends Fragment {

    ViewHolder viewHolder = new ViewHolder();
    DisciplineBusiness business;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_all_hours, container, false);
        business = new DisciplineBusiness();

        viewHolder.recyclerView = view.findViewById(R.id.recycler_all_hour);


        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));

        onResume();



        return view;
    }

    private static class ViewHolder{
        RecyclerView recyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();

        List<Discipline> disciplines = new ArrayList<>();
        disciplines.addAll(business.listDiscipline());

        AllHoursAdapter adapter = new AllHoursAdapter(disciplines);
        viewHolder.recyclerView.setAdapter(adapter);
    }
}
