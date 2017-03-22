package com.example.caboc.reciclerviewfamosos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by caboc on 29/01/2017.
 */

public class Hilo  extends AsyncTask <Object, Object, Object>{

    private final String DIRECCIONCONEXION = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    ArrayList<Actor> actores;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object... params) {

        String jasonString;


        if(comprobarConexion(params[0])){
            Log.d("prueba","tengo conexion");
            jasonString = conseguirJason();
            this.actores = parsearJason(jasonString);
        }else{
            Log.d("prueba","no tengo conexion");
        }

        publishProgress(params);


        return params;
    }

    private ArrayList<Actor> parsearJason(String jasonString) {

        ArrayList<Actor> actoresArray = new ArrayList<Actor>();
        JSONObject jason;
        JSONArray actores;

        try {
             jason = new JSONObject(jasonString);
            actores = jason.getJSONArray("actors");

            for(int x = 0; x < actores.length(); x++){
                JSONObject jsonObj = actores.getJSONObject(x);
                String nombre = jsonObj.getString("name");
                String description = jsonObj.getString("description");
                String fnacimiento = jsonObj.getString("dob");
                String pais = jsonObj.getString("country");
                String altura = jsonObj.getString("height");
                String pareja= jsonObj.getString("spouse");
                String hijos = jsonObj.getString("children");
                String urlImagen = jsonObj.getString("image");

                Bitmap imagen = conseguirImagenBitmap(urlImagen);

                Actor a = new Actor(nombre,description,fnacimiento,pais,altura,pareja,hijos,urlImagen, imagen);
                actoresArray.add(a);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return actoresArray;

    }

    private Bitmap conseguirImagenBitmap(String urlImagen) {

        URL imageUrl = null;
        HttpURLConnection conn = null;
        Bitmap imagen = null;

        try {

            imageUrl = new URL(urlImagen);
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // el factor de escala a minimizar la imagen, siempre es potencia de 2

            imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return imagen;

    }

    private String conseguirJason() {

        URL url = null;
        HttpURLConnection conn;
        int response;
        InputStream is = null;

        try {
            url = new URL(DIRECCIONCONEXION);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET"); 			// SuperGlobal de como vas a enviar los datos
            conn.setDoInput(true);			// esto es true cuando vamos a recibir parámetros

            conn.connect();
            response = conn.getResponseCode();
            is = conn.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String respuesta = transformarInputStremString(is);
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return respuesta;

    }

    private String transformarInputStremString(InputStream is) {

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String linea = "";

        try {
            while((linea = reader.readLine()) != null){
                stringBuilder.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private boolean comprobarConexion(Object param) {

        boolean respuesta;

        Context contexto = (Context) param;

        ConnectivityManager connMgr = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            // podem fer la connexió a alguna URL
            respuesta = true;

        } else {
            // mostrem un error indicant que no dispossem de connexió a la Xarxa
            respuesta = false;
        }

        return respuesta;

    }

    @Override
    protected void onProgressUpdate(Object... values) {
        RecyclerView rv = (RecyclerView) values[2];
        Button boton = (Button) values[1];
        Log.d("prueba","ya estoy aki");
        boton.setVisibility(View.INVISIBLE);
        rv.setVisibility(View.VISIBLE);

        MiAdaptadorActores adaptador = new MiAdaptadorActores(this.actores);
        rv.setAdapter(adaptador);

        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(Object o) {

        super.onPostExecute(o);
    }



    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
