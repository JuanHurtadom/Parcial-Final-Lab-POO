

package com.mycompany.pruebabiblioteca;

import static spark.Spark.*;
import com.google.gson.*;
import java.util.Random;

import java.util.ArrayList;

public class Biblioteca {

   public static void main(String[] args) {
       
      // Crear un objeto Gson para serialización/deserialización JSON
        Gson gson = new Gson();

        // Crear listas de libros y lectores
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Lector> lectores = new ArrayList<>();

        /// Crear objetos Autor
        Autor pauloCoelho = new Autor("Paulo Coelho", "Brasil", "24 de agosto de 1947");
        Autor patriciaHighsmith = new Autor("Patricia Highsmith", "Estados Unidos", "19 de enero de 1921");
        Autor gabrielGarciaMarquez = new Autor("Gabriel Garcia Marquez", "Colombia", "6 de marzo de 1927");

        // Autores de cada libro
        ArrayList<Autor> autoresElAlquimista = new ArrayList<>();
        autoresElAlquimista.add(pauloCoelho);
        ArrayList<Autor> autoresOnceMinutos = new ArrayList<>();
        autoresOnceMinutos.add(pauloCoelho);
        ArrayList<Autor> autoresExtranosEnUnTren = new ArrayList<>();
        autoresExtranosEnUnTren.add(patriciaHighsmith);
        ArrayList<Autor> autoresCienAniosDeSoledad = new ArrayList<>();
        autoresCienAniosDeSoledad.add(gabrielGarciaMarquez);

        // Crear objetos Libro
        Libro elAquimista = new Libro("El alquimista", "Novela", "Planeta", "1988", autoresElAlquimista);
        Libro onceMinutos = new Libro("Once minutos", "Novela, ficcion", "Planeta", "2003", autoresOnceMinutos);
        Libro extranosEnUnTren = new Libro("Extraños en un tren", "Misterio", "Anagrama", "1924", autoresExtranosEnUnTren);
        Libro cienAnosSoledad = new Libro("Cien años de soledad", "Realismo Mágico", "Sudamericana", "1967", autoresCienAniosDeSoledad);

        // Crear copias de los libros y añadirlas al libro
        elAquimista.agregarCopias(crearCopias(elAquimista, 3));
        onceMinutos.agregarCopias(crearCopias(onceMinutos, 2));
        extranosEnUnTren.agregarCopias(crearCopias(extranosEnUnTren, 4));
        cienAnosSoledad.agregarCopias(crearCopias(cienAnosSoledad, 5));

        // Añadir los libros a la lista de libros
        libros.add(elAquimista);
        libros.add(onceMinutos);
        libros.add(extranosEnUnTren);
        libros.add(cienAnosSoledad);

        
        // Crear el objeto lector por defecto
        Lector jordanMinota = new Lector(1, "Jordan", "Minota", "Calle 123");
        Lector julianaDiaz = new Lector(2, "Juliana", "Díaz", "Avenida 456");
        Lector juanJoseHurtado = new Lector(3, "Juan José", "Hurtado", "Carrera 789");

        // Añadir lectores a la lista de lectores
        lectores.add(jordanMinota);
        lectores.add(julianaDiaz);
        lectores.add(juanJoseHurtado);


        // Rutas de Spark 

        // Mostrar lista de libros en formato JSON
        get("/libros/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(libros);
        });

