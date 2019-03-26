package com.br.horasestudos.views.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.horasestudos.R;
import com.br.horasestudos.views.business.DisciplineBusiness;

import java.util.Scanner;

public class AddHoursActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();
    private DisciplineBusiness business = new DisciplineBusiness();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hours);

        viewHolder.btnSalvar = findViewById(R.id.btn_add_save);
        viewHolder.btnCancelar = findViewById(R.id.btn_add_cancel);
        viewHolder.edtStart = findViewById(R.id.start_hour);
        viewHolder.edtFinish = findViewById(R.id.finish_hour);

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
        EditText edtStart, edtFinish;
    }

    private void listener() {
        viewHolder.btnSalvar.setOnClickListener(this);
        viewHolder.btnCancelar.setOnClickListener(this);
    }

    private void sumHour() {
        String a = viewHolder.edtStart.getText().toString();
        String b = viewHolder.edtFinish.getText().toString();


        a = a.replaceAll(":", "");
        b = b.replaceAll(":", "");

        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);


        business.sumHour(num1, num2);

        System.out.println("++++++++++++++++++++++++++++++++++++++++ = " + business.sumHour(num1, num2));


    }
}
