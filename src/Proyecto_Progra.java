

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

            opcion = JOptionPane.showInputDialog(" SISTEMA DE INVENTARIO \n" + "1. Registrar libro\n"+ "2. Buscar libro\n"+ "3. Reubicar libro\n"+ "4. Mostrar inventario\n"+ "5. Salir");

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
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (!opcion.equals("5"));
    }

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
    

