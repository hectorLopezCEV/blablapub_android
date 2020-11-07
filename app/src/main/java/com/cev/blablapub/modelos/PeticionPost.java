package com.cev.blablapub.modelos;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PeticionPost extends AsyncTask <String, Void, String> {

    // 8 necesito un contexto para el Toast
    Context context;
    PeticionPost (Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... parametros) {
        String url = parametros[0];
        String email = parametros[1];
        String resultado= "";

        // 1 creamos el body y le paso el parametro
        RequestBody body = new FormBody.Builder().add("email",email).build();
        // 2 creamos la instancia del http y de la peticion
        OkHttpClient okHttpClient = new OkHttpClient();
        Request peticion = new Request.Builder().url(url).post(body).build();
        // 3 hacemos la llamada a http, y me obliga a meterlo en un try catch
        try { // 4 lo envuelvo en una respuesta
           Response response= okHttpClient.newCall(peticion).execute();
           // 5 cojo lo que me ha llegado y lo meto en la variable que quiero devolver en return
            resultado = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultado;
    }

    // 6 para poder mostrar todo esto en la interfaz de usuario necesito este metodo

    @Override  /// 7 cogo el resultado y lo muestro con un Toast
    protected void onPostExecute(String resultado) {
    // 9 mostramos el resultado con el Toast
        Toast.makeText(context,"Revisa tu email"+resultado,Toast.LENGTH_LONG).show();
        Log.d("email","el resultado de peticion es: "+resultado);
    }
    // 10 lo llamo todo desde RecuperarCon con un metodo en el boton

}
