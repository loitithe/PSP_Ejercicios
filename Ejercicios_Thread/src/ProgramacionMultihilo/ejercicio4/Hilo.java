package ProgramacionMultihilo.ejercicio4;

public class Hilo extends Thread {

    private Saldo saldo;
    private double cantidad;
    private int opcion;

    Hilo(Saldo saldo, double cantidad, int opcion) {
        this.saldo = saldo;
        this.cantidad = cantidad;
        this.opcion = opcion;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    @Override
    public void run() {
        switch (opcion) {
            case 1:
                System.out.println(this.getName() + " ingresando " + this.cantidad);
                saldo.ingresar(cantidad);
                break;
            case 2:

                System.out.println(this.getName() + " retirando " + this.cantidad);
                saldo.retirar(cantidad);
                break;
            default:
                break;
        }

    }

}
