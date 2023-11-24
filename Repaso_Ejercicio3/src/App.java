import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        String argumento = "-1";
        ProcessBuilder pb = new ProcessBuilder("java", "Hijo", argumento);
        File directorio = new File(".\\bin");
        File fichero = new File(".\\repaso3.txt");

        File fichero2 = new File(".\\repaso3_b.txt");

        pb.directory(directorio);

        try {
            Process p = pb.start();
            InputStream in = p.getErrorStream();
            int lectura;
            int wait = p.waitFor();

            try (FileWriter fw = new FileWriter(fichero, true);
                    FileWriter fw2 = new FileWriter(fichero2, true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                fw.write("argumento :" + argumento + " valor:" + String.valueOf(wait) + "\r");
                fw.flush();
                fw2.write("argumento :" + argumento + " valor:" + br.readLine() + "\r");
                fw2.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(wait);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
