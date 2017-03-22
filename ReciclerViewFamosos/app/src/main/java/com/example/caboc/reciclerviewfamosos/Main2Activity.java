package com.example.caboc.reciclerviewfamosos;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Bitmap imagen;
    ImageView imageView;
    TextView textViewNombre;
    TextView textViewPais;
    TextView textViewDescripcion;
    TextView textViewCumple;
    TextView textViewAltura;
    TextView textViewPareja;
    TextView textViewHijos;
    TextView textViewUrlImagen;

    String nombre;
    String pais;
    String descripcion;
    String cumple;
    String altura;
    String pareja;
    String hijos;
    String urlimagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundleImagen = getIntent().getExtras();
        imagen = bundleImagen.getParcelable("imagen");

        Bundle bundle = getIntent().getBundleExtra("bundle");
        nombre = bundle.getString("nombre");
        pais = bundle.getString("pais");
        descripcion = bundle.getString("descripcion");
        cumple = bundle.getString("cumple");
        altura = bundle.getString("altura");
        pareja = bundle.getString("pareja");
        hijos = bundle.getString("hijos");
        urlimagen = bundle.getString("urlimagen");


        imageView = (ImageView) findViewById(R.id.imageViewImagenMain2);
        textViewNombre = (TextView) findViewById(R.id.textViewNombreMain2);
        /* textViewPais = (TextView) findViewById(R.id.textViewPais);
         textViewDescripcion= (TextView) findViewById(R.id.textViewDescripcionMain2);
         textViewCumple = (TextView) findViewById(R.id.textViewCumple);
         textViewAltura = (TextView) findViewById(R.id.textViewAltura);
         textViewPareja = (TextView) findViewById(R.id.textViewPareja);
         textViewHijos = (TextView) findViewById(R.id.textViewhijos);
         textViewUrlImagen = (TextView) findViewById(R.id.textViewUrlImagen);*/


        textViewNombre.setText(nombre);
        imageView.setImageBitmap(imagen);
       /*   textViewPais.setText(pais);
      textViewDescripcion.setText(descripcion);
        textViewCumple.setText(cumple);
        textViewAltura.setText(altura);
        textViewPareja.setText(pareja);
        textViewHijos.setText(hijos);
        textViewUrlImagen.setText(urlimagen);*/


    }
}
