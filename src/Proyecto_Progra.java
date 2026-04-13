

/*
Universidad Fidelitas
Proyecto de introduccion a Programacion Orientada a Objetos
Johan Ledezma Alvarez
Julian Guadron Barquero
Aresys Saeed Grant Arceda
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.JOptionPane;

/**
 *
 * @author Ryzen
 */
public class Proyecto_Progra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Inventario inventario = new Inventario(3, 3, 3);

        Libro l1 = new Libro("001", "Java Básico", "Juan Perez", "Programación", 10, 5000,
                new Ubicacion(0, 0, 0));

        Libro l2 = new Libro("002", "Estructuras de Datos", "Maria Lopez", "Programación", 5, 7000,
                new Ubicacion(0, 1, 1));

        Libro l3 = new Libro("003", "POO en Java", "Carlos Ruiz", "Programación", 8, 6500,
                new Ubicacion(1, 0, 2));

        inventario.agregarLibro(l1);
        inventario.agregarLibro(l2);
        inventario.agregarLibro(l3);

        inventario.asignarUbicacion(l1, 0, 0, 0);
        inventario.asignarUbicacion(l2, 0, 1, 1);
        inventario.asignarUbicacion(l3, 1, 0, 2);
        String opcion;

        do {

            opcion = JOptionPane.showInputDialog(" SISTEMA DE INVENTARIO \n"
                    + "1. Registrar libro\n"
                    + "2. Buscar libro\n"
                    + "3. Reubicar libro\n"
                    + "4. Mostrar inventario\n"
                    + "5. Registrar venta\n"
                    + "6. Salir");

            switch (opcion) {

                case "1":
                    registrarLibro(inventario);
                    break;

                case "2":
                    buscarLibro(inventario);
                    break;

                case "3":
                    reubicarLibro(inventario);
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, inventario.mostrarInventario());
                    break;

                case "5":
                    registrarVenta(inventario);
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (!opcion.equals("6"));
    }

    /**
     * Solicita al usuario un número entero mediante una ventana emergente y
     * valida que la entrada sea correcta. En caso de error (letras, vacío,
     * etc.), vuelve a solicitar el dato.
     *
     * @param mensaje mensaje que se muestra al usuario
     * @return número entero válido ingresado por el usuario
     */
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }

    /**
     * Solicita al usuario un número decimal mediante una ventana emergente y
     * valida que la entrada sea correcta. En caso de error, vuelve a solicitar
     * el dato.
     *
     * @param mensaje mensaje que se muestra al usuario
     * @return número decimal válido ingresado por el usuario
     */
    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }

    /**
     * Registra un nuevo libro en el inventario.
     *
     * Realiza las siguientes validaciones: - Verifica que el código no esté
     * duplicado - Valida que los datos numéricos sean correctos - Verifica que
     * la ubicación en la bodega esté disponible
     *
     * @param inventario objeto Inventario donde se almacenan los libros
     */
    public static void registrarLibro(Inventario inventario) {

        String codigo = JOptionPane.showInputDialog("Ingrese código:");

        if (inventario.buscarPorCodigo(codigo) != null) {
            JOptionPane.showMessageDialog(null, "Código duplicado.");
            return;
        }

        String titulo = JOptionPane.showInputDialog("Ingrese título:");
        String autor = JOptionPane.showInputDialog("Ingrese autor:");
        String categoria = JOptionPane.showInputDialog("Ingrese categoría:");
        int cantidad = leerEntero("Cantidad:");
        double precio = leerDouble("Precio:");

        int estante = leerEntero("Estante:");
        int fila = leerEntero("Fila:");
        int columna = leerEntero("Columna:");

        Ubicacion ubicacion = new Ubicacion(estante, fila, columna);

        Libro libro = new Libro(codigo, titulo, autor, categoria, cantidad, precio, ubicacion);

        /**
         *
         * Validacion de la bodega
         *
         */
        if (!inventario.asignarUbicacion(libro, estante, fila, columna)) {
            JOptionPane.showMessageDialog(null, "Ubicación ocupada o inválida.");
            return;
        }

        inventario.agregarLibro(libro);

        JOptionPane.showMessageDialog(null, "Libro registrado correctamente.");
    }

    /**
     * Registra la venta de un libro. Valida que el libro exista, que la
     * cantidad sea válida y que haya suficiente stock disponible.
     *
     * @param inventario objeto Inventario que contiene los libros
     */
    public static void registrarVenta(Inventario inventario) {

        String codigo = JOptionPane.showInputDialog("Ingrese código del libro:");

        Libro libro = inventario.buscarPorCodigo(codigo);

        if (libro != null) {

            int cantidadVenta = leerEntero("Cantidad a vender:");

            // Validación de cantidad inválida
            if (cantidadVenta <= 0) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                return;
            }

            // Validación de stock
            if (cantidadVenta <= libro.getCantidad()) {

                libro.setCantidad(libro.getCantidad() - cantidadVenta);

                JOptionPane.showMessageDialog(null, "Venta realizada correctamente.");

            } else {
                JOptionPane.showMessageDialog(null, "Stock insuficiente.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }

    /**
     * Busca un libro en el inventario por su código. Muestra la información del
     * libro si existe.
     *
     * @param inventario objeto Inventario donde se realiza la búsqueda
     */
    public static void buscarLibro(Inventario inventario) {

        String codigo = JOptionPane.showInputDialog("Ingrese código:");

        Libro libro = inventario.buscarPorCodigo(codigo);

        if (libro != null) {

            JOptionPane.showMessageDialog(null,
                    "Código: " + libro.getCodigo()
                    + "\nTítulo: " + libro.getTitulo()
                    + "\nAutor: " + libro.getAutor()
                    + "\nUbicación: " + libro.getUbicacion().mostrarUbicacion()
            );

        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }

    /**
     * Permite cambiar la ubicación de un libro en la bodega.
     *
     * @param inventario objeto Inventario donde se encuentra el libro
     */
    public static void reubicarLibro(Inventario inventario) {

        String codigo = JOptionPane.showInputDialog("Ingrese código del libro:");

        Libro libro = inventario.buscarPorCodigo(codigo);

        if (libro != null) {

            int estante = leerEntero("Nuevo estante:");
            int fila = leerEntero("Nueva fila:");
            int columna = leerEntero("Nueva columna:");

//
            if (!inventario.asignarUbicacion(libro, estante, fila, columna)) {
                JOptionPane.showMessageDialog(null, "Ubicación ocupada o inválida.");
                return;
            }

            libro.setUbicacion(new Ubicacion(estante, fila, columna));

            JOptionPane.showMessageDialog(null, "Libro reubicado correctamente.");

        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }
}
