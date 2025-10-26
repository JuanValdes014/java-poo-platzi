package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;

import java.util.Scanner;

public class Main{
  public static void main(String[] args){
      System.out.println("Platzi play! ");

      // Instanciamos objeto
      Pelicula pelicula = new Pelicula();
      pelicula.titulo = "El señor de los anillos";
      pelicula.anioEstreno = 2001;
      pelicula.genero = "Fantasía";

      // Generamos calificación
      pelicula.calificar(4.7);

      // Instanciamos objeto de usuario
      Usuario usuario = new Usuario();
      usuario.nombre = "Juan";
      usuario.email = "cliente@sincorreo.com";

      // Imprimimos
      usuario.ver(pelicula);
      //Scanner scanner = new Scanner(System.in);
      //System.out.println("Cual es tu nombre?: ");
      //String nombre = scanner.nextLine();

      //System.out.println("Hola "  + nombre + ", esto es una prueba de platzi play");

      //System.out.println("Cuantos años tienes?:");

      //Integer edad = scanner.nextInt();

      //System.out.println(nombre + " puedes ver contenido +" + edad);
  }
}
