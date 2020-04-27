package com.cev.blablapub;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetAsincro extends AsyncTask<String, Void ,String> {
    // variables para crear un contexto
    Context context;

    GetAsincro(Context context){ this.context = context; }


    @Override
    protected String doInBackground(String... url) {
        // creamos el objeto http
        OkHttpClient cliente = new OkHttpClient();
        Request peticion = new Request.Builder().url(url[0]).build(); // cogemos nuestro parametro de entrada
        String body = "";

        try {
            Response respuesta = cliente.newCall(peticion).execute();
            /// si todo va bien guardo la respuesta en una variable
             body = respuesta.body().string();
        } catch (IOException e) {
            Log.d("log","esto es un herror de la tarea asincrona");
        }

        return body;
    }

    // metodo de respuesta

    @Override
    protected void onPostExecute(String respuesta) {
        // usamos el contexto creado para el TOAST
        Toast.makeText(context,"la respuesta es: "+respuesta,Toast.LENGTH_LONG).show();
    }
}
