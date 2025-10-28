package platzi.play.util;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Genero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "contenido.txt";
    public static final String SEPARADOR = "|";

    public static void escribirContenido(Contenido contenido) {
        String linea = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                String.valueOf(contenido.getCalificacion()),
                contenido.getFechaEstreno().toString()
        );

        String lineaFinal;
        if(contenido instanceof Documental documental) {
            lineaFinal = "DOCUMENTAL" + SEPARADOR + linea + SEPARADOR + documental.getNarrador();
        } else {
            lineaFinal = "PELICULA" +  SEPARADOR + linea;
        }
        try {
           // Guardamos
           Files.writeString(Paths.get(NOMBRE_ARCHIVO),
                   linea + System.lineSeparator(),
                   StandardOpenOption.CREATE,
                   StandardOpenOption.APPEND);
       }
       catch (IOException e) {
           System.out.println("Error al escribir el archivo. "  + e.getMessage());
       }
    }

    public static List<Contenido> leerContenido() {
        List<Contenido> contenidoDesdeArchivo = new ArrayList<>();
        try {
            System.out.println("Inicio lectura TXT carga peliculas");
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            System.out.println("Fin lectura de TXT carga peliculas");

            System.out.println("Total de lineas detectadas: " + lineas.size());

            lineas.forEach(line -> {
                String[] datos = line.split("\\" + SEPARADOR);

                String tipoContenido = datos[0];

                if(("PELICULA".equals(tipoContenido) && datos.length == 6) || ("DOCUMENTAL".equals(tipoContenido) && datos.length == 7) ){
                    String titulo = datos[1];
                    int duracion =  Integer.parseInt(datos[2]);
                    Genero genero = Genero.valueOf(datos[3]);
                    double calificacion = datos[4].isBlank() ? 0 : Double.parseDouble(datos[4]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[5]);

                    Contenido contenido;

                    if("PELICULA".equals(tipoContenido)){
                        contenido = new Contenido(titulo, duracion, genero, calificacion);
                    } else {
                        String narrador = datos[6];
                        contenido = new Documental(titulo, duracion, genero, calificacion, narrador);
                    }

                    contenido.setFechaEstreno(fechaEstreno);

                    contenidoDesdeArchivo.add(contenido);
                }

            });
        }
        catch (IOException e) {
            System.out.println("Error leyendo el archivo. "  + e.getMessage() );
        }
        finally {
            return contenidoDesdeArchivo;
        }
    }
}
