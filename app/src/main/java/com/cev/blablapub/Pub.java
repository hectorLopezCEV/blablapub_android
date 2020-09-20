package com.cev.blablapub;

import java.util.ArrayList;

// creo que se puede eliminar esta clase, eperaremos un podo

public class Pub {
    public String texto;
    public int imagen;
    public Promocion promocion;

    public Pub(String texto, int imagenElemento, Promocion promocion) {
        this.texto = texto;
        this.imagen = imagenElemento;
        this.promocion = promocion;
    }


}
