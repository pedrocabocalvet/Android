package com.example.caboc.examenjuanmisegundaevaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String FILE_NAME="ficheroExamen.txt";
    TextView txtMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMostrar = (TextView) findViewById(R.id.textViewMostrar);



    }


}
