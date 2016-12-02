package com.example.caboc.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by caboc on 01/12/2016.
 */
public class MiThread extends AsyncTask<Object, Object, TextView> {

    int contador=0;

    @Override

    protected void onPreExecute() {  }


    @Override
    protected TextView doInBackground(Object... params) {

        while (contador != 100 && !isCancelled()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            contador++;
            publishProgress(params);
        }
        return (TextView) params[1];
    }

    @Override

    protected void onProgressUpdate(Object... progress) {


        RingProgressBar barra = (RingProgressBar) progress[0];
        TextView porcentaje = (TextView) progress[1];
        barra.setProgress(contador);
        porcentaje.setText(""+contador+" %");


    }

    @Override
    protected void onPostExecute(TextView t) {

        Toast.makeText(t.getContext(), "La descarga ha finalizado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCancelled(TextView t) {

        Toast.makeText(t.getContext(), "Has Cancelado la operacion", Toast.LENGTH_SHORT).show();
    }



}
