import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) {
        String cad = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (!cad.equals("*")) {
                cad = br.readLine();
                System.out.println(cad);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
