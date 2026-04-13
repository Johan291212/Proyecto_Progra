/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

/**
 *
 * @author Ryzen
 */
public class Inventario {

    /**
     * Lista que almacena todos los libros registrados
     */
    private ArrayList<Libro> listaLibros;

    /**
     * Matriz tridimensional que representa la bodega (estante, fila, columna)
     */
    private Libro[][][] bodega;

    /**
     * Cantidad de estantes
     */
    private int estantes;

    /**
     * Cantidad de filas por estante
     */
    private int filas;

    /**
     * Cantidad de columnas por estante
     */
    private int columnas;

    /**
     * Constructor que inicializa la bodega con dimensiones específicas.
     *
     * @param estantes número de estantes
     * @param filas número de filas por estante
     * @param columnas número de columnas por estante
     */
    public Inventario(int estantes, int filas, int columnas) {

        this.estantes = estantes;
        this.filas = filas;
        this.columnas = columnas;

        bodega = new Libro[estantes][filas][columnas];
        listaLibros = new ArrayList<>();
    }

    /**
     * Constructor por defecto que solo inicializa la lista de libros. (No
     * inicializa la bodega)
     */
    public Inventario() {
       this(3, 3, 3);
    }

    /**
     * Muestra el estado de la bodega en forma de matriz. [ ] indica espacio
     * vacío, [X] indica espacio ocupado.
     *
     * @return representación en texto de la bodega
     */
    public String mostrarBodega() {

        String texto = "";

        for (int e = 0; e < estantes; e++) {

            texto += "=== Estante E" + (e + 1) + " ===\n";

            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < columnas; j++) {

                    if (bodega[e][i][j] == null) {
                        texto += "[ ] ";
                    } else {
                        texto += "[X] ";
                    }
                }
                texto += "\n";
            }
        }

        return texto;
    }

    /**
     * Asigna un libro a una ubicación específica dentro de la bodega.
     *
     * @param libro libro a ubicar
     * @param e índice del estante
     * @param f índice de la fila
     * @param c índice de la columna
     * @return true si la ubicación estaba libre y se asignó, false si estaba
     * ocupada
     */ 
    public boolean asignarUbicacion(Libro libro, int e, int f, int c) {

        if (bodega[e][f][c] == null) {
            bodega[e][f][c] = libro;
            return true;
        }

        return false;
    }

    /**
     * Agrega un libro a la lista del inventario.
     *
     * @param libro libro a agregar
     */
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    /**
     * Busca un libro en el inventario por su código.
     *
     * @param codigo código del libro a buscar
     * @return el libro encontrado o null si no existe
     */
    public Libro buscarPorCodigo(String codigo) {

        for (int i = 0; i < listaLibros.size(); i++) {

            if (listaLibros.get(i).getCodigo().equals(codigo)) {
                return listaLibros.get(i);
            }
        }

        return null;
    }

    /**
     * Muestra todos los libros registrados en el inventario junto con su
     * ubicación.
     *
     * @return texto con la información del inventario
     */
    public String mostrarInventario() {

        if (listaLibros.size() == 0) {
            return "Inventario vacío.";
        }

        String texto = "";

        for (int i = 0; i < listaLibros.size(); i++) {

            Libro l = listaLibros.get(i);

            texto += "Código: " + l.getCodigo()
                    + "\nTítulo: " + l.getTitulo()
                    + "\nUbicación: " + l.getUbicacion().mostrarUbicacion()
                    + "\n-----------------------\n";
        }

        return texto;
    }
}
