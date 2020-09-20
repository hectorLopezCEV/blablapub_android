package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class Chat_usuariosActivity extends AppCompatActivity  {

    // declaraciones
    ImageView fecla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_usuarios);
        Log.i("bla","////////Chat usuatios");


        fecla = findViewById(R.id.imv_chat_flecha);


    }




    public void volverVistaDetalle(View v){
        finish();
    }
}
