package ProgramacionMultihilo.ejercicio3;

public class ContadorHilo extends Thread {

    private Contador contador;

    ContadorHilo(Contador contador, String name) {
        super(name);
        this.contador = contador;

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println(this.getName());
                contador.incrementa();
                contador.getValor();
                Thread.sleep(numeroaleatorio());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private long numeroaleatorio() {
        long num = (long) (Math.random() * 1800 + 1400);
        System.out.println("sleep aleatorio " + num);
        return num;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

}
