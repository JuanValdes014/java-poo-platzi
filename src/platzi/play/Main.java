package platzi.play;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenContenido;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main{
  public static final String NOMBRE_PLATAFORMA = "Platzi play!";
  public static final String VERSION = "1.0.0";

  public static final int AGREGAR = 1;
  public static final int MOSTRAR_TODO = 2;
  public static final int BUSCAR_POR_TITULO = 3;
  public static final int BUSCAR_POR_GENERO = 4;
  public static final int VER_POPULARES = 5;
  public static final int REPRODUCIR = 6;
  public static final int ELIMINAR = 8;
  public static final int SALIR = 9;

  public static void main(String[] args){
      Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

      System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

      // Precargamos peliculas de prueba
      cargarPeliculas(plataforma);

      //
      System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de contenido.");

      while (true) {
          int opcionElegida = ScannerUtils.CapturarNumero("""
                  Ingrese una de las siguientes opciones: 
                  1. Agregar contenido
                  2. Mostrar todo
                  3. Buscar por titulo
                  4. Buscar por genero
                  5. Ver populares
                  6. Reproducir
                  8. Eliminar
                  9. Salir
                  """);

          System.out.println("Opción elegida: " + opcionElegida);

          switch (opcionElegida) {
              case AGREGAR -> {
                  String nombre = ScannerUtils.CapturarTexto("Nombre del contenido");
                  Genero genero = ScannerUtils.CapturarGenero("Genero del contenido");
                  int duracion = ScannerUtils.CapturarNumero("Duracion del contenido");
                  double calificacion = ScannerUtils.CapturarDecimal("Calificacion del contenido");

                  try {
                      // Insertamos registro
                      plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                  }catch (Exception e){
                      System.out.println(e.getMessage());
                  }
              }
              case MOSTRAR_TODO -> {
                  List<ResumenContenido> contenidosResumidos = plataforma.getResumenes();
                  contenidosResumidos.forEach(resumen -> System.out.println(resumen.toString()));
              }
              case BUSCAR_POR_TITULO -> {
                  String nombreBuscado = ScannerUtils.CapturarTexto("Nombre del contenido a buscar");
                  Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                  if(pelicula != null){
                      System.out.println(pelicula.obtenerFichaTecnica());
                  } else {
                      System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                  }
              }
              case BUSCAR_POR_GENERO -> {
                  Genero nombreGeneroBuscado = ScannerUtils.CapturarGenero("Genero del contenido");
                  List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(nombreGeneroBuscado);
                  System.out.println(contenidoPorGenero.size() + " encontrados para el genero: " + nombreGeneroBuscado);
                  contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
              }
              case VER_POPULARES -> {
                  int cantidad = ScannerUtils.CapturarNumero("Cantidad de resultados a mostrar: ");
                  // Filtramos por cantidad
                  List<Pelicula> contenidoPopulares = plataforma.getPopulares(cantidad);

                  contenidoPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
              }
              case REPRODUCIR -> {
                  String nombre = ScannerUtils.CapturarTexto("Nombre del contenido a reproducir");

                  Pelicula contenido = plataforma.buscarPorTitulo(nombre);

                  if(contenido != null){
                      plataforma.reproducir(contenido);
                  } else {
                      System.out.println(nombre + " no existe dentro de " + plataforma.getNombre());
                  }
              }
              case ELIMINAR -> {
                  String nombreAEliminar = ScannerUtils.CapturarTexto("Nombre del contenido a eliminar");
                  Pelicula pelicula = plataforma.buscarPorTitulo(nombreAEliminar);

                  if(pelicula != null){
                      plataforma.eliminar(pelicula);
                      System.out.println(nombreAEliminar + " eliminado exitosamente");
                  } else {
                      System.out.println(nombreAEliminar + " no existe dentro de " + plataforma.getNombre());
                  }
              }
              case SALIR -> System.exit(0);
          }
      }
  }

  private static void cargarPeliculas(Plataforma plataforma) {
    plataforma.getContenido().addAll(FileUtils.leerContenido());
  }
}
