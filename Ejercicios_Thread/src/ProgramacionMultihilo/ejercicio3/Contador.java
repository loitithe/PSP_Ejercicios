package ProgramacionMultihilo.ejercicio3;

public class Contador {

    private int numero = 0;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public synchronized void incrementa() {
        numero = numero + 1;
    }

    public synchronized void decrementa() {
        numero = numero - 1;
    }

    public synchronized void getValor() {
        System.out.println(numero);

    }
}
