package com.cieep.ejercicio01_retrofit.conexiones_api;

import com.cieep.ejercicio01_retrofit.models.Book;
import com.cieep.ejercicio01_retrofit.models.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConnections {


    /**
     * Completar con los dos métodos GET necesarios para descargar:
     * 1. Todas las categorias
     *      cadena: https://www.etnassoft.com/api/v1/get/?get_categories=all
     * 2. Obtener todos los libros de una categoría
     *      cadena: https://www.etnassoft.com/api/v1/get/?category_id=677
     */

//    @GET("/api/v1/get/?get_categories=all")
//    Call<Book> doGetBooks();

    @GET("/api/v1/get/?")
    Call<ArrayList<Category>> goGetCategories(@Query("get_categories") String type);


    @GET("/api/v1/get/?")
    Call<ArrayList<Book>> dogetBook( @Query("category_id") String idCat);
}
