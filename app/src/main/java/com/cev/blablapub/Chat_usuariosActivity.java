package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class Chat_usuariosActivity extends AppCompatActivity  {

    // declaraciones
    ImageView fecla;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_usuarios);
        Log.i("bla","////////Chat usuatios");

        // instancias
        fecla = findViewById(R.id.imv_chat_flecha);
        listView = findViewById(R.id.lisv_chat);

    }




    public void volverVistaDetalle(View v){
        finish();
    }
}
