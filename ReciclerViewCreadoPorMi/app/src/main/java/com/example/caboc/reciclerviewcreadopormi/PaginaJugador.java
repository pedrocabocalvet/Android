package com.example.caboc.reciclerviewcreadopormi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PaginaJugador extends AppCompatActivity {

    ImageView fotoJugador;
    ImageView fotoEquipo;
    TextView nombreJugador;
    TextView nombreEquipo;
    TextView descripcionJugador;
    RelativeLayout relativeLayout;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_jugador);

        fotoJugador = (ImageView) findViewById(R.id.imageJugadorSubActivity);
        fotoEquipo = (ImageView) findViewById(R.id.imageEquipoSubActivity);
        nombreJugador = (TextView) findViewById(R.id.txtNombreJugadorSubActivity);
        descripcionJugador = (TextView) findViewById(R.id.txtDescJugadorSubActivity);
        nombreEquipo = (TextView) findViewById(R.id.txtEquipoSubActivity);
        relativeLayout = (RelativeLayout) findViewById(R.id.framesubactivityprincipal);

        intent = getIntent();
        bundle = intent.getExtras();

        nombreJugador.setText(bundle.getString("nombreJugador"));
        nombreEquipo.setText(bundle.getString("nombreEquipo"));
        fotoEquipo.setImageResource(bundle.getInt("imagenEquipo"));
        fotoJugador.setImageResource(bundle.getInt("imagenJugador"));
        descripcionJugador.setText(bundle.getString("descripcionJugador"));

    }
}
