package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static String CapturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return scanner.nextLine();
    }

    public static int CapturarNumero(String mensaje) {
        System.out.println(mensaje + ": ");

        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;
    }

    public static double CapturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        double dato = scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }


}
