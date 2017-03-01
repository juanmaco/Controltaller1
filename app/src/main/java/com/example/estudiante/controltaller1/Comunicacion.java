package com.example.estudiante.controltaller1;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Observable;

/**
 * Created by estudiante on 01/03/17.
 */

public class Comunicacion extends Observable implements Runnable {
    private InetAddress ipDestino;
    private int puertoDestino;
    private int miPuerto;
    private DatagramSocket miBuzon;
    public String mensaje;

    public Comunicacion(){
        try {
          ipDestino= InetAddress.getByName("192.168.108.16");
            miPuerto= 5001;
            puertoDestino= 5001;
            miBuzon= new DatagramSocket(miPuerto);
        }catch (SocketException e){
         e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void run() {
        while (true){
            try{
                setChanged();
                notifyObservers();
                clearChanged();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
