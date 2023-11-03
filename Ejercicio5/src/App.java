import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una cadena a guardar en un fichero");
        String cadena = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "Hijo", cadena);
        pb.directory(new File("Ejercicio5\\bin"));
        Process p = pb.start();
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida :" + exitVal);
            switch (exitVal) {
                case 0:
                    System.out.println("Final correcto");
                    break;
                case 1:
                    System.out.println("Final inccorecto");
                    break;
                default:
                    break;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream("fichero.txt");
                PrintWriter pw = new PrintWriter(fos);
                InputStream is = p.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            // escribir en el fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                pw.println(linea);
            }
        }

    }
}
