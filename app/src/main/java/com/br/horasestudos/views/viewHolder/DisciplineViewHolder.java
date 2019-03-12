package com.br.horasestudos.views.viewHolder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.horasestudos.R;
import com.br.horasestudos.views.listener.DisciplineListener;
import com.br.horasestudos.views.repository.Discipline;

public class DisciplineViewHolder extends RecyclerView.ViewHolder {

    TextView disciplineName;
    ImageView imgRemove;
    Context context;
    public DisciplineViewHolder(@NonNull View itemView,Context contextHolder) {
        super(itemView);


        disciplineName = itemView.findViewById(R.id.txt_name);
        imgRemove  = itemView.findViewById(R.id.img_remove);
        context = contextHolder;
    }

    public void bindData(final Discipline discipline, final DisciplineListener listener){
        disciplineName.setText(discipline.getName());

        disciplineName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                        .setNeutralButton(context.getString(R.string.nao),null)
                        .show();
            }
        });
    }
}
