package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RecuperarCon extends AppCompatActivity {
    // conexion de las variables del html
    EditText editText;
    String emailUsuaio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_con);
        Log.i("bla","//////RECUPERARCON_oncreate");

        // conexion de la variables con html
        editText= findViewById(R.id.txv_email_recu_con);
        emailUsuaio= editText.getText().toString();


    }


    // 11 metodo para el boton de todo lo de PeticionPost
    public void conexionPost(View view){
        String url = "http://192.168.43.139:8000/api/user/reset-password";

        PeticionPost peticionPost = new PeticionPost(this);
        peticionPost.execute(url,emailUsuaio);

    }

}
