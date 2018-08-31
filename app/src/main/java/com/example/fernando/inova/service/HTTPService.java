package com.example.fernando.inova.service;
import android.os.AsyncTask;

import com.example.fernando.inova.model.Cliente;
import com.example.fernando.inova.model.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;


import java.net.URL;
import java.util.List;
import java.util.Scanner;
/**
 * Created by fernando on 03/08/18.
 */
public class HTTPService extends AsyncTask<Void, Void, Cliente> {

    private URL url;
    ConectaWS conectaWS = new ConectaWS();

    @Override
    protected Cliente doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            url = new URL("https://aw-inova.cfapps.io/cliente/2");
            String uri = url.toString();
            HttpURLConnection connection = conectaWS.getConnection(uri, "GET");
            connection.connect();
            Scanner scanner =   new Scanner(url.openStream());
            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cliente cliente = new Gson().fromJson(resposta.toString(),Cliente.class);
        return cliente;
    }
}