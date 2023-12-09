
package com.mycompany.parcialfinal;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        LinkedList<Libro> libros = new LinkedList<>();
        
        LinkedList<Autor> autoresLibro1 = new LinkedList<>();
        LinkedList<Autor> autoresGenericos = new LinkedList<>();
        
        LinkedList<Copia> copias = new LinkedList<>();
        LinkedList<Lector> lectores = new LinkedList<>();
        
        LinkedList<Prestamo> prestamos = new LinkedList<>();
        
        LinkedList<Multa> multas = new LinkedList<>();
        
        /** Obtener la fecha actual **/ 
        LocalDate fechaActual = LocalDate.now();
        
        /** Obtener el mes actual como un objeto Month **/
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();
    }
}
