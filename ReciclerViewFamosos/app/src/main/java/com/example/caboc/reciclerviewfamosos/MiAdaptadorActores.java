package com.example.caboc.reciclerviewfamosos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by caboc on 30/01/2017.
 */

public class MiAdaptadorActores extends RecyclerView.Adapter<MiAdaptadorActores.InternaViewHolder> {

    ArrayList<Actor> actores = new ArrayList<Actor>();

    public MiAdaptadorActores(ArrayList<Actor> actores){
        this.actores = actores;
    }



    public class InternaViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewimagen;
        TextView textViewnombre;
        TextView textViewpais;
        String descripcion;
        String cumple;
        String altura;
        String pareja;
        String hijos;
        String urlImagen;
        Bitmap bitmap;

        public InternaViewHolder(View itemView) {
            super(itemView);
            imageViewimagen = (ImageView) itemView.findViewById(R.id.imageView);
            textViewnombre = (TextView) itemView.findViewById(R.id.TextViewNombre);
            textViewpais = (TextView) itemView.findViewById(R.id.textViewPais);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent intent = new Intent(v.getContext(),Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nombre",textViewnombre.getText().toString());
                    bundle.putString("pais",textViewpais.getText().toString());
                    bundle.putString("descripcion",descripcion);
                    bundle.putString("cumple",cumple);
                    bundle.putString("altura",altura);
                    bundle.putString("pareja",pareja);
                    bundle.putString("hijos",hijos);
                    bundle.putString("urlimagen",urlImagen);

                    intent.putExtra("imagen",bitmap);
                    intent.putExtra("bundle",bundle);

                    v.getContext().startActivity(intent);

                    return false;
                }
            });
        }

    }

    @Override
    public InternaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new InternaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InternaViewHolder holder, int position) {

        holder.textViewnombre.setText(actores.get(position).getNombre());
        holder.textViewpais.setText(actores.get(position).getPais());
        holder.imageViewimagen.setImageBitmap(actores.get(position).getImagen());
        holder.bitmap = actores.get(position).getImagen();
        holder.descripcion = actores.get(position).getDescripcion();
        holder.cumple = actores.get(position).getfNacimiento();
        holder.altura = actores.get(position).getAltura();
        holder.pareja = actores.get(position).getPareja();
        holder.hijos = actores.get(position).getHijos();
        holder.urlImagen = actores.get(position).getUrlImagen();

    }

    @Override
    public int getItemCount() {
        return actores.size();
    }

}
