package com.cev.blablapub.modelos;

import java.util.ArrayList;

public class Usuario {

    private int imagen;
    private String nick;
    private int id;
    private String email;
    private int edad;
    private boolean conectado;

    // constructor
    public Usuario() {
    }

    // constructor
    public Usuario(int imagen, String nick){
        this.imagen = imagen;
        this.nick = nick;
    }

    // constructor
    public Usuario(int imagen, String nick, int id, String email, int edad, boolean conectado) {
        this.imagen = imagen;
        this.nick = nick;
        this.id = id;
        this.email = email;
        this.edad = edad;
        this.conectado = conectado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
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

////// preguntar a Hector si quiere aqui la logica o en el servidor del backend
