package ProgramacionMultihilo.ejercicio3;

public class MainContador {

    public static void main(String[] args) {
        Contador contador = new Contador();
        ContadorHilo contador1 = new ContadorHilo(contador, "contador1");

        ContadorHilo contador2 = new ContadorHilo(contador, "contador2");

        ContadorHilo contador3 = new ContadorHilo(contador, "contador3");

        ContadorHilo contador4 = new ContadorHilo(contador, "contador4");

        contador1.start();
        contador2.start();
        contador3.start();
        contador4.start();

    }
}
