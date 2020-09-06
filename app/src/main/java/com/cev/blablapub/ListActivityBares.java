package com.cev.blablapub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class ListActivityBares extends AppCompatActivity {

    ListView lista;
    ArrayList<Bares> listaBar;

    SharedPreferences sharedPreferences;
    ListaBares listaBares = new ListaBares();

    EditText filtroText;
    private ArrayAdapter filterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("bla","///LisActivityBares_ONCREATE");

        //Recuperamos el valor pasado a la actividad
        Intent intent = getIntent();
        String valorJsonPasado = intent.getStringExtra("valorJson");
        //Transformamos de Json a objeto
        listaBares = listaBares.fromJSON(valorJsonPasado);
        listaBar = listaBares.listaBar;

        filtroText = findViewById(R.id.filterText);

        filterAdapter = new ArrayAdapter(this, R.layout.activity_lista, listaBares.listaBar);

        filtroText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                (ListActivityBares.this).filterAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // FIXME: Hace falta solucionar esta accion que pide la lista de la vista donde no existe el ID en el layout ni el adapter correcto
        //Mostramos la lista
        lista = findViewById(R.id.listaBares);
        ListAdapter adapter = new ListAdapterBares(this, R.layout.activity_detalle_bar, listaBares.listaBar);
        lista.setAdapter(adapter);


    }

    public void cerrar(View view) {
        this.finish();
    }
}
