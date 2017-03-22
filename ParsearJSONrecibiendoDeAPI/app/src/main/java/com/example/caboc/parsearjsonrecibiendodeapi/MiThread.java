package com.example.caboc.parsearjsonrecibiendodeapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caboc on 21/01/2017.
 */

public class MiThread extends AsyncTask<Object, Object, Object> {

    private final String CADENAURL = "http://10.10.3.186/apiFloway/apiNueva.php";
    ArrayList<Contacto> contactos;

    public MiThread(){
        contactos = new ArrayList<Contacto>();
    }
    @Override
    protected Object doInBackground(Object[] params) {


        conectarAlaRed((Button)params[0]);
        publishProgress(params);



        return params[0];
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Toast.makeText(((Button)o).getContext(), "fin thread", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        Button b = (Button) values[0];
        RecyclerView rv = (RecyclerView) values[1];

        MiAdaptador adapter = new MiAdaptador(contactos);
        rv.setAdapter(adapter);
        b.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }


    public void conectarAlaRed(Button b){

        ConnectivityManager connMgr = (ConnectivityManager) b.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){

            String respuestaAPI = conseguirRespuestaApi(b);
           // parsearJSONManeraTradicional(respuestaAPI);
            parsearJSONConGeson(respuestaAPI);


            String nombresAMostrar = "";
            for(int x = 0; x < contactos.size(); x++){

                nombresAMostrar = nombresAMostrar  + contactos.get(x).getId() + " con nombre " +contactos.get(x).getNombre() +" "+ contactos.get(x).getApellidos();
            }

            Log.d("prueba",nombresAMostrar);




        }else{
            Log.d("prueba","no conecta");




        }

    }

    private void parsearJSONConGeson(String respuestaAPI) {

        Gson gson = new Gson();

        JsonParser parseador = new JsonParser();
        Log.d("prueba",respuestaAPI);
        JsonElement elementoRaiz = parseador.parse(respuestaAPI);
        JsonArray lista = elementoRaiz.getAsJsonArray();

        for(JsonElement elemento : lista){

            Contacto c = gson.fromJson(elemento,Contacto.class);
            contactos.add(c);

        }


    }

    private void parsearJSONManeraTradicional(String respuestaAPI) {

        try {
            JSONArray raiz = new JSONArray(respuestaAPI);

            for(int x = 0; x < raiz.length(); x++){
                JSONObject jsonObjeto = raiz.getJSONObject(x);
                String id = jsonObjeto.getString("id_usuario");
                String nombre = jsonObjeto.getString("nombre");
                String apellidos = jsonObjeto.getString("apellidos");
                String usuario = jsonObjeto.getString("usuario");
                String password =  jsonObjeto.getString("password");
                String nif = jsonObjeto.getString("nif");
                String direccion = jsonObjeto.getString("direccion");
                String poblacion = jsonObjeto.getString("poblacion");
                String cp =  jsonObjeto.getString("cp");
                String email = jsonObjeto.getString("email");
                String foto = jsonObjeto.getString("foto");
                String horario = jsonObjeto.getString("horario");
                String puntuacion = jsonObjeto.getString("puntuacion");

                Contacto contacto = new Contacto(Integer.parseInt(id),nombre,apellidos,usuario,password,nif,direccion,poblacion,cp,email,foto,horario,puntuacion);
                contactos.add(contacto);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String conseguirRespuestaApi(Button b){
        String respuestaApi = "";



        HttpURLConnection conn = null;
        int response;
        InputStream is = null;

        try {
            URL url = new URL(CADENAURL);

            conn = (HttpURLConnection)url.openConnection();
            Log.d("prueba","llega");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            response = conn.getResponseCode();
            is = conn.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            while((respuestaApi = br.readLine()) != null){
                builder.append(respuestaApi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

}
