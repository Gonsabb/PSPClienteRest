package com.example.gonzalo.pspclienterest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.gonzalo.pspclienterest.adaptador.AdaptadorActividades;
import com.example.gonzalo.pspclienterest.clientes.ClienteRest;
import com.example.gonzalo.pspclienterest.interfaces.Cliente;
import com.example.gonzalo.pspclienterest.pojo.Actividad;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Principal extends AppCompatActivity {

    private List<Actividad> listaActividades = new ArrayList<>();
    private AdaptadorActividades adpA;
    private ClienteRest cr;
    private ListView lv;
    private Context ctx;
    private Cliente api;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ctx = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdd();
            }
        });

        retrofit = new Retrofit.Builder().baseUrl("http://ieszv.x10.bz/").addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(Cliente.class);

        init();
    }

    public void init() {
        cr = new ClienteRest();
        lv = (ListView) findViewById(R.id.listView);
    }



    @Override
    protected void onResume() {
        super.onResume();
        cr = new ClienteRest();
        getActivities();
        for (Actividad act : listaActividades) {
            Log.v("estáfuera", act.toString());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            addActivity((Actividad) data.getExtras().getSerializable("act"));
        }else{
            //nada
        }
    }


    public void goAdd() {
        Intent i = new Intent(this, Add.class);
        startActivityForResult(i, 1);
    }

    public void getActivities(){

        Call<List<Actividad>> call = api.getActividades();
        listaActividades= new ArrayList<>();


        call.enqueue(new Callback<List<Actividad>>() {
            @Override
            public void onResponse(Response<List<Actividad>> response, Retrofit retrofit) {
                for (Actividad act : response.body()) {
                    listaActividades.add(act);
                }
                adpA = new AdaptadorActividades(ctx, listaActividades);
                lv.setAdapter(adpA);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        delActivity(listaActividades.get(position));
                    }
                });
                adpA.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Throwable t) {
                t.getLocalizedMessage();
            }
        });

    }
    public void addActivity(Actividad act){
        Call<String> call = api.addActivity(act);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
//                getActivities();
            }

            @Override
            public void onFailure(Throwable t) {
                t.getLocalizedMessage();
            }
        });
        listaActividades.clear();
        getActivities();
        adpA.notifyDataSetChanged();
    }
    public void delActivity(Actividad act){
        Call<String> call = api.delActivity(Integer.parseInt(String.valueOf(act.getId())));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
//                getActivities();
                Log.v("está", "acabado");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        listaActividades.clear();
        getActivities();
        adpA.notifyDataSetChanged();
    }

}
