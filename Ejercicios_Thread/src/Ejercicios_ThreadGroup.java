public class Ejercicios_ThreadGroup {
    public static void main(String[] args) {
        Contador contador = new Contador(500);
        ThreadGroup threadGroup = new ThreadGroup("thread_group");
        hiloInc hiloInc = new hiloInc(contador);
        hiloDec hiloDec = new hiloDec(contador);

        hiloInc.start();
        hiloDec.start();

    }
}

class hiloInc extends Thread {
    private Contador contador;

    hiloInc(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            // while (contador.getNum() > -1000 || contador.getNum() < 2000) {

            for (int i = 0; i < 30; i++) {

                contador.incrementa();
                contador.getValor();
                Thread.sleep(100);
            }

            // }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class hiloDec extends Thread {
    private Contador contador;

    hiloDec(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            // while (contador.getNum() > -1000 || contador.getNum() < 2000) {
            for (int i = 0; i < 30; i++) {
                contador.decrementa();
                contador.getValor();
                Thread.sleep(100);
            }

            // }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Contador {
    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Contador(int num) {
        this.num = num;
    }

    public synchronized void incrementa() {
        num = num + 1;
    }

    public synchronized void decrementa() {
        num = num - 1;

    }

    public synchronized void getValor() {
        System.out.println(num);

    }
}
