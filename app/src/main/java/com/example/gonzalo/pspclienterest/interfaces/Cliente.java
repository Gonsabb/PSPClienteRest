package com.example.gonzalo.pspclienterest.interfaces;

import com.example.gonzalo.pspclienterest.pojo.Actividad;
import com.example.gonzalo.pspclienterest.pojo.Grupo;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Gonzalo on 15/02/2016.
 */
public interface Cliente {

    @GET("restful/api/actividad/gonzalo")
    Call<List<Actividad>> getActividades();

    @GET("restful/api/grupo")
    Call<List<Grupo>> getGrupos();

    @POST("restful/api/actividad")
    Call<String> addActivity(@Body Actividad actividad);


    @DELETE("restful/api/actividad/{id}")
    Call<String> delActivity(@Path("id") int id);
}
