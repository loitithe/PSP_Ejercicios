import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Realiza un programa Java que lea una cadena desde la entrada estándar y
 * visualice en pantalla si la cadena es o no palíndromo o si la cadena está
 * vacía (longitud = 0) Realiza un segundo programa Java que ejecute el
 * anterior, debe leer la cadena desde teclado y mostrar la salida por pantalla.
 */
public class Padre {
    public static void main(String[] args) throws Exception {
    
        ProcessBuilder pb = new ProcessBuilder("java", "ComprobarPalindromo");
        Scanner sc = new Scanner(System.in);
        pb.directory(new File(".\\bin"));
        Process p = pb.start();
        String lectura = "";
        String cadena = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        PrintStream ps = new PrintStream(p.getOutputStream());
        cadena = recojeCadena(sc, p, ps);
        System.out.println("leyendo..." + br.readLine());

    }

    private static String recojeCadena(Scanner sc, Process p, PrintStream ps) {
        String cadena = "";
        System.out.println("Introduce una cadena :");
        cadena = sc.nextLine();
        ps.println(cadena);
        ps.flush();
        return cadena;
    }
}
