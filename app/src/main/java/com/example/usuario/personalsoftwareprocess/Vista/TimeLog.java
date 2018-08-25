package com.example.usuario.personalsoftwareprocess.Vista;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.usuario.personalsoftwareprocess.R;
import com.example.usuario.personalsoftwareprocess.datos.Datos;
import com.example.usuario.personalsoftwareprocess.datos.time_log_datos;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeLog extends AppCompatActivity {
ImageView imageViewvolver;

Button btnstart,btnstop, btnresgistrar;
EditText txthorayfecha, txtinterrupciones,txtfechafinal,Descripcion;
TextView txtresultado;


    int hora=0, minuto =0, segundo = 0;
    String sec, min, hor, curTime;
    int hora1,hora2;


    Spinner spinner;

    String Var = "";
Datos datos;
   //String array[] = {"1","2","3","4","5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);


btnstop = findViewById(R.id.btnstop);
btnstart = findViewById(R.id.idbtnstart);
btnresgistrar = findViewById(R.id.btnregistrar);



        spinner = findViewById(R.id.dispinnerlog);
        txthorayfecha = findViewById(R.id.idtxthorayfecha);
        txtinterrupciones = findViewById(R.id.idinterrupcines);
        txtfechafinal = findViewById(R.id.idfechafinal);
        txtresultado = findViewById(R.id.idresultado);
        Descripcion = findViewById(R.id.iddescripcion);




 ArrayAdapter<CharSequence> spinerr =   ArrayAdapter.createFromResource(this ,R.array.sprint,R.layout.spinner_configurado);
 spinner.setAdapter(spinerr);

 btnresgistrar.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         mtdRegistrar();
     }
 });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txthorayfecha.setText (new Date().toString());
                runOnUiThread(new Runnable() {
                    public void run() {
                        try{

                            updateTime();
                            curTime =hor+ hora + min + minuto + sec + segundo;
                            hora1 = Integer.valueOf(hora);


                        }catch (Exception e) {}

                    }

                });


//String FECHA = (date.format(Calendar.getInstance().getTime()));

            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         txtfechafinal.setText (new Date().toString());
         //Integer hora = (Calendar.DAY_OF_MONTH);
         runOnUiThread(new Runnable() {
             public void run() {
                 try{

                     updateTime();
                     curTime =hor+ hora + min + minuto + sec + segundo;

                     hora2 = Integer.valueOf(hora);

                 }catch (Exception e) {}

             }

         });

         int resultado =    hora1 - hora2;
         txtresultado.setText("total de fase en horas  " + resultado);

         //txtfechafinal.setText(hora.toString());
     }
 });

 spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
     @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         switch (position){

             case 0:
                 Var= parent.getItemAtPosition(position).toString();

                 break;
             case 1:

                 Var = parent.getItemAtPosition(position).toString();
                 break;
             case 2:
                 Var = parent.getItemAtPosition(position).toString();
                 break;
             case 3:

                 Var = parent.getItemAtPosition(position).toString();
                 break;

             case 4:
                 Var = parent.getItemAtPosition(position).toString();
                 break;

             case 5:
                 Var = parent.getItemAtPosition(position).toString();
                 break;


         }

     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }
 });


        imageViewvolver = findViewById(R.id.idvolver1);
    imageViewvolver.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });




    }




    //HILO PARA TOMAR HORA EXACTA







    //TOMAR HORA
    private void updateTime(){

        Calendar c = Calendar.getInstance();
        hora = c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE);
        segundo = c.get(Calendar.SECOND);
        setZeroClock();

    }

    private void setZeroClock(){
        if(hora >=0 & hora <=9){
            hor = "0";
        }else{
            hor = "";
        }

        if(minuto >=0 & minuto <=9){
            min = ":0";
        }else{
            min = ":";
        }

        if(segundo >=0 & segundo <=9){
            sec = ":0";

        }else{
            sec = ":";
        }
    }

    private void mtdRegistrar() {

        time_log_datos time_log_datos = new time_log_datos(

                Var,txthorayfecha.getText().toString(),Integer.parseInt(txtinterrupciones.getText().toString()),txtfechafinal.getText().toString(),txtresultado.getText().toString(),Descripcion.getText().toString()



        );

        datos = new Datos(getApplicationContext());
        datos.Open();
        datos.InsertarTimeLog(time_log_datos);
        datos.Close();
      new AlertDialog.Builder(TimeLog.this).setTitle("ECHO")
              .setIcon(R.drawable.iconito)
              .setCancelable(false)
              .setPositiveButton(getString(R.string.Realizado)
                      , new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              dialog.dismiss();
          }
      }).show();
    }



}
