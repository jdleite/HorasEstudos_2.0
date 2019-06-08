package com.br.horasestudos.views.viewHolder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.horasestudos.R;
import com.br.horasestudos.views.listener.DisciplineListener;
import com.br.horasestudos.views.entity.Discipline;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class DisciplineViewHolder extends RecyclerView.ViewHolder {

    TextView disciplineName, all_hours,all_minute;
    ImageView imgRemove, imgPlus, imgPencil;
    Context context;
    public static int point;

    public DisciplineViewHolder(@NonNull View itemView, Context contextHolder) {
        super(itemView);


        disciplineName = itemView.findViewById(R.id.txt_name);

        imgPencil = itemView.findViewById(R.id.img_pencil);
        imgRemove = itemView.findViewById(R.id.img_remove);
        imgPlus = itemView.findViewById(R.id.img_plus);
        all_hours = itemView.findViewById(R.id.all_hour);
        all_minute = itemView.findViewById(R.id.all_minute);
        context = contextHolder;

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher mtw = new MaskTextWatcher(all_hours,smf);
        all_hours.addTextChangedListener(mtw);
    }

    public void bindData(final Discipline discipline, final DisciplineListener listener) {
        disciplineName.setText(discipline.getName());
        all_hours.setText(String.valueOf(discipline.changeToHour()));
        all_minute.setText(String.valueOf(discipline.changeToMinute()));

        imgPencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point = 0;
                listener.onListClick(discipline.getId());
            }
        });

        imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle(context.getString(R.string.remocao_materia))
                        .setMessage(context.getString(R.string.deseja_remover))
                        .setIcon(R.drawable.close)
                        .setPositiveButton(context.getString(R.string.sim), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                listener.onDeleteClick(discipline.getId());

                            }
                        })
                        .setNeutralButton(context.getString(R.string.nao), null)
                        .show();
            }
        });

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                point = 1;
                listener.onListClick(discipline.getId());


            }
        });
    }
}
