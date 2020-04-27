package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class RecuperarCon extends AppCompatActivity {
    // conexion de las variables del html
    EditText editText;
    String emailUsuaio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_con);

        // conexion de la variables con html
        editText= findViewById(R.id.email);
        emailUsuaio= editText.getText().toString();


    }
    /*
    // funcion para conectarme a internet y guradar el email
    public void conexionGet(View view){
        String url = "http://127.0.0.1:8000/api/user/reset-password"; //http://www.mocky.io/v2/5ea1c2d9310000be4c1eedd8
        GetAsincro getAsincro = new GetAsincro(this); // creamos instancia de nuestra peticion
        getAsincro.execute(url); // ejecutamos la peticion url

        // cojemos el email del usuario para mostrarlo
        emailUsuaio= editText.getText().toString();
        Toast.makeText(this,"su email es:" + emailUsuaio,Toast.LENGTH_LONG).show();
    }*/

    // 11 metodo para el boton de todo lo de PeticionPost
    public void conexionPost(View view){
        String url = "http://127.0.0.1:8000/api/user/reset-password";
        PeticionPost peticionPost = new PeticionPost(this);
        peticionPost.execute(url,emailUsuaio);
        Log.d("email","valor del emailUsuario:"+ emailUsuaio);
    }

}
