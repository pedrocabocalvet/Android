package com.example.caboc.reciclerviewfamosos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Hilo thread;
    Button boton;
    Object[] objetos;

    RecyclerView rv;
    RecyclerView.LayoutManager rvLM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objetos = new Object[3];

        boton = (Button) findViewById(R.id.button);

        rv = (RecyclerView) findViewById(R.id.elMeuRecyclerView);
        rvLM = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLM);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objetos[0] = getApplicationContext();
                objetos[1] = boton;
                objetos[2] = rv;
                thread = new Hilo();
                thread.execute(objetos);
            }
        });


    }
}
