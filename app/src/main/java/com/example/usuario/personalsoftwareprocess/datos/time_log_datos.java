package com.example.usuario.personalsoftwareprocess.datos;

import android.content.ContentValues;

public class time_log_datos {

private int Id;
private String Phase;
private String FechaInicio;
private int Interrupciones;
    private  String FechaFinal;
private String Resultado;

private String Descripcion;

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        FechaFinal = fechaFinal;
    }

    public  time_log_datos(){

    }

    public time_log_datos(String phase, String fechaInicio,int interrupciones ,String fechaFinal, String resultado, String descripcion) {

        Phase = phase;
        FechaInicio = fechaInicio;
        Interrupciones = interrupciones;
        FechaFinal = fechaFinal;
        Resultado = resultado;

        Descripcion = descripcion;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPhase() {
        return Phase;
    }

    public void setPhase(String phase) {
        Phase = phase;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getInterrupciones() {
        return Interrupciones;
    }

    public void setInterrupciones(int interrupciones) {
        Interrupciones = interrupciones;
    }

public  ContentValues tovlues(){
    ContentValues contentValues = new ContentValues(7);

    contentValues.put(Constantes.COLUNM_PHASE,Phase);
    contentValues.put(Constantes.COLUNM_FECHA_INICIO,FechaInicio);
    contentValues.put(Constantes.INTERRUPCIONES,Interrupciones);
    contentValues.put(Constantes.COLUMN_FECHA_FINAL,FechaFinal);
    contentValues.put(Constantes.RESULTADO,Resultado);
    contentValues.put(Constantes.DESCRIPCION,Descripcion);



    return  contentValues;
}

}
