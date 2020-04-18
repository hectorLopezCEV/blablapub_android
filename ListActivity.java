package com.example.blablapub;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

    public class ListActivity extends AppCompatActivity {

        ListView lista;
        ArrayList<Bares> listaBar;

        SharedPreferences sharedPreferences;
        ListaBares listaBares = new ListaBares();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Recuperamos el valor pasado a la actividad
            Intent intent = getIntent();
            String valorJsonPasado = intent.getStringExtra("valorJson");
            //Transformamos de Json a objeto
            listaBares = listaBares.fromJSON(valorJsonPasado);
            listaBar = listaBares.listaBar;

            //Mostramos la lista
            lista = findViewById(R.id.listaDinamica);

            ListAdapter adapter = new ListAdapter(this, R.layout.activity_detalle_bar, listaBares);
            lista.setAdapter(adapter);



        }

        public void  cerrar(View view)
        {
            this.finish();
        }
    }

}
