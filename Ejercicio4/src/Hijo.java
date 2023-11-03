import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        if (args.length > 0) {
            for (int i = 0; i < 5; i++) {
                System.out.println(args[0] + " : " + i + 1);
            }
        }

    }
}
