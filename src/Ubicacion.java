/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ryzen
 */
public class Ubicacion {
    
    /** Número de estante donde se encuentra el libro */
    private int estante;
    
    /** Fila dentro del estante */
    private int fila;
    
    /** Columna dentro del estante */
    private int columna;

    /**
     * Constructor de la clase Ubicacion.
     * 
     * @param estante número de estante
     * @param fila número de fila
     * @param columna número de columna
     */
    public Ubicacion(int estante, int fila, int columna) {
        this.estante = estante;
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Devuelve la ubicación en formato legible.
     * 
     * @return texto con la ubicación del libro
     */
    public String mostrarUbicacion() {
        return "E" + estante + " Fila: " + fila + " Columna: " + columna;
    }
}
