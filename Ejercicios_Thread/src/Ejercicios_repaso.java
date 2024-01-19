import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejercicios_repaso {

    public static void main(String[] args) {
        // Hilo1 hilo1 = new Hilo1();
        // Hilo2 hilo2 = new Hilo2();
        // System.out.println("Ejecutando hilo 1");
        // hilo1.start();
        // System.out.println("Ejecutando hilo 2");
        // hilo2.start();
        // System.out.println("Ejecutando main");

        // Factorial factorial = new Factorial(20);
        // Fibonacci fibonacci = new Fibonacci(20);
        // factorial.start();
        // fibonacci.start();

        // VisualizarRunnable visualizarRunnable = new
        // VisualizarRunnable("pasoosoooso");
        // Thread[] hilos = new Thread[5];

        // for (int i = 0; i < 5; i++) {
        // Thread hilo = new Thread(visualizarRunnable);
        // hilos[i] = hilo;
        // }

        // for (int i = 0; i < hilos.length; i++) {
        // hilos[i].start();
        // }

        ArrayList<File> ficheros = new ArrayList<>();

        ArrayList<Cuenta_caracteres> listaHilos = new ArrayList<>();
        ficheros.add(new File("Ejercicios_Thread\\src\\fichero.txt"));
        ficheros.add(new File("Ejercicios_Thread\\src\\fichero2.txt"));

        for (File file : ficheros) {
            Cuenta_caracteres cuenta_caracteres = new Cuenta_caracteres(file);
            listaHilos.add(cuenta_caracteres);
            cuenta_caracteres.start();
        }

        for (Cuenta_caracteres cuenta_caracteres : listaHilos) {
            // cuenta_caracteres.start();
        }
        // cuenta_caracteres.leerFicheros();
    }
}

class Hilo1 extends Thread {

    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("NO");
        }
    }
}

class Hilo2 extends Thread {

    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("YES");
        }
    }
}

class Factorial extends Thread {

    private int numero;

    Factorial(int numero) {
        this.numero = numero;
    }

    public long calcula_factorial() {
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }

    @Override
    public void run() {
        System.out.println("Factorial : " + calcula_factorial());
    }
}

class Fibonacci extends Thread {

    private int numero;

    Fibonacci(int numero) {
        this.numero = numero;
    }

    public void calcula_fibonacci() {
        int fib1 = 0;
        int fib2 = 1;
        int fibn;

        if (1 != numero) {
            System.out.println("Primer numero de Fibonacci" + fib1);
            System.out.println("Sgundo numero de Fibonacci" + fib2);

            for (int i = 3; i <= numero; i++) {
                fibn = fib2 + fib1;
                fib1 = fib2;
                fib2 = fibn;

                System.out.println("Numero fibonacci " + i + " es " + fibn);
            }
        }
    }

    @Override
    public void run() {
        calcula_fibonacci();
    }

}

class VisualizarRunnable implements Runnable {
    private String mensaje;

    VisualizarRunnable(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Thread.currentThread().getId() * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola mundo " + mensaje + " " + Thread.currentThread().getId());

    }

}

class Cuenta_caracteres extends Thread {
    private ArrayList<File> ficheros;

    public File getFichero() {
        return fichero;
    }

    private File fichero;
    private String nombreFichero;

    Cuenta_caracteres(ArrayList<File> ficheros) {
        this.ficheros = ficheros;
    }

    public Cuenta_caracteres(File fichero) {
        this.fichero = fichero;
        this.nombreFichero = fichero.getName();
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    void leerFicheros() {
        for (File file : ficheros) {
            leerFichero(file);
        }
    }

    void leerFichero(File fichero) {
        System.out.println("Leyendo fichero : " + fichero.getName());
        String linea;
        int a = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    System.out.print(linea.charAt(i));
                    if (i == 0) {
                        if (linea.charAt(i) != ' ')
                            a++;
                    } else {
                        if (linea.charAt(i - 1) == ' ')
                            if (linea.charAt(i) != ' ')
                                a++;

                    }
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
        }
        System.out.println("\n \t!! !! El archivo " + fichero.getName() + " contiene " + a + " palabras");

    }

    @Override
    public void run() {
        long t_start, t_fin;
        t_start = System.currentTimeMillis();

        leerFichero(fichero);
        System.out.println(fichero.getAbsolutePath());
        t_fin = System.currentTimeMillis();
        long tiempo_proceso = t_fin - t_start;
        System.out.println("El proceso a tardado : " + tiempo_proceso + " ");
    }
}