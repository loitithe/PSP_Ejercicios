package Boletin4;

public class Main {
    public static void main(String[] args) {
        Relevos relevos = new Relevos(4); // Crear relevos con 4 corredores
        relevos.comenzar(); // Comenzar la carrera
        relevos.prepararCorredor(0); // Preparar el primer corredor
    }
}
