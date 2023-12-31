
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {
    /**
     * Proceso vigilante.
     * Crea un proceso llamado ProcesoEscritor que escriba cada 500 milisegundos en
     * un archivo llamado log.txt. Puede escribir 3 mensajes.
     * • 1: Todo está OK con un 60% de probabilidad
     * • 2: ERROR: se ha dectacto un problema con un 30% de probabilidad
     * • 3: END con un 10% de probabilidad
     * El proceso finaliza cuando escribe END
     * Por otro lado, crea un proceso que vigile el archivo de texto log.txt. Cada
     * 500
     * milisegundos leerá el archivo, y si encuentra la palabra ERROR hará un print
     * del error. El proceso finalizará cuando se lea la palabra END.
     * Por otro lado, habrá un proceso padre que levantará el proceso escritor,
     * esperará a que
     * finalice. Después levantará el proceso vigilante y recogerá la información en
     * caso de que la haya. Por cada línea que escriba el proceso hijo será un error
     * detectado, así que
     * nuestro proceso padre creará un contador de errores y al final escribirá el
     * número de errores en un fichero llamado errors.txt.
     * Cuando el proceso hijo finalice, el padre deberá hacer lo mismo.
     * NOTA: Cuando se lance el proceso Escritor, creará el log.txt en el
     * pb.directory() que se le haya asignado.
     * 
     * @param args
     */
    public static void main(String[] args) {
        ProcessBuilder pbEscritor = new ProcessBuilder("java", "ProcesoEscritor");
        ProcessBuilder pbLector = new ProcessBuilder("java", "ProcesoLector");
        pbEscritor.directory(new File("Ejercicio8/bin"));
        pbLector.directory(new File("Ejercicio8/bin"));
        String linea = "";

        try {

            Process pEscritor = pbEscritor.start();
            System.out.println("" + pEscritor.waitFor());
            Process pLector = pbLector.start();
            System.out.println("" + pLector.waitFor());
            BufferedReader brError = new BufferedReader(new InputStreamReader(pEscritor.getErrorStream()));
            while ((linea = brError.readLine()) != null) {
                System.out.println(linea);
            }
            try (FileWriter fw = new FileWriter(new File("errors.txt"), true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(pLector.getInputStream()));) {
                do {
                    System.out.println(linea);
                    fw.write(linea + "\r");
                } while ((linea = br.readLine()) != null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
