package com.example.estudiante.controltaller1;

import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
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
          ipDestino= InetAddress.getByName("192.168.43.57");
            miPuerto= 5001;
            puertoDestino= 6000;
            miBuzon= new DatagramSocket();
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
    public void enviar(final String data) {
       new Thread(new Runnable() {
            public void run() {
               // while (true) {
                    try {
                        byte[] bytes = data.getBytes();
                        DatagramPacket enviarP = new DatagramPacket(bytes, bytes.length, ipDestino, puertoDestino);
                        miBuzon.send(enviarP);
                        System.out.println("envia");
                    } catch (SocketException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
               // }
             }
        }).start();
    }
}
