
package com.mycompany.parcialfinal.proceso;

public class Copia {
    private int identificador;
    private String estado;
    private Libro libro;
    private Lector lector;
    private Prestamo prestamo;

    public Copia(int identificador, Libro libro) {
        this.identificador = identificador;
        this.estado = "No prestado";
        this.libro = libro;
    }
    
    public void devolver(){
        if ("prestado".equals(estado)) {
            this.lector.removerCopia(this);
            estado = "NoPrestado";
            this.prestamo = null;
            setLector(null);
        }
    }
    public void prestar(){
         if ("NoPrestado".equals(estado)) {
            estado = "prestado";
            this.prestamo = new Prestamo(new Date());
            setLector(lector);
            lector.agregarCopia(this);
        }
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }
    public int getIdentificador() {
        return identificador;
    }

    public String getEstado() {
        return estado;
    }
 
    public Libro getLibro() {
        return libro;
    }
 
    public Lector getLector() {
        return lector;
    }
    public Prestamo getPrestamo() {
        return prestamo;
    }
   
  }
