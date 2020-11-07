package com.cev.blablapub.modelos;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaDeNegocios {
    public ArrayList<Negocio> negocios;

    public ListaDeNegocios(){
        this.negocios = new ArrayList<>();
    }

    // metodo gson para pasar esta clase a json
    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    // metodo gson para pasar un json a esta clase
    public ListaDeNegocios jsonToListaDeNegocios(String json){
        Gson gson = new Gson();
        ListaDeNegocios negocios = gson.fromJson(json,ListaDeNegocios.class);
        return negocios;
    }
}
