package com.example.usuario.personalsoftwareprocess.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context) {
        super(context, Constantes.BD,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(Constantes.CREATE_TABLE_PROYECTO);
      db.execSQL(Constantes.CREATE_TABLE_TIMELOG);
 db.execSQL(Constantes.CREATE_TABLE_DEFECT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(Constantes.SQL_DELETE);
        onCreate(db);
       db.execSQL(Constantes.SQL_DELETE_TIMELOG);
    onCreate(db);

     db.execSQL(Constantes.SQL_DELETE_DEFECT);
        onCreate(db);

    }
}
