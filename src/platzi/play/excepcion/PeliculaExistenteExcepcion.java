package platzi.play.excepcion;

public class PeliculaExistenteExcepcion extends RuntimeException {
    public PeliculaExistenteExcepcion(String titulo) {
        super("La pelicula " +  titulo + " existe en el sistema.");
    }
}
