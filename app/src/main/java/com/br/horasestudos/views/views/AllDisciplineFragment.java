package com.br.horasestudos.views.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.br.horasestudos.R;
import com.br.horasestudos.views.adapter.DisciplineListAdapter;
import com.br.horasestudos.views.banco.CreateDatabase;
import com.br.horasestudos.views.banco.MyApp;
import com.br.horasestudos.views.business.DisciplineBusiness;
import com.br.horasestudos.views.constants.Constants;
import com.br.horasestudos.views.entity.Discipline;
import com.br.horasestudos.views.listener.DisciplineListener;
import com.br.horasestudos.views.viewHolder.DisciplineViewHolder;

import java.util.ArrayList;
import java.util.List;

public class AllDisciplineFragment extends Fragment {

    private ViewHolder viewHolder = new ViewHolder();
    private DisciplineListener listener;
    private DisciplineBusiness business;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_discipline, container, false);


        viewHolder.recyclerView = view.findViewById(R.id.recycler_all_discipline);
        viewHolder.txtName = view.findViewById(R.id.txt_name);


        business = new DisciplineBusiness();

        listener = new DisciplineListener() {
            //Pega o id da posição clicada
            @Override
            public void onListClick(int id) {

                Bundle b = new Bundle();

                b.putInt(Constants.BundleConstants.BUNDLE_ID, id);


                if (DisciplineViewHolder.point == 1) {

                    Intent intent = new Intent(MyApp.getContext(), AddHoursActivity.class);
                    intent.putExtras(b);

                    startActivity(intent);


                } else {

                    Intent intent = new Intent(MyApp.getContext(), FormDisciplineActivity.class);
                    intent.putExtras(b);

                    startActivity(intent);


                }


            }

            //deleta a disciplina passando o id
            @Override
            public void onDeleteClick(int id) {

                business.removeDiscipline(id);
                loadDiscipline();

            }


        };


        loadDiscipline();


        return view;
    }

    private static class ViewHolder {
        RecyclerView recyclerView;
        TextView txtName;
    }

    //Lista a disciplina
    public void loadDiscipline() {
        List<Discipline> listDiscipline = new ArrayList<>();
        DisciplineBusiness business = new DisciplineBusiness();

        listDiscipline.addAll(business.listDiscipline());


        DisciplineListAdapter adapter = new DisciplineListAdapter(listDiscipline, listener);
        viewHolder.recyclerView.setAdapter(adapter);

        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));


    }


    @Override
    public void onResume() {
        super.onResume();

        loadDiscipline();
    }
}
