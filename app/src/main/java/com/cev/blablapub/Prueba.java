package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Prueba extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
    }

    // para navegar a la vista detalle y usar de prueba para una lista
    public void  prueba(View view){
        Intent intent = new Intent(this,VistaDetalleBar.class);
        startActivity(intent);


    }
}
