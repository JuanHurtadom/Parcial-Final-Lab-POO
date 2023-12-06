
package com.mycompany.parcialfinal.proceso;

import java.util.List;


public class Lector {
    private int numSocio;
    private String nombre;
    private String apellidos;
    private String direccion;
    private List<Copia> copias;
    private Multa multa;

    public Lector(int numSocio, String nombre, String apellidos, String direccion) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    
    
    
    
    public void addCopia(Copia copia) {
        if (copias.size() < 3) {
            copias.add(copia);
        } else {
            System.out.println("No se pueden añadir más copias. El lector ya tiene 3 copias.");
        }
    }
    
    public void comprobarMultasPendientes(){
        
    }
}
