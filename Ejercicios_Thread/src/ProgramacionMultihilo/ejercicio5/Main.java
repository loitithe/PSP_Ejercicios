package ProgramacionMultihilo.ejercicio5;

import ProgramacionMultihilo.ejercicio4.Saldo;

public class Main {
    public static void main(String[] args) {
        Saldo saldo = new Saldo(14000);
        Cuenta cuenta = new Cuenta(saldo);

        RetiradaCajero pepe = new RetiradaCajero("Pepe", cuenta);
        RetiradaCajero maria = new RetiradaCajero("Maria", cuenta);

        pepe.start();
        maria.start();
    }
}
