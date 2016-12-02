package com.example.caboc.ficherosenandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button botonEscribir;
    Button botonMostrar;
    TextView txtMostrar;
    EditText editText;

    String FILE_NAME="fichero.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonEscribir = (Button) findViewById(R.id.botonEscribir);
        botonMostrar = (Button) findViewById(R.id.botonMostrar);
        txtMostrar = (TextView) findViewById(R.id.textViewMostrar);
        editText = (EditText) findViewById(R.id.editText);

        botonMostrar.setOnClickListener(this);
        botonEscribir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonEscribir:

                if(!editText.getText().toString().equals("")){

                    try {
                        FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
                        String mensajeGuardar = new String(editText.getText().toString());
                        DataOutputStream dos = new DataOutputStream(fos);
                        dos.writeBytes(mensajeGuardar);
                        editText.setText("");
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Tienes que escribir algo", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.botonMostrar:

                try {
                    FileInputStream fis = openFileInput(FILE_NAME);
                    DataInputStream dis = new DataInputStream(fis);

                    byte[] buff = new byte[1000];
                    dis.read(buff);

                    String textoMostrar = new String(buff);
                    txtMostrar.setText(textoMostrar);

                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
