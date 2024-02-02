package ProgramacionMultihilo.ejercicio5;

public class RetiradaCajero extends Thread {

    private String nombre;
    private Cuenta cuenta;

    RetiradaCajero(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Numero de transaccion " + i);
            cuenta.retirar(numeroaleatorio());
        }
    }

    private double numeroaleatorio() {
        double num = (long) (Math.random() * 200 + 1);
        System.out.println("cantidad aleatoria " + num);
        return num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
