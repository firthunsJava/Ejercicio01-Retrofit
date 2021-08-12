package com.cieep.ejercicio01_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.cieep.ejercicio01_retrofit.adapters.LibrosAdapter;
import com.cieep.ejercicio01_retrofit.conexiones_api.ApiConnections;
import com.cieep.ejercicio01_retrofit.conexiones_api.RetrofitObject;
import com.cieep.ejercicio01_retrofit.databinding.ActivityBooksInCategoryBinding;
import com.cieep.ejercicio01_retrofit.databinding.ActivityMainBinding;
import com.cieep.ejercicio01_retrofit.models.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BooksInCategoryActivity extends AppCompatActivity {

    private ActivityBooksInCategoryBinding binding;

    private ApiConnections conexiones;
    private Retrofit retrofitObject;

    private ArrayList<Book> books;
    private LibrosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBooksInCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        long idCategory = getIntent().getExtras().getLong("ID");

        retrofitObject = RetrofitObject.getRetrofitObject();
        conexiones = retrofitObject.create(ApiConnections.class);

        books = new ArrayList<>();
        adapter = new LibrosAdapter(books, R.layout.elemento_book, this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        binding.recyclerBook.setAdapter(adapter);
        binding.recyclerBook.setLayoutManager(lm);
        binding.recyclerBook.setHasFixedSize(true);

        /**
         * Completar con la llamada a la API para descargar los libros en la categoría enviada en el Bundle
         */

        Call<ArrayList<Book>> getBooks = conexiones.dogetBook(String.valueOf(idCategory));
        getBooks.enqueue(new Callback<ArrayList<Book>>() {
            @Override
            public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
                if(response.code() == 200){
                    books.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

            }
        });
    }
}