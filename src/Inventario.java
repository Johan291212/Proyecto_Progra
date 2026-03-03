/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ryzen
 */
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Libro> listaLibros;

    public Inventario() {
        listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarPorCodigo(String codigo) {

        for (int i = 0; i < listaLibros.size(); i++) {

            if (listaLibros.get(i).getCodigo().equals(codigo)) {
                return listaLibros.get(i);
            }
        }

        return null;
    }

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