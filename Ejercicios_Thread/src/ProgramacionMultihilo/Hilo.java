package ProgramacionMultihilo;

public class Hilo extends Thread {
    private Contador contador;

    Hilo(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {

            contador.incrementa();
            contador.getValor();
        }

    }
}
