import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.portable.InputStream;

public class Hijo {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (args.length>0) {
            for (int i = 0; i < 5; i++) {
                System.out.println(args[0]);
            }
        }
    }
}
