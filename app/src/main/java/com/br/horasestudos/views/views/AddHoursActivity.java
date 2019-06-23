package com.br.horasestudos.views.views;

import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class AddHoursActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();
    private DisciplineBusiness business;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hours);

        business = new DisciplineBusiness();

        viewHolder.btnSalvar = findViewById(R.id.btn_add_save);
        viewHolder.btnCancelar = findViewById(R.id.btn_add_cancel);
        viewHolder.edtStart = findViewById(R.id.star_hour);
        viewHolder.edtFish = findViewById(R.id.finish_hour);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher mtw = new MaskTextWatcher(viewHolder.edtStart, smf);
        MaskTextWatcher mty = new MaskTextWatcher(viewHolder.edtFish, smf);

        viewHolder.edtStart.addTextChangedListener(mtw);
        viewHolder.edtFish.addTextChangedListener(mty);


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
        EditText edtStart, edtFish;
    }

    private void listener() {
        viewHolder.btnSalvar.setOnClickListener(this);
        viewHolder.btnCancelar.setOnClickListener(this);
        viewHolder.edtStart.setOnClickListener(this);
    }

    //valida a hora e adiciona no banco
    @TargetApi(Build.VERSION_CODES.O)
    private void sumHour() {

        if (!validar()) {
            return;
        } else {
            Bundle bundle = getIntent().getExtras();

            int disciplineId = bundle.getInt(Constants.BundleConstants.BUNDLE_ID);

            Calendar c = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


            c.getTime();


            String horario1 = viewHolder.edtStart.getText().toString();
            String horario2 = viewHolder.edtFish.getText().toString();
            LocalTime lt1 = LocalTime.parse(horario1);
            LocalTime lt2 = LocalTime.parse(horario2);


            long emMinutos = lt1.until(lt2, ChronoUnit.MINUTES);


            if (lt1.equals(lt2)) {
                Toast.makeText(getApplicationContext(), getString(R.string.horas_iguais), Toast.LENGTH_SHORT).show();

            } else if (emMinutos < 0) {
                Toast.makeText(getApplicationContext(), getString(R.string.hora_negativa), Toast.LENGTH_SHORT).show();


            } else {


            business.insertHour(disciplineId, sdf.format(c.getTime()), emMinutos);

            Toast.makeText(getApplicationContext(), getString(R.string.adicionado_sucesso), Toast.LENGTH_SHORT).show();


            startActivity(new Intent(AddHoursActivity.this, MainActivity.class));

        }


    }

}

    //metodo que valida se os campos estão preenchidos corretamente
    private boolean validar() {

        if (viewHolder.edtStart.getText().toString().trim().isEmpty()) {
            viewHolder.edtStart.setError(getString(R.string.campo_vazio));
            return false;
        } else if (viewHolder.edtFish.getText().toString().trim().isEmpty()) {
            viewHolder.edtFish.setError(getString(R.string.campo_vazio));
            return false;
        } else if (viewHolder.edtStart.getText().toString().length() < 5) {
            clearHour();
            viewHolder.edtStart.setError(getString(R.string.hora_completa));
            return false;
        } else if (viewHolder.edtFish.getText().toString().length() < 5) {
            clearHour();
            viewHolder.edtFish.setError(getString(R.string.hora_completa));
        }


        return true;
    }
    //limpa os campos
    private void clearHour() {
        viewHolder.edtStart.setText("");
        viewHolder.edtFish.setText("");

    }
}
