package platzi.play.util;

import platzi.play.contenido.Contenido;
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

                if(datos.length == 5){
                    String titulo = datos[0];
                    int duracion =  Integer.parseInt(datos[1]);
                    Genero genero = Genero.valueOf(datos[2]);
                    double calificacion = datos[3].isBlank() ? 0 : Double.parseDouble(datos[3]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[4]);

                    Contenido contenido = new Contenido(titulo, duracion, genero, calificacion);
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
