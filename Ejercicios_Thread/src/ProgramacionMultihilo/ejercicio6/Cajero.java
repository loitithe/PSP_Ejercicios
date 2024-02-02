package ProgramacionMultihilo.ejercicio6;

import java.util.ArrayList;
import java.util.List;

/**
 * recurso compartido por los terminales. seccion critica
 * contendra un atributo localidades que llevara la cuenta de las localidades
 * vendidas que iran incrementando
 * los diferentes terminales.
 * Metodo mostrarlocalidades.
 */
public class Cajero {
    private Localidades localidades;
    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarLocalidades() {
        System.out.println("Numero de localidades :" + localidades);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localidades getLocalidades() {
        return localidades;
    }

    public void setLocalidades(Localidades localidades) {
        this.localidades = localidades;
    }

}
