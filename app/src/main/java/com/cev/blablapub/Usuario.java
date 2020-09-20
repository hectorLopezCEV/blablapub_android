package com.cev.blablapub;

import java.util.ArrayList;

public class Usuario {

    int imagen;
    String nick;

    // constructor
    public Usuario(int imagen, String nick){
       this.imagen = imagen;
       this.nick = nick;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
