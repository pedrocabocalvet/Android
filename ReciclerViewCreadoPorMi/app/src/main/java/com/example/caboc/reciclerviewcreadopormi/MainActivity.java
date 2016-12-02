package com.example.caboc.reciclerviewcreadopormi;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView titol;
    Animation animacio;
    FloatingActionButton floatActionButton;
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    AdaptadorRecyclerViewJugador arVJ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titol = (TextView) findViewById(R.id.textoTitulo);
        jugadores = new ArrayList<Jugador>();
        titol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacio = AnimationUtils.loadAnimation(v.getContext(),R.anim.rotacio);
                v.setAnimation(animacio);
            }
        });
        RecyclerView rv;
        RecyclerView.LayoutManager rvLM;

        for(int x = 0; x<3; x++){
            jugadores.add(new Jugador(R.drawable.garay,"Garay","Valencia",2,"Ezequiel Marcelo Garay (Rosario , Santa Fe, Argentina, 10 de octubre de 1986) es un futbolista argentino con pasaporte español que juega de defensa central en el Valencia de la Primera División de España.",R.drawable.valencia));
            jugadores.add(new Jugador(R.drawable.cristianoronaldo,"Ronaldo","Madrid",1,"Cristiano Ronaldo dos Santos Aveiro (Funchal, Madeira, Portugal, 5 de febrero de 1985), más conocido como Cristiano Ronaldo (AFI: kɾiʃˈtiɐnu ʁuˈnaɫdu), es un futbolista portugués. Juega como delantero en el Real Madrid Club de Fútbol de la Primera División de España y en la selección de Portugal, de la que es capitán.",R.drawable.madrid));
            jugadores.add(new Jugador(R.drawable.alcacer,"Alcacer","Barsa",2,"Francisco Alcácer García (Torrente, Valencia, España, 30 de agosto de 1993) conocido deportivamente como Paco Alcácer, es un futbolista español que juega como delantero en el Fútbol Club Barcelona de la Liga Santander de España. También es internacional absoluto con la Selección de fútbol de España.",R.drawable.barcelona));
            jugadores.add(new Jugador(R.drawable.joaquin,"Joaquin","Betis",1,"Joaquín Sánchez Rodríguez (El Puerto de Santa María, Cádiz, 21 de julio de 1981) deportivamente conocido como Joaquín, es un futbolista español que milita en el Real Betis Balompié de la Liga BBVA. Ha sido 51 veces internacional con la selección española, con la que ha disputado dos Mundiales y una Eurocopa.",R.drawable.betis));
            jugadores.add(new Jugador(R.drawable.aduriz,"Aduriz","Bilbao",2,"Aritz Aduriz Zubeldia (San Sebastián, España, 11 de febrero de 1981) es un futbolista español. Juega de delantero centro y su actual equipo es el Athletic Club de la Primera División de España.",R.drawable.bilbao));
            jugadores.add(new Jugador(R.drawable.pepe,"Pepe","Madrid",1,"Képler Laverán Lima Ferreira (Maceió, Brasil, 26 de febrero de 1983), más conocido como Pepe, es un futbolista portugués nacido en Brasil. Juega actualmente en el Real Madrid de la Primera División de España.1 Se desempeña habitualmente como defensa central aunque en algunas ocasiones ha sido alineado como mediocentro.",R.drawable.madrid));
        }

        floatActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatActionButton.setOnClickListener(this);


        rv = (RecyclerView) findViewById(R.id.elMeuRecyclerView);
        rvLM = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLM);

        arVJ = new AdaptadorRecyclerViewJugador(jugadores);

        rv.setAdapter(arVJ);


    }


/*
    @Override
    public boolean onContextItemSelected(MenuItem item) {



        switch (item.getItemId()){
            case R.id.borrarItem:

                Toast.makeText(MainActivity.this, "BorrarItem", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
*/
    @Override
    public void onClick(View v) {

        if(v.getId()==floatActionButton.getId()){
            jugadores.add(new Jugador(R.drawable.usuariooculto,"Nuevo","Valencia",2,"esta es una descripcion corta de un usuario nuevo creado al darle al action float button",R.drawable.valencia));
            arVJ.notifyItemInserted(jugadores.size());

        }
    }


}
