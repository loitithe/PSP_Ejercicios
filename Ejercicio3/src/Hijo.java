public class Hijo {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.exit(1);
        }
        try {
            int arg = Integer.parseInt(args[0]);
            if (arg < 0) {
                System.exit(3);
            }

        } catch (NumberFormatException e) {
            System.exit(2);
        }

        System.exit(0);
    }
}
