package com.example.usuario.personalsoftwareprocess.ClasesInterfaz;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.personalsoftwareprocess.R;
import com.example.usuario.personalsoftwareprocess.datos.Constantes;
import com.example.usuario.personalsoftwareprocess.datos.Datos;

public class tabtimeinphase extends Fragment {

Datos datos;
EditText txttiempo , ttxnombreproyecto;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_in_phase, container, false);
        final Button btnregistrar = rootView.findViewById(R.id.btnregistrartime);

        txttiempo = rootView.findViewById(R.id.txttiempoproyect);
        ttxnombreproyecto = rootView.findViewById(R.id.txtnombreproyect);









        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tiempo = txttiempo.getText().toString();
                if(txttiempo.length()>5){
                    txttiempo.setError("Por favor que el número sea mayor a 0");
                }else if(tiempo.isEmpty()){
                    txttiempo.setError("Proyecto No encontrado!");
                }
                ActualizarTiempoProyect();
            }

        });

        return rootView;
        //dasdasdads
    }

    public void ActualizarTiempoProyect() {
       try {
           datos = new Datos(getContext());
           String NombreProyect = ttxnombreproyecto.getText().toString();
           ContentValues contentValues = new ContentValues(2);
           contentValues.put(Constantes.COLUMN_TIME_RPYECTO,txttiempo.getText().toString());
           datos.Open();
           datos.ActualizarTiempo(NombreProyect,contentValues);
           new AlertDialog.Builder(getContext()).setTitle(getString(R.string.Realizado)).setPositiveButton(getString(R.string.Realizado), new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   dialog.dismiss();
               }
           }).show();

           datos.Close();
       }catch (Exception ex){
           Toast.makeText(getContext(),"NO EXISTE ", Toast.LENGTH_SHORT).show();
       }

    }

}
