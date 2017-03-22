package com.example.caboc.parsearjsonrecibiendodeapi;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by caboc on 21/01/2017.
 */

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiAdaptadorViewHolder>{
    ArrayList<Contacto> contactos;

    public MiAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;

    }

    public class MiAdaptadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView id;
        TextView nombre;
        TextView apellidos;
        TextView usuario;
        TextView horario;
        TextView poblacion;
        ImageButton boton;

        public MiAdaptadorViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.textViewId);
            nombre = (TextView) itemView.findViewById(R.id.textViewNombre);
            apellidos = (TextView) itemView.findViewById(R.id.textViewApellidos);
            usuario = (TextView) itemView.findViewById(R.id.textViewUsuario);
            horario = (TextView) itemView.findViewById(R.id.textViewHorario);
            poblacion = (TextView) itemView.findViewById(R.id.textViewPoblacion);
            boton = (ImageButton) itemView.findViewById(R.id.imageButton);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Hola que ase", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public MiAdaptador.MiAdaptadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemreciclerview,parent,false);
        return new MiAdaptadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiAdaptador.MiAdaptadorViewHolder holder, int position) {

        holder.nombre.setText(contactos.get(position).getNombre());
        holder.apellidos.setText(contactos.get(position).getApellidos());
        holder.id.setText(""+contactos.get(position).getId());
        holder.usuario.setText(contactos.get(position).getUsuario());
        holder.horario.setText(contactos.get(position).getHorario());
        holder.poblacion.setText(contactos.get(position).getPoblacion());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
}
