package ProgramacionMultihilo.ejercicio6;

public class Localidades {

    private int aforo;
    private int ventas;

    public Localidades(int aforo) {
        this.aforo = aforo;
        this.ventas = 0;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public synchronized boolean venta(int cantidad, String nombreTerminal) {
        if (this.ventas + cantidad < aforo) {
            this.ventas += cantidad;
            System.out.println(cantidad + " localidades vendidas por " + nombreTerminal);
            return true;
        } else
            System.out.println("El aforo esta lleno");
        return false;

    }

}
