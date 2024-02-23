package ProgramacionMultihilo.productorConsumidor;

public class Main {
    public static void main(String args[]) {
        Recipiente reci = new Recipiente();

        // Productor produ1 = new Productor(reci, 1);
        // Consumidor consu1 = new Consumidor(reci, 1);
        Productor produ1 = new Productor(reci);
        Consumidor consu1 = new Consumidor(reci);

        produ1.start();
        consu1.start();
    }

}
