package ProgramacionMultihilo.productorConsumidor;

public class Productor extends Thread {
    private Recipiente reci;
    private int numero; // Si hay varios productores cada
    // cada uno llevará un numero
    private static final String[] mensaje = new String[] { "PING", "PONG" };

    // Constructor
    public Productor(Recipiente recipi, int num) {
        reci = recipi;
        numero = num;
    }

    public Productor(Recipiente recipi) {
        reci = recipi;
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                reci.llenar(mensaje[0]);
            } else
                reci.llenar(mensaje[1]);
         //   System.out.println("Productor " + numero + " pone el valor " + i);
            // espera un tiempo antes de volver a llenar
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo...");
            }
        }
    }
}