package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner SCANNER = new Scanner(System.in);

    public static String CapturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return SCANNER.nextLine();
    }

    public static int CapturarNumero(String mensaje) {
        System.out.println(mensaje + ": ");

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;
    }

    public static double CapturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;
    }


}
