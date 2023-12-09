# Parcial-Final-Lab-POO
Juan José Hurtado-Juliana Diaz. 
Entrega de parcial final de laboratorio de programación orientada a objetos 

## Respuesta de la pregunta

La representación gráfica proporciona una visión detallada del flujo de ejecución, abarcando la interacción entre distintas funcionalidades como préstamos, devoluciones, la actualización de multas y el pago de estas. La "enredada" visualizacion y entendimiento del diagrama podría resultar desafiante para un usuario común, ya que involucra diversas operaciones y formularios que requieren comprensión y uso preciso. Además, la gestión de multas y la persistencia de datos introducen niveles adicionales de complejidad que podrían resultar desconcertantes para aquellos no familiarizados con la lógica interna del sistema.

# Diagrama de proceso
<img width="280" alt="Diagrama de proceso" src="https://github.com/JuanHurtadom/Parcial-Final-Lab-POO/assets/142424907/74556fce-d6da-4f8d-a60f-51231c2db03d">
# Parcial Final - Sistema de Biblioteca

## Descripción

Este proyecto implementa un sistema básico de biblioteca que permite gestionar libros, lectores, préstamos y devoluciones. Se utiliza el framework Spark para las rutas HTTP y Gson para la serialización/deserialización JSON.

## Endpoints

### 1. Obtener lista de libros (JSON)
   - **Ruta:** `/libros/json`
   - **Método:** `GET`
   - **Descripción:** Retorna la lista de libros en formato JSON.

### 2. Obtener lista de lectores (JSON)
   - **Ruta:** `/lectores/json`
   - **Método:** `GET`
   - **Descripción:** Retorna la lista de lectores en formato JSON.

### 3. Obtener lista de lectores (HTML)
   - **Ruta:** `/lectores/html`
   - **Método:** `GET`
   - **Descripción:** Muestra la lista de lectores en formato HTML con opciones interactivas.

### 4. Realizar préstamo de libro
   - **Ruta:** `/prestamo/html`
   - **Método:** `GET`
   - **Descripción:** Muestra un formulario para realizar un préstamo, seleccionando un lector y un libro.

### 5. Realizar préstamo (Ejecución)
   - **Ruta:** `/prestamo/realizar`
   - **Método:** `POST`
   - **Descripción:** Maneja la realización del préstamo después de enviar el formulario.

### 6. Realizar devolución de libro
   - **Ruta:** `/devolucion/html`
   - **Método:** `GET`
   - **Descripción:** Muestra un formulario para realizar una devolución, seleccionando una copia.

### 7. Realizar devolución (Ejecución)
   - **Ruta:** `/devolucion/realizar`
   - **Método:** `POST`
   - **Descripción:** Maneja la realización de la devolución después de enviar el formulario.

## Cómo Demostrar el Funcionamiento

1. **Obtener lista de libros (JSON):**
   - Accede a la ruta `/libros/json` utilizando un cliente HTTP.
   - Deberías recibir un JSON con la lista de libros.

2. **Obtener lista de lectores (JSON):**
   - Accede a la ruta `/lectores/json` utilizando un cliente HTTP.
   - Recibirás un JSON con la lista de lectores.

3. **Obtener lista de lectores (HTML):**
   - Accede a la ruta `/lectores/html` desde tu navegador web.
   - Verás una lista interactiva de lectores en formato HTML.

4. **Realizar préstamo de libro:**
   - Accede a la ruta `/prestamo/html` desde tu navegador.
   - Completa el formulario seleccionando un lector y un libro.
   - Envía el formulario.
   - Verifica que el préstamo se haya realizado correctamente.

5. **Realizar devolución de libro:**
   - Accede a la ruta `/devolucion/html` desde tu navegador.
   - Completa el formulario seleccionando una copia.
   - Envía el formulario.
   - Verifica que la devolución se haya realizado correctamente.

## Requisitos del Sistema

- Java JDK 17
- Maven
- NetBeans (o cualquier entorno de desarrollo compatible con Maven)

## Configuración y Ejecución

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu entorno de desarrollo (por ejemplo, NetBeans).
3. Asegúrate de tener configurado Java JDK 17 y Maven.
4. Ejecuta la aplicación desde tu entorno de desarrollo o mediante la línea de comandos.
5. Accede a los diferentes endpoints para probar la funcionalidad.

## Notas Adicionales

-Manejo de errores