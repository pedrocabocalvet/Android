package com.example.caboc.asynctask;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button iniciar;
    Button parar;

    TextView porcentaje;
    MiThread miThread;
    Object[] objetos;
    RingProgressBar mRingProgressBar;
    borrar nombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = new borrar("jose");
        Log.d("prueba",nombre.imprimirNombre());

        miThread = null;

        iniciar = (Button) findViewById(R.id.b_iniciar);
        parar = (Button) findViewById(R.id.b_cancelar);
        iniciar.setOnClickListener(this);
        parar.setOnClickListener(this);

        porcentaje = (TextView) findViewById(R.id.percentatge);


        mRingProgressBar = (RingProgressBar) findViewById(R.id.progress_bar);

        // Set the progress bar's progress
        mRingProgressBar.setProgress(0);
        mRingProgressBar.setOnProgressListener(new RingProgressBar.OnProgressListener()
        {

            @Override
            public void progressToComplete()
            {
                // Progress reaches the maximum callback default Max value is 100
                Toast.makeText(MainActivity.this, "complete", Toast.LENGTH_SHORT).show();
            }
        });

        if(savedInstanceState != null){
            mRingProgressBar.setProgress(savedInstanceState.getInt("porcentajeBarra"));
            porcentaje.setText(savedInstanceState.getInt("porcentajeBarra")+" %");

            if(getLastCustomNonConfigurationInstance() != null) {



                miThread = (MiThread) getLastCustomNonConfigurationInstance();
                miThread.setPorcentaje(porcentaje);
                miThread.setmRingProgressBarAtributo(mRingProgressBar);



            }

        }



        objetos = new Object[2];
        objetos[0] = mRingProgressBar;
        objetos[1] = porcentaje;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_iniciar:


                miThread = new MiThread();
                miThread.execute(objetos);

                break;
            case R.id.b_cancelar:
                miThread.cancel(true);
                break;
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {



       return miThread;
    }

//    @Override
//    public Object onRetainNonConfigurationInstance() {
//        final MyDataObject data = collectMyLoadedData();
//        return data;
//    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("porcentajeBarra",mRingProgressBar.getProgress());

    }
}
