import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProcesoLector {
    public static void main(String[] args) {
        System.out.println("proceso lector");
        File logFile = new File("log.txt");
        String linea;
        while (true) {
            try {

                BufferedReader br = new BufferedReader(new FileReader(logFile));
                while ((linea = br.readLine()).contains("END")) {
                    synchronized (logFile) {
                        logFile.wait(1000);
                    }
                    if (linea.contains("ERROR")) {
                        System.out.println("ERROR ENCONTRADO : " + linea);
                    }

                }
                br.close();

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
