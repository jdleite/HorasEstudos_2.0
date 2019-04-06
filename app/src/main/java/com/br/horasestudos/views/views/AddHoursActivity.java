package com.br.horasestudos.views.views;

import android.app.TimePickerDialog;
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

import java.util.Calendar;
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
        viewHolder.edtFinish = findViewById(R.id.finish_hour);
        viewHolder.edtStart = findViewById(R.id.star_hour);
        viewHolder.edtFinish = findViewById(R.id.finish_hour);


        listener();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_save) {
            sumHour();

        } else if (v.getId() == R.id.btn_add_cancel) {
            finish();
        } else if (v.getId() == R.id.finish_hour) {

            displayHour();
        } else if (v.getId() == R.id.star_hour) {
            displayHour();
        }
    }

    private static class ViewHolder {
        Button btnSalvar, btnCancelar;
        EditText edtStart, edtFinish, chooseTime;
    }

    private void listener() {
        viewHolder.btnSalvar.setOnClickListener(this);
        viewHolder.btnCancelar.setOnClickListener(this);
        viewHolder.edtStart.setOnClickListener(this);
        viewHolder.edtFinish.setOnClickListener(this);
    }

    private void sumHour() {

        Bundle bundle = getIntent().getExtras();

        int disciplineId = bundle.getInt(Constants.BundleConstants.BUNDLE_ID);


        String a = viewHolder.edtStart.getText().toString();
        String b = viewHolder.edtFinish.getText().toString();


        a = a.replaceAll(":", "");
        b = b.replaceAll(":", "");

        float num1 = Float.parseFloat(a);
        float num2 = Float.parseFloat(b);
        float res = 0;


        if (num1 > num2) {
            res = num1 - num2;
        } else {
            res = num2 - num1;
        }


        business.insertHour(disciplineId, res);

        Toast.makeText(getApplicationContext(),"Foi adicionado " + res + " Hora(s)",Toast.LENGTH_SHORT).show();


    }

    private void displayHour() {
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {


                if (viewHolder.edtStart.hasFocus()) {

                    viewHolder.edtStart.setText(String.format("%02d:%02d", hourOfDay, minutes));

                } else {

                    viewHolder.edtFinish.setText(String.format("%02d:%02d", hourOfDay, minutes));

                }


            }
        }, currentHour, currentMinute, false);
        timePickerDialog.show();


    }
}
