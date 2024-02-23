package EjerciciosSincronizacion.ProductorConsumidor;

public class Alumno extends Thread {
    private Clase clase;

    public Alumno(Clase clase) {
        this.clase = clase;
    }

    @Override
    public void run() {
        try {
            System.out.println("Saludos profe");
            clase.entrar();
            sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo...");
        }
    }
}
