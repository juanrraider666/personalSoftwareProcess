package com.example.usuario.personalsoftwareprocess.datos;

import android.content.ContentValues;

public class Defect_log_datos {




    private int IdProyecto;
    private String Type;
    private String PhaseInject;
    private String Phaseremoved;
    private String Time;
    private String Descripcion;
public  Defect_log_datos(){

    }
    public Defect_log_datos( int idProyecto, String type, String phaseInject, String phaseremoved, String time, String descripcion) {

        IdProyecto = idProyecto;
        Type = type;
        PhaseInject = phaseInject;
        Phaseremoved = phaseremoved;
        Time = time;
        Descripcion = descripcion;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPhaseInject() {
        return PhaseInject;
    }

    public void setPhaseInject(String phaseInject) {
        PhaseInject = phaseInject;
    }

    public String getPhaseremoved() {
        return Phaseremoved;
    }

    public void setPhaseremoved(String phaseremoved) {
        Phaseremoved = phaseremoved;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    public int getIdProyecto() {
        return IdProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        IdProyecto = idProyecto;
    }
    public ContentValues tovalues(){

        ContentValues contentValues = new ContentValues(7);
        contentValues.put(Constantes.COLUMN_IDPROYECTO,IdProyecto);
        contentValues.put(Constantes.COLUMN_TYPE,Type);
        contentValues.put(Constantes.COLUMN_PHASINJECT,PhaseInject);
        contentValues.put(Constantes.COLUMN_PHASEREMOVED,Phaseremoved);
        contentValues.put(Constantes.COLUMN_TIME,Time);
        contentValues.put(Constantes.DESCRIPCIONDEFECT,Descripcion);


        return  contentValues;

    }


}
