package com.cev.blablapub.modelos;

import com.cev.blablapub.Promocion;

import java.util.ArrayList;

// creo que se puede eliminar esta clase, eperaremos un podo

public class Negocio {
    private String texto;
    private int imagen;
    private Promocion promocion;
    private long id;
    private String tipo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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


    // constructores ///
    public Negocio(String texto, int imagenElemento, Promocion promocion) {
        this.texto = texto;
        this.imagen = imagenElemento;
        this.promocion = promocion;
    }

    public Negocio(String texto, int imagen, Promocion promocion, long id) {
        this.texto = texto;
        this.imagen = imagen;
        this.promocion = promocion;
        this.id = id;
    }

    public Negocio() {
    }


}


//////// preguntar a Hector si quiere aqui la logica???

