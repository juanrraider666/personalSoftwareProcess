package com.example.usuario.personalsoftwareprocess.datos;

public class Constantes {
//PORYECTO,DEFECTLOG,TIMELOG
    public static final String BD = "bdpsoftwareV6.bd";
    public  static  final String Table_proyecto="Proyecto";
    public static final String COLUMN_PROYECTO = "Nombre";
    public static  final  String COLUMN_TIME_RPYECTO = "TiempoProyecto";
    public static  final  String COLUMN_TIME_RPYECTO_ACTUALIZAR = "TiempoProyecto=?";

    public static final String CREATE_TABLE_PROYECTO = " CREATE TABLE " +Table_proyecto+"( IdProyecto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"+
            COLUMN_PROYECTO+" TEXT,  "+COLUMN_TIME_RPYECTO+ " INTEGER "+");";
    public static final String SQL_DELETE = " DROP TABLE "+Table_proyecto;




//TABLE TIMELOG

    public  static  final  String COLUNM_PHASE = "Phase";
    public  static  final  String COLUNM_FECHA_INICIO = "Fecha";
    public  static  final  String INTERRUPCIONES = "Interrupciones";
    public  static  final  String COLUMN_FECHA_FINAL = "Final";
    public  static  final  String RESULTADO = "Resultado";
    public  static  final  String DESCRIPCION = "Descripcion";
    public  static  final String Table_Timelog = "TimeLog";



    public static final String CREATE_TABLE_TIMELOG = " CREATE TABLE "+Table_Timelog+" ( Idlog INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,  " +
            COLUNM_PHASE+ " TEXT, "+
            COLUNM_FECHA_INICIO+ " TEXT, "  +
            INTERRUPCIONES+ " INTEGER, "  +
            COLUMN_FECHA_FINAL+ " TEXT, "  +
            RESULTADO+ " TEXT, "  +
            DESCRIPCION+ " TEXT "+");";

    public static final String SQL_DELETE_TIMELOG = " DROP TABLE "+Table_Timelog;



    //TABLE DEFECTLOG

    public  static  final  String COLUMN_TYPE = "Type";
    public  static  final  String COLUMN_IDPROYECTO = "Idproyecto";
    public  static  final  String COLUMN_PHASINJECT = "Phase";
    public  static  final  String COLUMN_PHASEREMOVED = "PhaseRemoved";
    public  static  final  String COLUMN_TIME = "Time";
    public  static  final  String DESCRIPCIONDEFECT = "Descripcion";





    public  static  final  String TableDefectLog = "DefectLog";

    public static final String CREATE_TABLE_DEFECT= " CREATE TABLE " + TableDefectLog + "( IdDefectLog INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "
            +COLUMN_TYPE+" TEXT,"
            +COLUMN_PHASINJECT+" TEXT, "
            + COLUMN_PHASEREMOVED+" TEXT,"
            + COLUMN_TIME+" TEXT,"
            +DESCRIPCIONDEFECT + " TEXT,"+
            COLUMN_IDPROYECTO+ " INTEGER "+");" ;

    public static final String SQL_DELETE_DEFECT = " DROP TABLE " + TableDefectLog;

}
