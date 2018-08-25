package com.example.usuario.personalsoftwareprocess.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datos {


    private  Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Datos(Context context){
this.context = context;
sqLiteOpenHelper = new Conexion(context);
sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();


    }

public  void Open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
}

    public  void Close(){
sqLiteOpenHelper.close();
    }
public  void InsertarProyecto(Proyectos pojo){
ContentValues contentValues = pojo.tovalues();
sqLiteDatabase.insert(Constantes.Table_proyecto,null,contentValues);



}
    public  void InsertarTimeLog(time_log_datos pojo){
        ContentValues contentValues = pojo.tovlues();
        sqLiteDatabase.insert(Constantes.Table_Timelog,null,contentValues);



    }


    public  void InsertDefectLog(Defect_log_datos pojo){
        ContentValues contentValues = pojo.tovalues();
        sqLiteDatabase.insert(Constantes.TableDefectLog,null,contentValues);
        }


    public void ActualizarTiempo(String  Id,ContentValues contentValues){

        String[] tomarArgumentos =  new String[]{String.valueOf(Id)};

        sqLiteDatabase.update(Constantes.Table_proyecto, contentValues,Constantes.COLUMN_TIME_RPYECTO_ACTUALIZAR,tomarArgumentos);


    }



}
