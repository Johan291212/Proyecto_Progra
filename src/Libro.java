/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ryzen
 */
public class Libro {

    /** Código único del libro */
    private String codigo;

    /** Título del libro */
    private String titulo;

    /** Autor del libro */
    private String autor;

    /** Categoría del libro */
    private String categoria;

    /** Cantidad disponible en inventario */
    private int cantidad;

    /** Precio del libro */
    private double precio;

    /** Ubicación del libro en la bodega */
    private Ubicacion ubicacion;

    /**
     * Constructor de la clase Libro.
     * 
     * @param codigo código único del libro
     * @param titulo título del libro
     * @param autor autor del libro
     * @param categoria categoría del libro
     * @param cantidad cantidad disponible
     * @param precio precio del libro
     * @param ubicacion ubicación en la bodega
     */
    public Libro(String codigo, String titulo, String autor,
            String categoria, int cantidad, double precio,
            Ubicacion ubicacion) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el código del libro.
     * 
     * @return código del libro
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el título del libro.
     * 
     * @return título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     * 
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene la ubicación del libro.
     * 
     * @return objeto Ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * Modifica la ubicación del libro.
     * 
     * @param ubicacion nueva ubicación
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la cantidad disponible del libro.
     * 
     * @return cantidad en inventario
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Modifica la cantidad disponible del libro.
     * 
     * @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
