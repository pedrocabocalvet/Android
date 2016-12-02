package com.example.caboc.reciclerviewcreadopormi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdaptadorRecyclerViewJugador extends RecyclerView.Adapter<AdaptadorRecyclerViewJugador.ClientViewHolder> {

    ArrayList<Jugador> jugadores;

    public AdaptadorRecyclerViewJugador(ArrayList<Jugador> j) {

        jugadores = j;
    }





    public static class ClientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nombre;
        TextView equipo;
        String descripcion;
        int imagenEquipo;
        ImageView imagenFoto;
        int imagenFotoId;
        View view;
        ImageView x;

        public ClientViewHolder(View v)  {

            super(v);

            nombre = (TextView) v.findViewById(R.id.texto1Item);
            equipo = (TextView) v.findViewById(R.id.texto2Item);
            imagenFoto = (ImageView) v.findViewById(R.id.imagenItem);
            x = (ImageView) v.findViewById(R.id.imageViewX);
            v.setOnClickListener(this);
            view = v;

        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(),PaginaJugador.class);
            Bundle b = new Bundle();
            b.putString("nombreJugador",nombre.getText().toString());
            b.putString("nombreEquipo",equipo.getText().toString());
            b.putString("descripcionJugador",descripcion);
            b.putInt("imagenEquipo",imagenEquipo);
            b.putInt("imagenJugador",imagenFotoId);

            i.putExtras(b);
            v.getContext().startActivity(i);

        }
    }

    @Override
    public AdaptadorRecyclerViewJugador.ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);


        return new ClientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorRecyclerViewJugador.ClientViewHolder holder, int position) {
        final int posicion = position;
        final AdaptadorRecyclerViewJugador adaptador = this;
        holder.nombre.setText(jugadores.get(position).getNombre());
        holder.equipo.setText(jugadores.get(position).getEquipo());
        holder.imagenFoto.setImageResource(jugadores.get(position).getImagen());
        holder.imagenFotoId = jugadores.get(position).getImagen();
        holder.descripcion = jugadores.get(position).getDescripcion();
        holder.imagenEquipo = jugadores.get(position).getImagenEquipo();



        holder.x.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                jugadores.remove(posicion);
                notifyItemRemoved(posicion);
                notifyItemRangeChanged(posicion, jugadores.size());

                return false;
            }

        });

    }

    @Override
    public int getItemCount() {
        return this.jugadores.size();
    }




}