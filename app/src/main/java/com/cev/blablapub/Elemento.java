package com.cev.blablapub;

import java.util.ArrayList;

public class Elemento {
    public String texto;
    public int imagen;
    public Promocion promocion;

    public Elemento(String texto, int imagenElemento, Promocion promocion) {
        this.texto = texto;
        this.imagen = imagenElemento;
        this.promocion = promocion;
    }
}
