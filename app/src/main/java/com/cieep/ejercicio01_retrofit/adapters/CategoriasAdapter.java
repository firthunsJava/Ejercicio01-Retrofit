package com.cieep.ejercicio01_retrofit.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cieep.ejercicio01_retrofit.BooksInCategoryActivity;
import com.cieep.ejercicio01_retrofit.MainActivity;
import com.cieep.ejercicio01_retrofit.R;
import com.cieep.ejercicio01_retrofit.models.Category;

import java.util.List;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.CategoryVH> {

    private List<Category> objects;
    private int resource;
    private Context context;

    public CategoriasAdapter(List<Category> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryView = LayoutInflater.from(context).inflate(resource, null);
        categoryView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new CategoryVH(categoryView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        /**
         * Completar el método teniendo en cuenta que el click el la card debe
         * iniciar la actividad BooksInCategory y le tiene que pasar por el
         * bundle el id de la categoría
         *
         */
        Category category = objects.get(position);
        holder.txtNombre.setText(category.getName());
        holder.txtNickName.setText(category.getNicename());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Bundle con el nombre
                Bundle bundle = new Bundle();
                bundle.putLong("ID",  objects.get(position).getCategoryID());
//                // 2. Intent con el context como origen (por que estoy en un Adapter)
                Intent intent = new Intent(context, BooksInCategoryActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public static class CategoryVH extends RecyclerView.ViewHolder {
        TextView txtNombre, txtNickName;

        public CategoryVH(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNameCategoryElement);
            txtNickName = itemView.findViewById(R.id.txtNickNameCategoryElement);

        }
    }
}
