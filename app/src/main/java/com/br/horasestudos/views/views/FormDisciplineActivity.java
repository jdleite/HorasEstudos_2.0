package com.br.horasestudos.views.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.horasestudos.R;
import com.br.horasestudos.views.business.DisciplineBusiness;
import com.br.horasestudos.views.constants.Constants;
import com.br.horasestudos.views.entity.Discipline;
import com.br.horasestudos.views.repository.DisciplineRepository;

public class FormDisciplineActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();
    DisciplineBusiness business;

    private int disciplineId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_discipline);

        business = new DisciplineBusiness();

        viewHolder.edtDiscipline = findViewById(R.id.edtDiscipline);
        viewHolder.btnSave = findViewById(R.id.btnSave);
        viewHolder.btnCancel = findViewById(R.id.btnCancel);

        loadData();

        listener();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            saveDiscipline();
        } else if (v.getId() == R.id.btnCancel) {
            finish();
        }

    }

    private static class ViewHolder {
        EditText edtDiscipline;
        Button btnSave, btnCancel;
    }

    private void saveDiscipline() {
        if (!validate()) {
            return;
        } else {

            Discipline discipline = new Discipline();
            business = new DisciplineBusiness();

            discipline.setName(viewHolder.edtDiscipline.getText().toString());

            if (disciplineId == 0) {

                if (business.saveDiscipline(discipline)){

                    Toast.makeText(getApplicationContext(), getString(R.string.salvo_sucesso), Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(getApplicationContext(), getString(R.string.erro_salvar), Toast.LENGTH_LONG).show();

                }


            } else {

                discipline.setId(disciplineId);
                if (business.updateDiscipline(discipline)){

                    Toast.makeText(getApplicationContext(),getString(R.string.alterado_sucesso), Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getApplicationContext(),getString(R.string.erro_alterar), Toast.LENGTH_LONG).show();
                }
            }


            disciplineId = 0;
            finish();




        }


    }

    private void listener() {
        viewHolder.btnSave.setOnClickListener(this);
        viewHolder.btnCancel.setOnClickListener(this);
    }

    private Boolean validate() {
        if (viewHolder.edtDiscipline.getText().toString().trim().equalsIgnoreCase("")) {
            viewHolder.edtDiscipline.setError(getString(R.string.campo_obrigatorio));
            return false;
        }

        return true;
    }

    private void loadData() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            disciplineId = b.getInt(Constants.BundleConstants.BUNDLE_ID);
            Discipline discipline = business.loadDiscipline(disciplineId);
            viewHolder.edtDiscipline.setText(discipline.getName());
        }
    }
}
