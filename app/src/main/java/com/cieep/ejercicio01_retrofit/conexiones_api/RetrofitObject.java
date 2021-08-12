package com.cieep.ejercicio01_retrofit.conexiones_api;

import com.cieep.ejercicio01_retrofit.configuraciones.Parametros;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    public static Retrofit getRetrofitObject () {

        /**
         * Completar con el método que devuelve un objeto Retrofit
         *
         * OJO: Quitar el return NULL
         */

        return new Retrofit.Builder()
                .baseUrl(Parametros.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
