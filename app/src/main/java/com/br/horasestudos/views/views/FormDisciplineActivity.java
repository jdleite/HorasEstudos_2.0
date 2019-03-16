package com.br.horasestudos.views.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.br.horasestudos.R;
import com.br.horasestudos.views.business.DisciplineBusiness;
import com.br.horasestudos.views.entity.Discipline;

public class FormDisciplineActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();
    DisciplineBusiness business;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_discipline);

        viewHolder.edtDiscipline = findViewById(R.id.edtDiscipline);
        viewHolder.btnSave = findViewById(R.id.btnSave);
        viewHolder.btnCancel = findViewById(R.id.btnCancel);

        listener();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave){
            saveDiscipline();
        }else if(v.getId() == R.id.btnCancel){
            finish();
        }

    }

    private static class ViewHolder{
        EditText edtDiscipline;
        Button btnSave,btnCancel;
    }

    private void saveDiscipline(){
        Discipline discipline = new Discipline();
        business = new DisciplineBusiness();

        discipline.setName(viewHolder.edtDiscipline.getText().toString());



        business.saveDiscipline(discipline);


    }

    private void listener(){
        viewHolder.btnSave.setOnClickListener(this);
        viewHolder.btnCancel.setOnClickListener(this);
    }
}
