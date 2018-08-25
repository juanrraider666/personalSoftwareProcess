package com.example.usuario.personalsoftwareprocess.datos;


import com.example.usuario.personalsoftwareprocess.datos.Constantes;
import android.content.ContentValues;

public class Proyectos {

 private String proyecto;
 private int Tiempo;
private int Id;

 public Proyectos(){

    }



    public Proyectos(String proyecto,int tiempo) {
        this.proyecto = proyecto;
        Tiempo = tiempo;

    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int tiempo) {
        Tiempo = tiempo;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }



    public  ContentValues tovalues (){
ContentValues contentValues = new ContentValues(3);
contentValues.put(Constantes.COLUMN_PROYECTO,proyecto);
contentValues.put(Constantes.COLUMN_TIME_RPYECTO,Tiempo);


return  contentValues;
    }

}
