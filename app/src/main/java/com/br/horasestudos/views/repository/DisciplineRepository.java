package com.br.horasestudos.views.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.br.horasestudos.views.banco.MainDb;
import com.br.horasestudos.views.constants.Constants;
import com.br.horasestudos.views.entity.Discipline;

import java.util.ArrayList;
import java.util.List;

public class DisciplineRepository {

    public Boolean saveDiscipline(Discipline discipline) {
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(Constants.DesciplineConstants.NAME, discipline.getName());
            cv.put(Constants.DesciplineConstants.HOUR, discipline.getHour());
            cv.put(Constants.DesciplineConstants.DATE, discipline.getDate());
            cv.put(Constants.DesciplineConstants.ALL_HOURS, discipline.getAll_hours());

            db.insert(MainDb.TABELA, null, cv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Discipline> listDiscipline() {
        List<Discipline> disciplines = new ArrayList<>();
        try {
            SQLiteDatabase db = MainDb.getInstance().getReadableDatabase();
            String query = "SELECT * FROM " + MainDb.TABELA + " ORDER BY ID DESC";
            Cursor c = db.rawQuery(query, null);

            if (c.moveToFirst()) {
                do {
                    Discipline discipline = new Discipline();

                    discipline.setId(c.getInt(0));
                    discipline.setName(c.getString(1));
                    discipline.setHour(c.getFloat(2));
                    discipline.setDate(c.getString(3));
                    discipline.setAll_hours(c.getFloat(4));


                    disciplines.add(discipline);

                } while (c.moveToNext());
            }
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return disciplines;
    }

    public Boolean updateDiscipline(Discipline discipline) {
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(Constants.DesciplineConstants.NAME, discipline.getName());

            String where = " ID = '" + discipline.getId() + "'";

            db.update(MainDb.TABELA, cv, where, null);
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public Boolean removeDiscipline(int id) {
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            String whereClause = Constants.DesciplineConstants.ID + " = ?";

            String[] whereArgs = {String.valueOf(id)};

            db.delete(MainDb.TABELA, whereClause, whereArgs);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Discipline loadDiscipline(int id) {
        Discipline discipline = new Discipline();
        try {
            SQLiteDatabase db = MainDb.getInstance().getReadableDatabase();
            String query = "SELECT * FROM " + MainDb.TABELA + " WHERE ID = '" + id + "'";
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                discipline.setId(cursor.getInt(0));
                discipline.setName(cursor.getString(1));
                discipline.setHour(cursor.getFloat(2));
                discipline.setDate(cursor.getString(3));
                discipline.setAll_hours(cursor.getFloat(4));
            }

            if (cursor != null) {
                cursor.close();
            }


            return discipline;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discipline;
    }



}
