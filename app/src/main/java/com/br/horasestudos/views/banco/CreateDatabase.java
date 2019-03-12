package com.br.horasestudos.views.banco;

import android.database.sqlite.SQLiteDatabase;

public class CreateDatabase {

    public Boolean create(){
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            String column = "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME VARCHAR,HOUR FLOAT,DATE VARCHAR,ALL_HOUR FLOAT)";
            String query = "CREATE TABLE IF NOT EXISTS " + MainDb.TABELA + column;
            db.execSQL(query);
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
