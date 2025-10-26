package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
      System.out.println("Platzi play! ");

      // Instanciamos objeto
      Pelicula pelicula = new Pelicula();
      pelicula.titulo = "El señor de los anillos";
      pelicula.fechaEstreno = LocalDate.of(2018,10,15);
      pelicula.genero = "Fantasía";

      // Generamos calificación
      pelicula.calificar(4.7);

      // Imprimimos ficha tecnica
      System.out.println(pelicula.obtenerFichaTecnica());

      // Instanciamos objeto de usuario
      Usuario usuario = new Usuario();
      usuario.nombre = "Juan";
      usuario.email = "cliente@sincorreo.com";
      usuario.fechaRegistro = LocalDateTime.of(2025,12,11,17,15, 12);
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
