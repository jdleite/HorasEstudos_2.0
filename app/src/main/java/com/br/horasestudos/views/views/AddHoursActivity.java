package com.br.horasestudos.views.views;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.br.horasestudos.R;
import com.br.horasestudos.views.business.DisciplineBusiness;
import com.br.horasestudos.views.constants.Constants;
import com.br.horasestudos.views.entity.Discipline;
import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddHoursActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();
    private DisciplineBusiness business;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hours);

        business = new DisciplineBusiness();

        viewHolder.btnSalvar = findViewById(R.id.btn_add_save);
        viewHolder.btnCancelar = findViewById(R.id.btn_add_cancel);
        viewHolder.edtStart = findViewById(R.id.star_hour);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher mtw = new MaskTextWatcher(viewHolder.edtStart, smf);
        viewHolder.edtStart.addTextChangedListener(mtw);



        listener();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_save) {
            sumHour();


        } else if (v.getId() == R.id.btn_add_cancel) {
            finish();

        }
    }

    private static class ViewHolder {
        Button btnSalvar, btnCancelar;
        EditText edtStart;
    }

    private void listener() {
        viewHolder.btnSalvar.setOnClickListener(this);
        viewHolder.btnCancelar.setOnClickListener(this);
        viewHolder.edtStart.setOnClickListener(this);
    }

    private void sumHour() {



    }



    private boolean validar() {
        if (viewHolder.edtStart.getText().toString().trim().isEmpty()) {
            viewHolder.edtStart.setError(getString(R.string.campo_vazio));
            return false;
        }

        return true;
    }
}
