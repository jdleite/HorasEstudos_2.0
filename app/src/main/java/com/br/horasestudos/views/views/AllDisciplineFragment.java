package com.br.horasestudos.views.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.horasestudos.R;
import com.br.horasestudos.views.banco.CreateDatabase;
import com.br.horasestudos.views.business.DisciplineBusiness;

public class AllDisciplineFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new CreateDatabase().create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_discipline, container, false);
    }


}
