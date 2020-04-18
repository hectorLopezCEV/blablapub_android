package com.example.blablapub;

import android.media.Image;

import com.google.gson.Gson;


public class Bares {

    public String nombreBar;
    public String informacionBar;
    public Image imagenBar;

    public  String toJSON()
    {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Bares fromJSON(String json){
        Gson gson = new Gson();
        Bares bares = gson.fromJson(json, Bares.class);
        return  bares;
    }
}
