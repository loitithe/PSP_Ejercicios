package ProgramacionMultihilo.productorConsumidor;

public class Consumidor extends Thread {
    private Recipiente reci;
    private int numero;

    // constructor
    public Consumidor(Recipiente recipi, int nume) {
        reci = recipi;
        numero = nume;
    }

    public Consumidor(Recipiente recipi) {
        reci = recipi;

    }

    public void run() {
        String valor = "";
        for (int i = 0; i < 15; i++) {
            valor = reci.vaciar();
            System.out.println(valor);
           // System.out.println("Consumidor " + numero + " toma el valor " + i);

            // espera un tiempo antes de volver a consumir
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo...");
            }
        }
    }
}