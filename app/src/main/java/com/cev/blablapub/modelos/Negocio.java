package com.cev.blablapub.modelos;

import com.cev.blablapub.Promocion;
import com.google.gson.Gson;

import java.util.ArrayList;

// creo que se puede eliminar esta clase, eperaremos un podo

public class Negocio {
    private String nombre;
    private int imagen;
    private Promocion promocion;
    private long id;
    private String tipo;
    private String ciudad;
    private String cca; // comunidad autonoma

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return nombre;
    }

    public void setTexto(String texto) {
        this.nombre = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCca() {
        return cca;
    }

    public void setCca(String cca) {
        this.cca = cca;
    }

   // constructor con todos los parametros full equip
   public Negocio(String nombre, int imagen, Promocion promocion, long id, String tipo, String ciudad, String cca) {
       this.nombre = nombre;
       this.imagen = imagen;
       this.promocion = promocion;
       this.id = id;
       this.tipo = tipo;
       this.ciudad = ciudad;
       this.cca = cca;
   }


    // constructores ///
    public Negocio(String nombre, int imagenElemento, Promocion promocion) {
        this.nombre = nombre;
        this.imagen = imagenElemento;
        this.promocion = promocion;
    }

    public Negocio(String nombre, int imagen, Promocion promocion, long id) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.promocion = promocion;
        this.id = id;
    }

    public Negocio() {
    }

    public  String toJSON()
    {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Negocio fromJSON(String json){
        Gson gson = new Gson();
        Negocio negocio = gson.fromJson(json, Negocio.class);
        return  negocio;
    }


}



