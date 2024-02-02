package ProgramacionMultihilo.ejercicio7;

public class Main {
    public static void main(String[] args) {
        /*
         * 7. Se trata de simular el juego para adivinar un número. Se crearán varios
         * hilos, que actuarán como los
         * jugadores que tienen que adivinar el número. Habrá un árbitro que generará el
         * número a adivinar,
         * comprobará la jugada del jugador y averiguará a qué jugador le toca jugar. El
         * número tiene que estar
         * comprendido entre 1 y 10.
         * Por lo tanto, existirán 3 clases:
         * • Árbitro: Contiene el número a adivinar, el turno y muestra el resultado. Se
         * definen los
         * siguientes atributos: número total de jugadores, turno, número a adivinar y
         * si el juego acabó
         * o no. En el constructor se recibe el número de jugadores, y se inicializan el
         * número y el turno.
         * Tendrá métodos para consultar el turno, si el juego ha acabado o no y otro
         * que compruebe
         * la jugada del jugador y averigüe a qué jugador le toca a continuación. Este
         * último método
         * recibirá el ID del jugador y el número que ha jugado. También se indicará si
         * el juego ha
         * finalizado porque el jugador ha acertado el número.
         * • Jugador: Su constructor recibe un ID de jugador y el árbitro. Lo que harán
         * los jugadores será
         * comprobar si es su turno, en ese caso, generará un número entre 1 y 10 y
         * creará la jugada.
         * Este proceso se repetirá hasta que el juego acabe.
         * • Principal: Inicializa el árbitro y lanza los hilos.
         */
    }
}
