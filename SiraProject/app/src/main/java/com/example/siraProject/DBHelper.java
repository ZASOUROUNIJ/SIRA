package com.example.siraProject;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String SIRA_DB = "contatos.db";
    private static final int SIRA_VERSAO = 1;
    private Context context;
    private SQLiteDatabase dbinstancia = null;

    DBHelper (Context context) {
        super(context, SIRA_DB, null, SIRA_VERSAO);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS carteira (id INTEGER PRIMARY KEY AUTOINCREMENT,total DOUBLE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS tipo (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR(255), porcentagem DOUBLE, total DOUBLE)");
        db.execSQL("CREATE TABLE IF NOT EXISTS gasto (id INTEGER PRIMARY KEY AUTOINCREMENT, valor DOUBLE, data DATETIME, tipo INTEGER,FOREIGN KEY (tipo)REFERENCES tipo(id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS carteira");
        db.execSQL("DROP TABLE IF EXISTS tipo");
        db.execSQL("DROP TABLE IF EXISTS gasto");
        onCreate(db);
    }

    public void abrirDB() throws SQLException{
        if(this.dbinstancia == null){
            this.dbinstancia = this.getWritableDatabase();
        }
    }
    public void fecharDB() throws SQLException{
        if(this.dbinstancia != null){
            if(this.dbinstancia.isOpen()){
                this.dbinstancia.close();
            }
        }
    }

}