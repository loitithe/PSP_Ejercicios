package EjerciciosSincronizacion.ProductorConsumidor;

public class Profesor extends Thread {
    private Clase clase;

    public Profesor(Clase clase) {
        this.clase = clase;
    }

    @Override
    public void run() {
        System.out.println("Llego papá");
        try {
            clase.empezar();
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo...");
        }
    }

}
