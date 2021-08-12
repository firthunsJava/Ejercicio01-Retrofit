package com.cieep.ejercicio01_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.cieep.ejercicio01_retrofit.adapters.CategoriasAdapter;
import com.cieep.ejercicio01_retrofit.conexiones_api.ApiConnections;
import com.cieep.ejercicio01_retrofit.conexiones_api.RetrofitObject;
import com.cieep.ejercicio01_retrofit.databinding.ActivityMainBinding;
import com.cieep.ejercicio01_retrofit.models.Book;
import com.cieep.ejercicio01_retrofit.models.Category;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    // Primer ejercicio del examen
    private ActivityMainBinding binding;

    private ApiConnections conexiones;
    private Retrofit retrofitObject;

    private int resource = R.layout.elemento_category;

    private ArrayList<Category> categories;
    private CategoriasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        retrofitObject = RetrofitObject.getRetrofitObject();
        conexiones = retrofitObject.create(ApiConnections.class);

        categories = new ArrayList<>();

        adapter = new CategoriasAdapter(categories, resource, this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        binding.recyclerCategories.setAdapter(adapter);
        binding.recyclerCategories.setLayoutManager(lm);
        binding.recyclerCategories.setHasFixedSize(true);


        /**
         * completar con las llamadas para obtener todas las categorías de libros
         */

    Call<ArrayList<Category>> getCategories = conexiones.goGetCategories("all");

    getCategories.enqueue(new Callback<ArrayList<Category>>() {
        @Override
        public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
            if (response.code() ==200 ){
                categories.addAll(response.body());
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Call<ArrayList<Category>> call, Throwable t) {

        }
    });



    }
}