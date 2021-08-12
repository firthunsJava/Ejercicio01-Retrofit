package com.cieep.ejercicio01_retrofit.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cieep.ejercicio01_retrofit.R;
import com.cieep.ejercicio01_retrofit.configuraciones.Parametros;
import com.cieep.ejercicio01_retrofit.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.LibroVH> {

    private List<Book> objects;
    private int resource;
    private Context context;

    public LibrosAdapter(List<Book> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public LibroVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookView = LayoutInflater.from(context).inflate(resource, null);
        bookView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new LibroVH(bookView);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroVH holder, int position) {
        /**
         * completar el método para rellenar los datos de cada libro
         *
         * La imagen se tiene que cargar desde el atributo cover con la libreria Picasso
         */
//        Book book = objects.get(position);
        holder.txtAutor.setText(objects.get(position).getAuthor());
        holder.txtTitulo.setText(objects.get(position).getTitle());


        Picasso.get()
                .load(objects.get(position).getCover())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgPortada);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public static class LibroVH extends RecyclerView.ViewHolder {
        ImageView imgPortada;
        TextView txtTitulo, txtAutor;

        public LibroVH(@NonNull View itemView) {
            super(itemView);
            imgPortada = itemView.findViewById(R.id.imgPortadaBookElement);
            txtTitulo = itemView.findViewById(R.id.txtTituloBookElement);
            txtAutor = itemView.findViewById(R.id.txtAutorBookElement);
        }
    }
}
