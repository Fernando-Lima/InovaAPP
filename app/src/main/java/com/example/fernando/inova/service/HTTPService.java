package com.example.fernando.inova.service;

import android.os.AsyncTask;

import com.example.fernando.inova.model.Usuario;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by fernando on 03/08/18.
 */

public class HTTPService extends AsyncTask<Void, Void, Usuario> {
    private URL url;
    private HttpURLConnection connection;

    @Override
    protected Usuario doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            url = new URL("https://aw-inova.cfapps.io/funcionario/2");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
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
        Usuario usuario = new Gson().fromJson(resposta.toString(),Usuario.class);
        return usuario;
    }
}