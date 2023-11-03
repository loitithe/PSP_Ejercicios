import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Padre {

    /**
     * Crea un programa Java que lea cadenas desde la entrada estándar hasta recibir
     * un *.
     * A continuación, crea un programa padre que ejecute el anterior. El programa
     * padre deberá enviarle las cadenas al hijo y también recoger los mensajes del
     * hijo.
     * Gestiona ambos programas para que al escribir “*” ambos finalicen. Asegurate
     * desde el
     * padre que el hijo ha finalizado correctamente
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        String lectura = "";
        ProcessBuilder pb = new ProcessBuilder("java", "Hijo");
        pb.directory(new File(".\\bin"));
        Process p = pb.start();
        PrintStream ps = new PrintStream(p.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        do {
            System.out.println("leyendo..." + lectura);
            cadena = recojeCadena(sc, p, ps);

        } while ((lectura = br.readLine()) != null && !lectura.equals("*"));

    }

    /**
     * Metodo para enviar cadenas al proceso
     * 
     * @param sc
     * @param p
     * @param ps
     */
    public static String recojeCadena(Scanner sc, Process p, PrintStream ps) {
        String cadena = "";
        System.out.println("Introduce cadena, * para salir");
        cadena = sc.nextLine();
        ps.println(cadena);
        ps.flush();
        return cadena;
    }
}
