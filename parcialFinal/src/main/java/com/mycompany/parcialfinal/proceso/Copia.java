
package com.mycompany.parcialfinal.proceso;

public class Copia {
    private String identificador;
    private String estado;
    private Libro libro;
    private Lector lector;

    public Copia(String identificador, String estado) {
        this.identificador = identificador;
        this.estado = estado;
    }
    
    public void devolver(){
        
    }
    public void prestar(){
        
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    
    
  }
