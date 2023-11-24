public class Hijo {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Tamaño args menor que 0");
            System.exit(1);
        }
        try {
            int arg = Integer.parseInt(args[0]);
            if (arg < 0) {

                System.out.println("Argumento menor que 0");
                System.exit(3);
            }
        } catch (Exception e) {
            System.out.println("Argumento es una cadena");
            System.exit(2);

        }

        System.out.println("Cualquier otra ");
        System.exit(0);
    }
}
