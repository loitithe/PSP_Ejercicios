package Boletin4;

public class Relevos {

    private boolean comienza = false;
    private Corredor[] corredores;

    public Relevos(int numCorredores) {
        corredores = new Corredor[numCorredores];
        for (short i = 0; i < numCorredores; i++) {
            corredores[i] = new Corredor("Corredor " + i, i, this);
        }
    }

    public synchronized void comenzar() {
        comienza = true;
        System.out.println("¡COMIENZA LA CARRERA!");
        notifyAll(); // Despierta a todos los corredores para que comiencen.
    }

    public synchronized void prepararCorredor(int idCorredor) {
        while (!comienza) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        corredores[idCorredor].start(); // Comienza la ejecución del corredor.
    }

    public synchronized void pasarTestigo(int idCorredor) {
        if (idCorredor < corredores.length - 1) {
            prepararCorredor(idCorredor + 1); // Prepara al siguiente corredor.
        } else
            System.out.println("Todos los hilos terminaron");
    }

}
