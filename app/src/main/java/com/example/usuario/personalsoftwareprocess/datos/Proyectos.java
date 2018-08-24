package com.example.usuario.personalsoftwareprocess.datos;


import com.example.usuario.personalsoftwareprocess.datos.Constantes;
import android.content.ContentValues;

public class Proyectos {

 private String proyecto;
private int Id;
 public Proyectos(){

    }



    public Proyectos(String proyecto) {
        this.proyecto = proyecto;
  ;

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
ContentValues contentValues = new ContentValues(2);
contentValues.put(Constantes.COLUMN_PROYECTO,proyecto);



return  contentValues;
    }

}
