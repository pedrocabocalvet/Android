package com.example.caboc.parsearjsonrecibiendodeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton;
    MiThread miThread;
    Object[] objetos;

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);
        rv = (RecyclerView) findViewById(R.id.elMeuRecyclerView);
        RecyclerView.LayoutManager rvLM = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLM);

        objetos = new Object[2];




    }

    public void Consultar(View view) {

        objetos[0] =boton;
        objetos[1] = rv;

        miThread = new MiThread();
        miThread.execute(objetos);
    }
}
