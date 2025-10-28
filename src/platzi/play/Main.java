package platzi.play;

import platzi.play.contenido.*;
import platzi.play.plataforma.Plataforma;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main{
  public static final String NOMBRE_PLATAFORMA = "Platzi play!";
  public static final String VERSION = "1.0.0";

  public static final int AGREGAR = 1;
  public static final int MOSTRAR_TODO = 2;
  public static final int BUSCAR_POR_TITULO = 3;
  public static final int BUSCAR_POR_GENERO = 4;
  public static final int VER_POPULARES = 5;
  public static final int REPRODUCIR = 6;
  public static final int BUSCAR_POR_TIPO = 7;
  public static final int ELIMINAR = 8;
  public static final int SALIR = 9;

  public static void main(String[] args){
      Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

      System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

      // Precargamos peliculas de prueba
      cargarPeliculas(plataforma);

      //
      System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de contenido.");

      plataforma.getContenidoPromocionable().forEach(promocionable -> System.out.println(promocionable.promocionar()));

      while (true) {
          int opcionElegida = ScannerUtils.CapturarNumero("""
                  Ingrese una de las siguientes opciones: 
                  1. Agregar contenido
                  2. Mostrar todo
                  3. Buscar por titulo
                  4. Buscar por genero
                  5. Ver populares
                  6. Reproducir
                  7. Buscar por tipo de contenido
                  8. Eliminar
                  9. Salir
                  """);

          System.out.println("Opción elegida: " + opcionElegida);

          switch (opcionElegida) {
              case AGREGAR -> {
                  int tipoContenido = ScannerUtils.CapturarNumero("Que tipo de contenido deseas agregar?. \n 1. Pelicula. \n 2. Documental.");
                  String nombre = ScannerUtils.CapturarTexto("Nombre del contenido");
                  Genero genero = ScannerUtils.CapturarGenero("Genero del contenido");
                  int duracion = ScannerUtils.CapturarNumero("Duracion del contenido");
                  double calificacion = ScannerUtils.CapturarDecimal("Calificacion del contenido");

                  try {
                      // Insertamos registro
                      if(tipoContenido == 1) {
                          plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                      } else {
                          String narrador = ScannerUtils.CapturarTexto("Narrador del documental");
                          plataforma.agregar(new Documental(nombre, duracion, genero, calificacion, narrador));
                      }

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
                  Contenido contenido = plataforma.buscarPorTitulo(nombreBuscado);

                  if(contenido != null){
                      System.out.println(contenido.obtenerFichaTecnica());
                  } else {
                      System.out.println(nombreBuscado + " no existe dentro de " + plataforma.getNombre());
                  }
              }
              case BUSCAR_POR_GENERO -> {
                  Genero nombreGeneroBuscado = ScannerUtils.CapturarGenero("Genero del contenido");
                  List<Contenido> contenidoPorGenero = plataforma.buscarPorGenero(nombreGeneroBuscado);
                  System.out.println(contenidoPorGenero.size() + " encontrados para el genero: " + nombreGeneroBuscado);
                  contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
              }
              case VER_POPULARES -> {
                  int cantidad = ScannerUtils.CapturarNumero("Cantidad de resultados a mostrar: ");
                  // Filtramos por cantidad
                  List<Contenido> contenidoPopulares = plataforma.getPopulares(cantidad);

                  contenidoPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
              }
              case REPRODUCIR -> {
                  String nombre = ScannerUtils.CapturarTexto("Nombre del contenido a reproducir");

                  Contenido contenido = plataforma.buscarPorTitulo(nombre);

                  if(contenido != null){
                      plataforma.reproducir(contenido);
                  } else {
                      System.out.println(nombre + " no existe dentro de " + plataforma.getNombre());
                  }
              }
              case BUSCAR_POR_TIPO -> {
                  int tipoDeContenido = ScannerUtils.CapturarNumero("Que tipo de contenido deseas agregar?. \n 1. Pelicula. \n 2. Documental.");

                  if(tipoDeContenido == 1) {
                      List<Pelicula> peliculas = plataforma.getPeliculas();
                      peliculas.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica() + "\n"));
                  } else {
                      List<Documental> documentales = plataforma.getDocumentales();
                      documentales.forEach(documental -> System.out.println(documental.obtenerFichaTecnica() + "\n"));
                  }
              }
              case ELIMINAR -> {
                  String nombreAEliminar = ScannerUtils.CapturarTexto("Nombre del contenido a eliminar");
                  Contenido contenido = plataforma.buscarPorTitulo(nombreAEliminar);

                  if(contenido != null){
                      plataforma.eliminar(contenido);
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
