package com.cev.blablapub.modelos;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PetitionsPost extends AsyncTask<String,Void,String> {
    Context context;

    public PetitionsPost(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... parametros) {
        String url = parametros[0];
        String name = parametros[1];
        String email = parametros[2];
        String password = parametros[3];
        String edad = parametros[4];
        String sexo = parametros[5];
        String resultado ="";
        RequestBody body = new FormBody.Builder()
                .add("name",name)
                .add("email",email)
                .add("password",password)
                .add("edad",edad)
                .add("sexo",sexo)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            resultado = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    protected void onPostExecute(String resultado) {
        Toast.makeText(context,resultado,Toast.LENGTH_LONG).show();
    }
}
