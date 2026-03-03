/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ryzen
 */
public class Ubicacion {
    
    private int estante;
    private int fila;
    private int columna;

    public Ubicacion(int estante, int fila, int columna) {
        this.estante = estante;
        this.fila = fila;
        this.columna = columna;
    }

    public String mostrarUbicacion() {
        return "E" + estante + " Fila: " + fila + " Columna: " + columna;
    }
}
