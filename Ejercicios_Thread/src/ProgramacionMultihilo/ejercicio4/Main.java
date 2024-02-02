package ProgramacionMultihilo.ejercicio4;

public class Main {
    public static void main(String[] args) {
        Saldo saldo = new Saldo(300);
        Hilo hilo1 = new Hilo(saldo, 2000, 1);
        Hilo hilo2 = new Hilo(saldo, 1000, 2);
        Hilo hilo3 = new Hilo(saldo, 20, 1);
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("saldo final " + saldo.getSaldo());
    }
}
