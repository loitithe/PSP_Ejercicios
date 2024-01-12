public class Ejercicios_repaso {

    public static void main(String[] args) throws InterruptedException {
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

        VisualizarRunnable visualizarRunnable = new VisualizarRunnable("pasoosoooso");
        Thread[] hilos = new Thread[5];
        
        for (int i = 0; i < 5; i++) {
            Thread hilo = new Thread(visualizarRunnable);
            hilos[i] = hilo;
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
            hilos[i].sleep(400);
        }

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
        System.out.println("Hola mundo " + mensaje);
    }

}