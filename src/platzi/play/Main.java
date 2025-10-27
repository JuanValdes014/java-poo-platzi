package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main{
  public static final String NOMBRE_PLATAFORMA = "Platzi play!";
  public static final String VERSION = "1.0.0";

  public static void main(String[] args){
      Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

      System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

      String nombre = ScannerUtils.CapturarTexto("Nombre del contenido");
      String genero = ScannerUtils.CapturarTexto("Genero del contenido");
      int duracion = ScannerUtils.CapturarNumero("Duracion del contenido");
      double calificacion = ScannerUtils.CapturarDecimal("Calificacion del contenido");

      // Instanciamos objeto
      Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);
      Pelicula pelicula2 = new Pelicula("F1 the movie", 223, "Acción");

      plataforma.agregar(pelicula);
      plataforma.agregar(pelicula2);

      System.out.println("Número de elementos en la plataforma " + plataforma.getContenido().size() + "\n");

      // Imprimimos ficha tecnica
      System.out.println(pelicula.obtenerFichaTecnica());

      plataforma.eliminar(pelicula2);

      plataforma.mostrarTitulos();

      // Instanciamos objeto de usuario
      Usuario usuario = new Usuario("Juan", "cliente@sincorreo.com");

      usuario.fechaRegistro = LocalDateTime.of(2025,12,11,17,15, 12);

      // Imprimimos
      usuario.ver(pelicula);
  }
}
