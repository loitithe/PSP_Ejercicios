public class Ejercicios_ThreadGroup {
    public static void main(String[] args) {
        Contador contador = new Contador(500);
        hiloInc hiloInc = new hiloInc(contador);
        hiloDec hiloDec = new hiloDec(contador);

        hiloInc.start();
        hiloDec.start();
        while (contador.getNum() > -1000 || contador.getNum() < 2000) {
            contador.getValor();

        }
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
            contador.incrementa();
            Thread.sleep(1000);
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
            contador.decrementa();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Contador {
    private int num;

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
        this.num++;
    }

    public synchronized void decrementa() {
        this.num--;

    }

    public synchronized void getValor() {
        System.out.println(num);

    }
}
