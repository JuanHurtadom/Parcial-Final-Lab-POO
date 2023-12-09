
package com.mycompany.parcialfinal.proceso;

import java.util.ArrayList;


public class Lector {
    private int numSocio;
    private String nombre;
    private String apellidos;
    private String direccion;
    private ArrayList<Copia> copias;
    private Multa multa;

    public Lector(int numSocio, String nombre, String apellidos, String direccion) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.copias = new ArrayList<>();
    }
          
    public void addCopia(Copia copia) {
        if (this.copias.size() < 3) {
            this.copias.add(copia);
        } else {
            System.out.println("No se pueden añadir más copias. El lector ya tiene 3 copias.");
        }
    }

    public void removerCopia(Copia copia) {
        copias.remove(copia);
    }
    public void comprobarMultasPendientes(){
    }
    public String getNombreCompleto(){
        return nombre + " " + apellidos;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public Multa getMulta() {
        return multa;
    }
}
