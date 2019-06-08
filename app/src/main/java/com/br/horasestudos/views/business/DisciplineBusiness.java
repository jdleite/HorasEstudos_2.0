package com.br.horasestudos.views.business;

import android.database.sqlite.SQLiteDatabase;

import com.br.horasestudos.views.banco.MainDb;
import com.br.horasestudos.views.entity.Discipline;
import com.br.horasestudos.views.repository.DisciplineRepository;
import com.br.horasestudos.views.views.MainActivity;

import java.util.List;

public class DisciplineBusiness {

    DisciplineRepository repository = new DisciplineRepository();

    public Boolean saveDiscipline(Discipline discipline) {
        return repository.saveDiscipline(discipline);
    }

    public List<Discipline> listDiscipline() {
        return repository.listDiscipline();
    }

    public Boolean updateDiscipline(Discipline discipline) {
        return repository.updateDiscipline(discipline);

    }

    public Boolean removeDiscipline(int id) {
        return repository.removeDiscipline(id);
    }

    public Discipline loadDiscipline(int id) {
        return repository.loadDiscipline(id);
    }

    public Boolean insertHour(int id, String data, long total) {
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            String query = ("UPDATE Discipline SET date = '" + data + "', all_hours = all_hours + '" + total + "' WHERE ID = '" + id + "'");
            db.execSQL(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
