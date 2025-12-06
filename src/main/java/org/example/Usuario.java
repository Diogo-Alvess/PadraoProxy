package org.example;

public class Usuario {

    private String nome;
    private boolean administrador;

    public Usuario(String nome, boolean administrador) {
        this.nome = nome;
        this.administrador = administrador;
    }

    public boolean isAdministrador() {
        return administrador;
    }
}