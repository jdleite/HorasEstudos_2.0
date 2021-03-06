package com.br.horasestudos.views.banco;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class CreateDatabase {

    //cria o banco
    public Boolean create(){
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            String column = "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR,HOUR FLOAT,DATE VARCHAR,ALL_HOURS LONG)";
            String query = "CREATE TABLE IF NOT EXISTS " + MainDb.TABELA + column;
            db.execSQL(query);
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //deleta o banco
    public Boolean deleteDatabase(){
        try {
            SQLiteDatabase db = MainDb.getInstance().getWritableDatabase();
            String query = "DROP TABLE IF EXISTS " + MainDb.TABELA;
            db.execSQL(query);


            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }





}
