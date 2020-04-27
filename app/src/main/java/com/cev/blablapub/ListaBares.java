package com.cev.blablapub;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaBares {

    public ArrayList<Bares> listaBar;

    public ListaBares() {
        this.listaBar = new ArrayList<>();
    }

    public String toJSON() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public ListaBares fromJSON(String json) {
        Gson gson = new Gson();
        ListaBares listaBares = gson.fromJson(json, ListaBares.class);
        return listaBares;
    }
}
