package ProgramacionMultihilo;

public class Contador {
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
