package EjerciciosSincronizacion.ProductorConsumidor;

public class Main {
    public static void main(String[] args) {

        Clase clase = new Clase();
        Profesor profesor = new Profesor(clase);
        Alumno alumno;
        for (int i = 0; i < 10; i++) {
            alumno = new Alumno(clase);
            alumno.start();
        }
        profesor.start();
    }
}
