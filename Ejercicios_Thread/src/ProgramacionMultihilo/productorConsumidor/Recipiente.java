package ProgramacionMultihilo.productorConsumidor;

public class Recipiente {

    private String contenido;
    private boolean lleno = false;

    /**
     * vaciar: es el método utilizado por los hilos consumidores. Si el recipiente
     * no está lleno, el
     * hilo se bloquea a la espera de que lo llene un hilo productor. Cuando le
     * notifican que está
     * lleno, salde del estado de bloqueo, indica que va a coger el contenido del
     * recipiente y lo va a
     * dejar vacío, y notifica que el recipiente está vacío a los procesos que
     * puedan estar
     * bloqueados esperando para llenarlo.
     * 
     * @return
     */
    public synchronized String vaciar() {
        while (!lleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo ... ");
            }
        }
        lleno = false;
        notifyAll();
        return contenido;
    }

    /**
     * es el método utilizado por los hilos productores. Si el recipiente está
     * lleno, se queda
     * bloqueado esperando la notificación de que se ha vaciado. Cuando se le
     * comunica este
     * evento y el recipiente está vacío, lo llena y notifica que está lleno a los
     * hilos que puedan
     * estar bloqueados a la espera de que se llenara.
     * 
     * @param valor
     */
    public synchronized void llenar(String valor) {
        while (lleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo ... ");
            }
        }
        contenido = valor;
        lleno = true;
        notifyAll();
    }

}
