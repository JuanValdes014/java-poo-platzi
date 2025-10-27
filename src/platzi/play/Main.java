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

  public static final int AGREGAR = 1;
  public static final int MOSTRAR_TODO = 2;
  public static final int BUSCAR_POR_TITULO = 3;
  public static final int ELIMINAR = 4;
  public static final int SALIR = 5;

  public static void main(String[] args){
      Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

      System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

      while (true) {
          int opcionElegida = ScannerUtils.CapturarNumero("""
                  Ingrese una de las siguientes opciones: 
                  1. Agregar contenido
                  2. Mostrar todo
                  3. Buscar por titulo
                  4. Eliminar
                  5. Salir
                  """);

          System.out.println("Opción elegida: " + opcionElegida);

          switch (opcionElegida) {
              case AGREGAR -> {
                  String nombre = ScannerUtils.CapturarTexto("Nombre del contenido");
                  String genero = ScannerUtils.CapturarTexto("Genero del contenido");
                  int duracion = ScannerUtils.CapturarNumero("Duracion del contenido");
                  double calificacion = ScannerUtils.CapturarDecimal("Calificacion del contenido");

                  // Insertamos registro
                  plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
              }
              case MOSTRAR_TODO -> plataforma.mostrarTitulos();
              case BUSCAR_POR_TITULO -> {
                  // Falta
              }
              case ELIMINAR -> {
                  // Falta
              }
              case SALIR -> System.exit(0);
          }
      }
//
//      String nombre = ScannerUtils.CapturarTexto("Nombre del contenido");
//      String genero = ScannerUtils.CapturarTexto("Genero del contenido");
//      int duracion = ScannerUtils.CapturarNumero("Duracion del contenido");
//      double calificacion = ScannerUtils.CapturarDecimal("Calificacion del contenido");
//
//      // Instanciamos objeto
//      Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);
//      Pelicula pelicula2 = new Pelicula("F1 the movie", 223, "Acción");
//
//      plataforma.agregar(pelicula);
//      plataforma.agregar(pelicula2);
//
//      System.out.println("Número de elementos en la plataforma " + plataforma.getContenido().size() + "\n");
//
//      // Imprimimos ficha tecnica
//      System.out.println(pelicula.obtenerFichaTecnica());
//
//      plataforma.eliminar(pelicula2);
//
//      plataforma.mostrarTitulos();
//
//      // Instanciamos objeto de usuario
//      Usuario usuario = new Usuario("Juan", "cliente@sincorreo.com");
//
//      usuario.fechaRegistro = LocalDateTime.of(2025,12,11,17,15, 12);
//
//      // Imprimimos
//      usuario.ver(pelicula);
  }
}
