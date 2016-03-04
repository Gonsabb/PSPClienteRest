package com.example.gonzalo.pspclienterest.clientes;

import android.os.AsyncTask;
import android.util.Log;

import com.example.gonzalo.pspclienterest.interfaces.Cliente;
import com.example.gonzalo.pspclienterest.pojo.Actividad;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Gonzalo on 15/02/2016.
 */
public class ClienteRest {
//    final static int GETLIST = 1, ADDACTIVITY = 2, DELACTIVITY = 3;
//    Actividad activityToAdd;
//    JSONObject jsonActivityToAdd;
//
//
//    private List<Actividad> listaActividades = new ArrayList<>();
//
//    public List<Actividad> getListaActividades() {
//
//        Tarea t = new Tarea(GETLIST);
//        t.execute();
//
//        for (Actividad act : listaActividades) {
//            Log.v("está", act.toString());
//        }
//
//        return listaActividades;
//    }
//
//    public void addActivity(Actividad act) {
//        activityToAdd = act;
//
//        Tarea t = new Tarea(ADDACTIVITY);
//        t.execute();
//    }
//
//    public void delActivity(Actividad act) {
//        activityToAdd = act;
//        jsonActivityToAdd = new JSONObject();
//
//        try {
//            jsonActivityToAdd.put("id", act.getId() + "");
//            jsonActivityToAdd.put("idprofesor", act.getIdprofesor() + "");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Tarea t = new Tarea(DELACTIVITY);
//        t.execute();
//    }

//    private void callGetActivities(Cliente api) {
//        Call<List<Actividad>> call = api.getActividades();
//
//        call.enqueue(new Callback<List<Actividad>>() {
//            @Override
//            public void onResponse(Response<List<Actividad>> response, Retrofit retrofit) {
//                for (Actividad act : response.body()) {
//                    listaActividades.add(act);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                t.getLocalizedMessage();
//            }
//        });
//    }
//
//    private void callAddActivity(Cliente api) {
//        Call<String> call = api.addActivity(activityToAdd);
//
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Response<String> response, Retrofit retrofit) {
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                t.getLocalizedMessage();
//            }
//        });
//
//    }

//
//    class Tarea extends AsyncTask<String, Long, String> {
//        private int action = 0;
//
//        Tarea(int action) {
//            this.action = action;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ieszv.x10.bz/").addConverterFactory(GsonConverterFactory.create()).build();
//            Cliente api = retrofit.create(Cliente.class);
//
//
//            switch (action) {
//                case ClienteRest.GETLIST:
//                    Log.v("está", "getting list...");
//                    callGetActivities(api);
//                    break;
//                case ClienteRest.ADDACTIVITY:
//                    Log.v("está", "adding activity...");
//                    callAddActivity(api);
//                    break;
//                case ClienteRest.DELACTIVITY:
//                    Log.v("está", "removing activity");
//
//                    break;
//            }
//
//
//            return "";
//        }
//
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//        }
//    }
}
