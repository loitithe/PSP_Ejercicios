package Boletin4;

public class Corredor extends Thread {

    private String nombre;
    private short id;
    private Relevos relevos;

    public Corredor(String nombre, short id, Relevos relevos) {
        this.nombre = nombre;
        this.id = id;
        this.relevos = relevos;
    }

    @Override
    public void run() {
        System.out.println("Soy el corredor " + nombre);
        try {
            sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminé, paso el testigo al corredor " + (id + 1));
        relevos.pasarTestigo(id);
    }
}
