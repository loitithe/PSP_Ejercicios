package EjerciciosSincronizacion.ProductorConsumidor;

public class Clase {

    private boolean comienza = false;
    private String mensaje = "";

    public synchronized void entrar() {
        if (!comienza) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("tamo ready");

    }

    public synchronized void empezar() {
        try {
            System.out.println("Que comience la clase");
            this.comienza = true;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