        // Mostrar lista de lectores en formato JSON
        get("/lectores/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(lectores);
        });

        
        // Ruta para manejar la adición de un nuevo lector
        post("/lectores/agregar", (req, res) -> {
            int numSocio = lectores.size() + 1;
            String nombre = req.queryParams("nombre");
            String apellidos = req.queryParams("apellidos");
            String direccion = req.queryParams("direccion");

            // Crear y agregar el nuevo lector
            Lector nuevoLector = new Lector(numSocio, nombre, apellidos, direccion);
            lectores.add(nuevoLector);

            // Redirigir de nuevo a la página de lista de lectores
            res.redirect("/lectores/html");
            return null;
        });

        // Ruta para mostrar el formulario de préstamo de libro
        get("/prestamo/html", (req, res) -> {
            res.type("text/html");
            StringBuilder html = new StringBuilder("<html><body><h1>Préstamo de Libros</h1>");

            // Formulario para seleccionar lector y libro
            html.append("<form method='post' action='/prestamo/realizar'>");

            // Lista desplegable para seleccionar el lector
            html.append("<label for='lector'>Seleccione un lector:</label>");
            html.append("<select name='lector'>");
            for (Lector lector : lectores) {
                html.append("<option value='").append(lector.getNumSocio()).append("'>")
                        .append(lector.getNombreCompleto()).append("</option>");
            }
            html.append("</select><br>");

            // Lista desplegable para seleccionar el libro
            html.append("<label for='libro'>Seleccione un libro:</label>");
            html.append("<select name='libro'>");
            for (Libro libro : libros) {
                html.append("<option value='").append(libro.getNombre()).append("'>")
                        .append(libro.getNombre()).append("</option>");
            }
            html.append("</select><br>");

            // Botón para realizar el préstamo
            html.append("<input type='submit' value='Realizar Préstamo'>");
            html.append("</form>");

            html.append("</body></html>");
            return html.toString();
        });

        // Ruta para manejar la realización del préstamo
        post("/prestamo/realizar", (req, res) -> {
            String numSocio = req.queryParams("lector");
            String tituloLibro = req.queryParams("libro");

            // Buscar lector y libro correspondientes
            Lector lectorSeleccionado = null;
            for (Lector lector : lectores) {
                if (Integer.toString(lector.getNumSocio()).equals(numSocio)) {
                    lectorSeleccionado = lector;
                    break;
                }
            }

            Libro libroSeleccionado = null;
            for (Libro libro : libros) {
                if (libro.getNombre().equals(tituloLibro)) {
                    libroSeleccionado = libro;
                    break;
                }
            }

            // Realizar el préstamo
            if (lectorSeleccionado != null && libroSeleccionado != null) {
                for (Copia copia : libroSeleccionado.getCopias()) {
                    if ("NoPrestado".equals(copia.getEstado())) {
                        copia.prestar(lectorSeleccionado);
                        res.redirect("/prestamo/html?mensaje=Préstamo realizado exitosamente");
                        break;
                    }
                }
            } else {
                res.redirect("/prestamo/html?mensaje=Error en el préstamo o copias insuficientes");
            }
            return null;
        });

        // Ruta para mostrar el formulario de devolución de libro
        get("/devolucion/html", (req, res) -> {
            res.type("text/html");
            StringBuilder html = new StringBuilder("<html><body><h1>Devolución de Libros</h1>");

            // Formulario para seleccionar la copia
            html.append("<form method='post' action='/devolucion/realizar'>");

            // Lista de todas las copias y el nombre del lector asociado
            html.append("<label for='copia'>Seleccione una copia:</label>");
            html.append("<select name='copia'>");
            for (Lector lector : lectores) {
                for (Copia copia : lector.getCopias()) {
                    html.append("<option value='").append(copia.getIdentificador()).append("'>")
                            .append("Libro: ").append(copia.getLibro().getNombre())
                            .append(", Copia: ").append(copia.getIdentificador())
                            .append(", Lector: ").append(lector.getNombreCompleto()).append("</option>");
                }
            }
            html.append("</select><br>");

            // Botón para realizar la devolución
            html.append("<input type='submit' value='Realizar Devolución'>");
            html.append("</form>");

            html.append("</body></html>");
            return html.toString();
        });

        // Ruta para manejar la realización de la devolución
        post("/devolucion/realizar", (req, res) -> {
            int idCopia = Integer.parseInt(req.queryParams("copia"));

            // Buscar copia correspondiente
            Copia copiaSeleccionada = null;
            for (Lector lector : lectores) {
                for (Copia copia : lector.getCopias()) {
                    if (copia.getIdentificador() == idCopia) {
                        copiaSeleccionada = copia;
                        break;
                    }
                }
                if (copiaSeleccionada != null) {
                    break;
                }
            }

            // Realizar la devolución
            if (copiaSeleccionada != null) {
                copiaSeleccionada.devolver();
                res.redirect("/devolucion/html?mensaje=Devolución realizada exitosamente");
            } else {
                res.redirect("/devolucion/html?mensaje=Error en la devolución");
            }
            return null;
        });
    }

    // Método para crear copias de un libro
    private static ArrayList<Copia> crearCopias(Libro libro, int cantidad) {
        Random random = new Random();
        ArrayList<Copia> copias = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            int identificador = random.nextInt(1000);
            Copia copia = new Copia(identificador, libro);
            copias.add(copia);
        }
        return copias;
    }
}
