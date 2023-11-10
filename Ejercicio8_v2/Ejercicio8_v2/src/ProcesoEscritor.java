import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ProcesoEscritor {

    public static void main(String[] args) {
        int random = 0;
        String[] escrituras = new String[] { "OK", "ERROR", "END" };
        Object monitor = new Object();
        while (true) {
            random = new Random().nextInt(100);
            try {
                synchronized (monitor) {
                    monitor.wait(500);
                }
                FileWriter fw = new FileWriter(new File("log.txt"), true);
                System.out.println("numero generado :" + random);
                if (random < 60) {
                    fw.write(escrituras[1] + random);
                    System.out.println(escrituras[1]);
                } else if (random < 90) {
                    fw.write(escrituras[0] + random);
                    System.out.println(escrituras[0]);
                } else {
                    fw.write(escrituras[2] + random);
                    fw.write("\r");
                    fw.flush();
                    fw.close();
                    System.out.println(escrituras[2]);
                    System.exit(1);
                }
                fw.write("\r");
                fw.flush();
                fw.close();

            } catch (IOException | InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
