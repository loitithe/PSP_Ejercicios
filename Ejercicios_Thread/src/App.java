public class App {
    public static void main(String[] args) throws Exception {
        Hilo1 t1 = new Hilo1();
        Hilo2 t2 = new Hilo2();
        t1.start();
        t2.start();
        while (true) {
            if (t1.getX() == 10) {
                t1.interrupt();
            }
            if (t2.getY() == 250) {
                t2.interrupt();
            }
            t1.run();
            t1.sleep(2000);
            t2.run();
            t2.sleep(2000);
        }

    }
}

class HolaThread extends Thread {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
    }
}

class Hilo1 extends Thread {
    private int x;

    public int getX() {
        return x;
    }

    Hilo1() {
        this.x = x;
    }

    @Override
    public void run() {

        this.x += 1;
        System.out.println(this.x);
    }
}

class Hilo2 extends Thread {
    private int y;

    public int getY() {
        return y;
    }

    Hilo2() {
        this.y = y;
    }

    @Override
    public void run() {
        this.y += 50;
        System.out.println(this.y);
    }
}
