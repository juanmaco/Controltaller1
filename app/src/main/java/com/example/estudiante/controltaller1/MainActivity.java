package com.example.estudiante.controltaller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button izquierda;
    Button derecha;
    Comunicacion com;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        izquierda= (Button) findViewById(R.id.izquierda);
        derecha= (Button) findViewById(R.id.derecha);
        com= new Comunicacion();
        Thread hilo = new Thread(com);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== izquierda.getId()){
            String mensaje= "left";
            com.enviar(mensaje);
        }
        if(view.getId()==derecha.getId()){
            String mensaje= "right";
            com.enviar(mensaje);
        }
    }

}
