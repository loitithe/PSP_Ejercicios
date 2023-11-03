import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "Hijo", "3");
        File directorio = new File(".\\bin");
        pb.directory(directorio);

        try {
            Process p = pb.start();

            InputStream in = p.getErrorStream();
            int lectura;
            while ((lectura = in.read()) != -1) {
                System.out.println((char) lectura);
            }
            int wait = p.waitFor();
            System.out.print(wait);
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
