package com.cev.blablapub.modelos;

import com.cev.blablapub.Promocion;

import java.util.ArrayList;

// creo que se puede eliminar esta clase, eperaremos un podo

public class Pub {
    private String texto;
    private int imagen;
    private Promocion promocion;
    private long id;

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


    // constructores ///
    public Pub(String texto, int imagenElemento, Promocion promocion) {
        this.texto = texto;
        this.imagen = imagenElemento;
        this.promocion = promocion;
    }

    public Pub(String texto, int imagen, Promocion promocion, long id) {
        this.texto = texto;
        this.imagen = imagen;
        this.promocion = promocion;
        this.id = id;
    }

    public Pub() {
    }


}


//////// preguntar a Hector si quiere aqui la logica???

