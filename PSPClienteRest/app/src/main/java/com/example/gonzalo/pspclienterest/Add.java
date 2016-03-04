package com.example.gonzalo.pspclienterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gonzalo.pspclienterest.clientes.ClienteRest;
import com.example.gonzalo.pspclienterest.interfaces.Cliente;
import com.example.gonzalo.pspclienterest.pojo.Actividad;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Gonzalo on 3/3/2016.
 */
public class Add extends AppCompatActivity {

    private EditText etDescr, etFechai, etFechaf, etLugari, etLugarf, etIdProfesor;
    private Actividad act;
    private ClienteRest cr;
    private Retrofit retrofit;
    private Cliente api;
    private android.widget.Button btAceptar;
    private android.widget.Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        this.btCancelar = (Button) findViewById(R.id.btCancelar);
        this.btAceptar = (Button) findViewById(R.id.btAceptar);
        this.etIdProfesor = (EditText) findViewById(R.id.etIdProfesor);
        this.etLugarf = (EditText) findViewById(R.id.etLugarf);
        this.etLugari = (EditText) findViewById(R.id.etLugari);
        this.etFechaf = (EditText) findViewById(R.id.etFechaf);
        this.etFechai = (EditText) findViewById(R.id.etFechai);
        this.etDescr = (EditText) findViewById(R.id.etDescr);
        setTitle("Añadir Actividad");
        retrofit = new Retrofit.Builder().baseUrl("http://ieszv.x10.bz/").addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(Cliente.class);
        cr = new ClienteRest();
    }


    public void addActividad(View v) {

        act = new Actividad();
        act.setTipo("extraescolar");
        act.setAlumno("gonzalo");
        act.setLugari(etLugari.getText().toString());
        act.setLugarf(etLugarf.getText().toString());
        act.setFechaf(etFechaf.getText().toString());
        act.setFechai(etFechai.getText().toString());
        act.setIdprofesor(etIdProfesor.getText().toString());
        act.setDescripcion(etDescr.getText().toString());

        Intent i = new Intent(Add.this, Principal.class );
        i.putExtra("act", act);
        setResult(Activity.RESULT_OK, i);
        Add.this.finish();
        finish();
    }

    public void cancel(View v){
        finish();
    }
}
