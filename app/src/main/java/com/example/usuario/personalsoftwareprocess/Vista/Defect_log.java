package com.example.usuario.personalsoftwareprocess.Vista;

import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.personalsoftwareprocess.R;
import com.example.usuario.personalsoftwareprocess.datos.Datos;
import com.example.usuario.personalsoftwareprocess.datos.Defect_log_datos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Defect_log extends AppCompatActivity {
ImageView imvolver;
TextView txtresibido; String Recibido;
ImageButton start, pause, restart;
Chronometer chronometer;
EditText exdatos, exdescripcion;
Spinner spi1,spn2, spn3;    String var1 = ""; String var2 = ""; String var3 = "";
Button btndatos, registrar;

Datos datos;

private boolean startclick;
private  boolean pauseclicked;
private long pausetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);

        imvolver = findViewById(R.id.idimvolerdefectlog);
        start = findViewById(R.id.btnstart);
        pause = findViewById(R.id.btnpause);
        restart = findViewById(R.id.btnreplay);
         registrar = findViewById(R.id.idbtnregistrar2);

//RECIBE ID DE PORYECTO
        txtresibido = findViewById(R.id.txtresibido);
        Recibido = getIntent().getStringExtra("Datos");
        txtresibido.setText(Recibido);



        exdatos = findViewById(R.id.iddatos);
        btndatos = findViewById(R.id.idbtndatos);
        exdescripcion = findViewById(R.id.iddescripcion2);
        spi1 = findViewById(R.id.idspinnermuchos);
        spn2 = findViewById(R.id.idspinnermedio);
        spn3 = findViewById(R.id.idspinnerpocos);


      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.sprintlog,R.layout.spinner_configurado);
       spi1.setAdapter(adapter);

       spi1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch (position){

                   case 0:
                       var1 = parent.getItemAtPosition(position).toString();

                   case 1:
                       var1 = parent.getItemAtPosition(position).toString();

                   case 2:
                       var1 = parent.getItemAtPosition(position).toString();
                   case 3:
                       var1 = parent.getItemAtPosition(position).toString();
                   case 4:
                       var1 = parent.getItemAtPosition(position).toString();
                   case 5:
                       var1 = parent.getItemAtPosition(position).toString();

                   case 6:
                       var1 = parent.getItemAtPosition(position).toString();
                   case 7:
                       var1 = parent.getItemAtPosition(position).toString();
                   case 8:
                       var1 = parent.getItemAtPosition(position).toString();
                   case 9:
                       var1 = parent.getItemAtPosition(position).toString();

                   case 10:
                       var1 = parent.getItemAtPosition(position).toString();


               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });



        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.sprint2,R.layout.spinner_configurado);
        spn2.setAdapter(adapter2);
        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        var2 = parent.getItemAtPosition(position).toString();

                    case 1:
                        var2 = parent.getItemAtPosition(position).toString();

                    case 2:
                        var2 = parent.getItemAtPosition(position).toString();
                    case 3:
                        var2 = parent.getItemAtPosition(position).toString();
                    case 4:
                        var2 = parent.getItemAtPosition(position).toString();
                    case 5:
                        var2 = parent.getItemAtPosition(position).toString();

                    case 6:
                        var2 = parent.getItemAtPosition(position).toString();
                    case 7:
                        var2 = parent.getItemAtPosition(position).toString();
                    case 8:
                        var2 = parent.getItemAtPosition(position).toString();
                    case 9:
                        var2 = parent.getItemAtPosition(position).toString();

                    case 10:
                        var2 = parent.getItemAtPosition(position).toString();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.sprint3,R.layout.spinner_configurado);
        spn3.setAdapter(adapter3);
        spn3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        var3 = parent.getItemAtPosition(position).toString();

                    case 1:
                        var3 = parent.getItemAtPosition(position).toString();

                    case 2:
                        var3 = parent.getItemAtPosition(position).toString();
                    case 3:
                        var3 = parent.getItemAtPosition(position).toString();
                    case 4:
                        var3 = parent.getItemAtPosition(position).toString();
                    case 5:
                        var3 = parent.getItemAtPosition(position).toString();

                    case 6:
                        var3 = parent.getItemAtPosition(position).toString();
                    case 7:
                        var3 = parent.getItemAtPosition(position).toString();
                    case 8:
                        var3 = parent.getItemAtPosition(position).toString();
                    case 9:
                        var3 = parent.getItemAtPosition(position).toString();

                    case 10:
                        var3 = parent.getItemAtPosition(position).toString();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Defect_log_datos defect_log = new Defect_log_datos(

                     Integer.parseInt(txtresibido.getText().toString()) ,var1,var2,var3,chronometer.getText().toString(),exdescripcion.getText().toString()

              );

              datos = new Datos(getApplicationContext());
              datos.Open();
              datos.InsertDefectLog(defect_log);
              datos.Close();
              Toast.makeText(getApplicationContext(),"Registro Echo",Toast.LENGTH_SHORT).show();

//INSERTAR ID DE PORYECCTO Y DATOS PARA DESPUES HACER CONSULTA






            }
        });



        btndatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exdatos.setText(new Date().toString());
            }
        });

        chronometer = findViewById(R.id.cronometro);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime()+pausetime);
                chronometer.start();
                pauseclicked = false;
                startclick = true;


            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(!pauseclicked){


pausetime  = chronometer.getBase()-SystemClock.elapsedRealtime();
chronometer.stop();
pauseclicked = true;

}else {
Toast.makeText(getApplicationContext(),"Por favor dar en el boton iniciar",Toast.LENGTH_SHORT).show();
}
}
});


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(startclick){

if(pauseclicked){
chronometer.setBase(SystemClock.elapsedRealtime());
pausetime=0;
startclick = false;




}else {
Toast.makeText(getApplicationContext(),"EL tiempo Tiene que estar pausado",Toast.LENGTH_SHORT).show();

}


}else {
Toast.makeText(getApplicationContext(),"Iniciar Cronometro",Toast.LENGTH_SHORT).show();
}
}
});


        imvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
