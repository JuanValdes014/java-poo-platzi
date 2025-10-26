package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main{
  public static final String NOMBRE_PLATAFORMA = "Platzi play!";
  public static final String VERSION = "1.0.0";

  public static void main(String[] args){
      System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

      String nombre = ScannerUtils.CapturarTexto("Nombre del contenido");
      String genero = ScannerUtils.CapturarTexto("Genero del contenido");
      int duracion = ScannerUtils.CapturarNumero("Duracion del contenido");
      double calificacion = ScannerUtils.CapturarDecimal("Calificacion del contenido");

      // Instanciamos objeto
      Pelicula pelicula = new Pelicula();
      pelicula.titulo = nombre;
      pelicula.fechaEstreno = LocalDate.of(2018,10,15);
      pelicula.genero = genero;
      // Generamos calificación
      pelicula.calificar(calificacion);
      pelicula.duracion = duracion;


      // Imprimimos ficha tecnica
      System.out.println(pelicula.obtenerFichaTecnica());

      // Instanciamos objeto de usuario
      Usuario usuario = new Usuario();
      usuario.nombre = "Juan";
      usuario.email = "cliente@sincorreo.com";
      usuario.fechaRegistro = LocalDateTime.of(2025,12,11,17,15, 12);

      // Imprimimos
      usuario.ver(pelicula);
  }
}
