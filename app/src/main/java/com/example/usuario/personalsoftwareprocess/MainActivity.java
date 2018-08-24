package com.example.usuario.personalsoftwareprocess;


import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.personalsoftwareprocess.Vista.Defect_log;
import com.example.usuario.personalsoftwareprocess.Vista.TimeLog;
import com.example.usuario.personalsoftwareprocess.Vista.tabbed;
import com.example.usuario.personalsoftwareprocess.datos.Conexion;
import com.example.usuario.personalsoftwareprocess.datos.Datos;
import com.example.usuario.personalsoftwareprocess.datos.Proyectos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


Dialog epicdialog;
TextView txt1,txt2,txt3;
ImageView imagenclose;  // PARA LE MENSAJE DE DIALOGO


ImageView imagen;
Datos datos;


    EditText txtidproyecto;
  ArrayList<com.example.usuario.personalsoftwareprocess.datos.Proyectos> Proyectos = new ArrayList<>();
ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           imagen = findViewById(R.id.idecho);
            txtidproyecto = findViewById(R.id.idproyecto);

       //PARA MENSAJE DE DIALOGO
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        epicdialog = new Dialog(this);






   lista = findViewById(R.id.lista);
   mtdlistar();


//AL DAR CLICK SOBRE LA LISTA
lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
mtdverdialogo();
    }
});




    }


    //METODO PARA TRAER EL CONTENIDO DEL DIALOGO
    private void mtdverdialogo() {
   epicdialog.setContentView(R.layout.mensaje);
   imagenclose  = epicdialog.findViewById(R.id.idimagenclose);
        txt1 =epicdialog.findViewById(R.id.txt1);
        txt2 =epicdialog.findViewById(R.id.txt2);
        txt3 =epicdialog.findViewById(R.id.txt3);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TimeLog.class);
                startActivity(intent);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Defect_log.class);
                startActivity(intent);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,tabbed.class);
                startActivity(intent);
            }
        });




        imagenclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicdialog.dismiss();
            }
        });
epicdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
epicdialog.show();

    }


    //PARA LLENAR LISTA
    int ver ; // VARIABLE DEFINIDA PARA HACER VALIDACION

    public void onClick(View view) {
        String Nombre = txtidproyecto.getText().toString();
        if(mtdvalidar(Nombre)== false){
            return;
        }else{



            Animation  animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotacion);
            Proyectos proyectos = new Proyectos(

                    txtidproyecto.getText().toString()


            );
            datos = new Datos(getApplicationContext());
            datos.Open();
            datos.InsertarProyecto(proyectos);
            datos.Close();




            imagen.startAnimation(animation);
            ver= 1;
            mtdlistar();

        }

    }

    private void mtdlistar() {


Conexion conexion = new Conexion(getApplicationContext());
if(conexion!=null){
    SQLiteDatabase DB = conexion.getReadableDatabase();
    Cursor cursor  = DB.rawQuery("select  * from Proyecto",null);
    if(ver == 1){
        cursor  = DB.rawQuery("select Nombre from Proyecto  order by Id desc limit 1",null);
        if(cursor.moveToLast()){

            Proyectos.add(new Proyectos(cursor.getString(0)));

        }
    }else{
        if(cursor.moveToFirst()){
            do {
                Proyectos.add(new Proyectos(cursor.getString(1)));
            }while (cursor.moveToNext());
        }
    }
    }



String[] arreglo = new String[Proyectos.size()];

for (int i = 0; i<arreglo.length; i++){
    arreglo[i] = Proyectos.get(i).getProyecto();

}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arreglo);

lista.setAdapter(adapter);




    }

//VALIDACION

    private boolean mtdvalidar(String nombre) {


        if(nombre.isEmpty()){
            Toast.makeText(getApplicationContext(),"Por favor llene los datos ",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }



    }
}
