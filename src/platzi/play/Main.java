package platzi.play;

import java.util.Scanner;

public class Main{
  public static void main(String[] args){
      System.out.println("Platzi play! ");

      Scanner scanner = new Scanner(System.in);
      System.out.println("Cual es tu nombre?: ");
      String nombre = scanner.nextLine();

      System.out.println("Hola "  + nombre + ", esto es una prueba de platzi play");

      System.out.println("Cuantos años tienes?:");

      Integer edad = scanner.nextInt();

      System.out.println(nombre + " puedes ver contenido +" + edad);
  }
}
