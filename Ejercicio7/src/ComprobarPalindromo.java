import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ComprobarPalindromo {
    private static String cadena = "";

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                
            cadena = br.readLine();
            if (cadena.length() > 0) {
                System.out.println(cadena + " palindromo? :" + palindromo(cadena));

            } else
                System.out.println("cadena vacia");

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static boolean palindromo(String cadena) {

        cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
                .replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");

        String invertida = new StringBuilder(cadena).reverse().toString();

        return invertida.equals(cadena);
    }
}
