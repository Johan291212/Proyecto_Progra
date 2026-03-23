

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

        Inventario inventario = new Inventario();
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
     * Registra un nuevo libro en el inventario. Solicita los datos al usuario y
     * valida que el código no esté duplicado.
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
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));

        int estante = Integer.parseInt(JOptionPane.showInputDialog("Estante:"));
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila:"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Columna:"));

        Ubicacion ubicacion = new Ubicacion(estante, fila, columna);

        Libro libro = new Libro(codigo, titulo, autor, categoria, cantidad, precio, ubicacion);

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

            int cantidadVenta = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a vender:"));

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

            int estante = Integer.parseInt(JOptionPane.showInputDialog("Nuevo estante:"));
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Nueva fila:"));
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Nueva columna:"));

            libro.setUbicacion(new Ubicacion(estante, fila, columna));

            JOptionPane.showMessageDialog(null, "Libro reubicado correctamente.");

        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }
}
