import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Hijo {

    static Color[] colores = new Color[] { Color.BLUE, Color.GREEN, Color.RED, Color.MAGENTA, Color.BLACK, Color.WHITE,
            Color.PINK, Color.YELLOW, Color.ORANGE, Color.CYAN };
    static String[] coloresNombre = new String[] { "BLUE", "GREEN", "RED", "MAGENTA", "BLACK", "WHITE", "PINK",
            "YELLOW", "ORANGE", "CYAN" };
    static Color colorElegido;
    static Random rm;

    public static void main(String[] args) {
        rm = new Random();
        /**
         * Proceso hijo:
         * Tiene que tener declarados 10 colores y escoger uno de ellos aleatoriamente
         * cada vez que se ejecuta.
         * Recibe desde la entrada estandar eleciones de colores hasta que se acierte.
         * 
         */
        String color_elegido = coloresNombre[rm.nextInt(coloresNombre.length)];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mensaje;
        try {
            System.out.println("ADIVINA EL COLOR .\n No es el " + color_elegido);
            while ((mensaje = br.readLine()) != null)
                if (mensaje.toUpperCase().equals(color_elegido)) {
                    System.out.println(
                            "Acertaste! El color elegido era : " + color_elegido);
                    System.exit(1);
                } else
                    System.out.println("Has fallado! ");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
