/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

/**
 *
 * @author Ryzen
 */
public class Venta {

    /** Código identificador de la venta */
    private String codigo;

    /** Fecha en la que se realizó la venta */
    private String fecha;

    /** Lista de libros vendidos en esta venta */
    private ArrayList<Libro> librosVendidos;

    /**
     * Constructor de la clase Venta.
     * 
     * @param codigo código de la venta
     * @param fecha fecha de la venta
     */
    public Venta(String codigo, String fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
        librosVendidos = new ArrayList<>();
    }

    /**
     * Agrega un libro a la lista de libros vendidos.
     * 
     * @param libro libro vendido
     */
    public void agregarLibro(Libro libro) {
        librosVendidos.add(libro);
    }

    /**
     * Obtiene la lista de libros vendidos en esta venta.
     * 
     * @return lista de libros vendidos
     */
    public ArrayList<Libro> getLibrosVendidos() {
        return librosVendidos;
    }

}
