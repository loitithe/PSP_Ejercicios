package ProgramacionMultihilo.ejercicio4;

public class Saldo {
    private double saldo;

    public Saldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        try {
            Hilo.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return saldo;
    }

    public void setSaldo(double saldo) {
        try {
            Hilo.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.saldo = saldo;
    }

    public synchronized void ingresar(double cantidad) {

        this.saldo += cantidad;
        System.out.println("Ingreso correcto.\nSaldo en su cuenta:" + this.saldo);
    }

    public synchronized void retirar(double cantidad) {

        this.saldo -= cantidad;
        System.out.println("Retirada correcta.\nSaldo en su cuenta:" + this.saldo);
    }

}
