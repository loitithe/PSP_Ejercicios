package ProgramacionMultihilo.ejercicio6;

public class Terminal extends Thread {
    private Localidades localidades;
    private Cajero cajero;
    private int ventas;

    @Override
    public void run() {
        int numeroaleatorio = numeroaleatorio();
        System.out.println("Vendiendo " + numeroaleatorio + " entradas");
        if (localidades.venta(numeroaleatorio, this.getName())) {
            this.ventas += numeroaleatorio;
        }
    }

    public Terminal(Localidades localidades, Cajero cajero) {
        this.localidades = localidades;
        this.cajero = cajero;
        this.ventas = 0;
    }

    public Localidades getLocalidades() {
        return localidades;
    }

    public void setLocalidades(Localidades localidades) {
        this.localidades = localidades;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    private int numeroaleatorio() {
        int num = (int) (Math.random() * 10 + 1);
        System.out.println("cantidad aleatoria " + num);
        return num;
    }

}
