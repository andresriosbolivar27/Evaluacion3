package com.example.evaluacion3;

public class Mascota {
    private String nombre;
    private String contador;
    private int foto;

    public Mascota(String nombre, String contador, int foto) {
        this.nombre = nombre;
        this.contador = contador;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
