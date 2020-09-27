package com.cev.blablapub.modelos;

import android.media.Image;

import com.google.gson.Gson;


public class Bares {

    private String nombreBar;
    private String informacionBar;
    private Image imagenBar;

    public Bares() {
    }


    public Bares (String nombreBar, String informacionBar, Image imagenBar){
        this.imagenBar=imagenBar;
        this.nombreBar=nombreBar;
        this.informacionBar=informacionBar;
    }

    public String getNombreBar() {
        return nombreBar;
    }

    public void setNombreBar(String nombreBar) {
        this.nombreBar = nombreBar;
    }

    public String getInformacionBar() {
        return informacionBar;
    }

    public void setInformacionBar(String informacionBar) {
        this.informacionBar = informacionBar;
    }

    public Image getImagenBar() {
        return imagenBar;
    }

    public void setImagenBar(Image imagenBar) {
        this.imagenBar = imagenBar;
    }

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
