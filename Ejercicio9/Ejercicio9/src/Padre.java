import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Padre {
    public static void main(String[] args) {
        /**
         * Proceso padre:
         * Tiene que lanzar al hijo y enviarle a través de la memoria el color que
         * eligamos.
         * El juego finaliza cuando acertamos.
         */
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("java", "Hijo");
        pb.directory(new File(".\\bin\\"));
        try {
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintStream ps = new PrintStream(p.getOutputStream());
            String mensaje = "";
            while ((mensaje = br.readLine()) != null) {
                if (mensaje.contains("Acertaste!")) {
                    System.out.println(mensaje);
                    System.exit(1);
                } else {
                    System.out.println(mensaje);
                    ps.println(sc.nextLine());
                    ps.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
