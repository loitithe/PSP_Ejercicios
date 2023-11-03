import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "Hijo", cadena);
        File directorio = new File("Ejercicio4\\bin");
        pb.directory(directorio);
        Process p = pb.start();
        InputStreamReader in = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(in);

        BufferedReader brError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        String linea;
        while ((linea = brError.readLine()) != null) {
            System.out.println(linea);
        }

        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    }
}
