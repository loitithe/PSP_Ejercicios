package ProgramacionMultihilo.ejercicio5;

import ProgramacionMultihilo.ejercicio4.Saldo;

public class Cuenta {

    private Saldo objeto_saldo;

    public Cuenta(Saldo saldo) {
        this.objeto_saldo = saldo;
    }

    public Saldo getObjeto_saldo() {
        return objeto_saldo;
    }

    public void setObjeto_saldo(Saldo saldo) {
        this.objeto_saldo = saldo;
    }

    public synchronized double importeSaldo() {
        return getObjeto_saldo().getSaldo();
    }

    public synchronized void retirar(double cantidad) {
        if (comprobarRetirada(cantidad)) {
            objeto_saldo.retirar(cantidad);
        } else
            System.out.println("No hay suficiente saldo en la cuenta");
    }

    public synchronized boolean comprobarRetirada(double cantidad_retirada) {
        if (importeSaldo() < cantidad_retirada) {
            return true;
        }
        return false;
    }
}
