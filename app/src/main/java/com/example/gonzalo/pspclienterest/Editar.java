package com.example.gonzalo.pspclienterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gonzalo.pspclienterest.interfaces.Cliente;
import com.example.gonzalo.pspclienterest.pojo.Actividad;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Gonzalo on 06/03/2016.
 */
public class Editar extends AppCompatActivity {

    private EditText etDescr, etFechai, etFechaf, etLugari, etLugarf, etIdProfe;
    private Actividad act, actExt;
    private Retrofit retrofit;
    private Cliente api;
    private android.widget.TextView tvFechaIni;
    private android.widget.TextView tvFechaFin;
    private EditText etIdProfesor;
    private android.widget.Button btAceptar;
    private android.widget.Button btBorrar;
    private android.widget.Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);
        this.btCancelar = (Button) findViewById(R.id.btCancelar);
        this.btBorrar = (Button) findViewById(R.id.btBorrar);
        this.btAceptar = (Button) findViewById(R.id.btAceptar);
        this.etIdProfesor = (EditText) findViewById(R.id.etIdProfesor);
        this.etLugarf = (EditText) findViewById(R.id.etLugarf);
        this.etLugari = (EditText) findViewById(R.id.etLugari);
        this.etFechaf = (EditText) findViewById(R.id.etFechaf);
        this.tvFechaFin = (TextView) findViewById(R.id.tvFechaFin);
        this.etFechai = (EditText) findViewById(R.id.etFechai);
        this.tvFechaIni = (TextView) findViewById(R.id.tvFechaIni);
        this.etDescr = (EditText) findViewById(R.id.etDescr);
        retrofit = new Retrofit.Builder().baseUrl("http://ieszv.x10.bz/").addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(Cliente.class);
        actExt = (Actividad) getIntent().getExtras().getSerializable("act");

        init();
    }

    public void init(){
        etDescr.setText(actExt.getDescripcion());
        etFechaf.setText(actExt.getFechaf());
        etFechai.setText(actExt.getFechai());
        etLugarf.setText(actExt.getLugarf());
        etLugari.setText(actExt.getLugari());
        etIdProfesor.setText(actExt.getIdprofesor());
    }

    public void addActividad(View v){

        act = new Actividad();
        act.setId(actExt.getId());
        act.setTipo("extraescolar");
        act.setAlumno("gonzalo");
        act.setLugari(etLugari.getText().toString());
        act.setLugarf(etLugarf.getText().toString());
        act.setFechaf(etFechaf.getText().toString());
        act.setFechai(etFechai.getText().toString());
        act.setIdprofesor(etIdProfesor.getText().toString());
        act.setDescripcion(etDescr.getText().toString());

        Intent i = new Intent(Editar.this, Editar.class );
        i.putExtra("act", act);
        setResult(Activity.RESULT_OK, i);
        Editar.this.finish();
        finish();
    }
    public void delActividad(View v){
        Intent i = new Intent(Editar.this, Editar.class );
        i.putExtra("act", (Actividad) getIntent().getExtras().getSerializable("act"));
        i.putExtra("delete", "yes");
        setResult(Activity.RESULT_OK, i);
        Editar.this.finish();
        finish();
    }

    public void cancel(View v){
        finish();
    }
}
