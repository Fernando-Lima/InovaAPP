package com.example.fernando.inova.service;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fernando on 03/08/18.
 */

public class ConectaWS {

    public HttpURLConnection getConnection (String url, String type){
        URL uri = null;
        HttpURLConnection connection = null;
        try {
            uri = new URL(url);
            connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod(type);
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("conexao", "Erro ao conectart");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("conexao", "Erro ao conectart");
        }
        return connection;
    }
}
