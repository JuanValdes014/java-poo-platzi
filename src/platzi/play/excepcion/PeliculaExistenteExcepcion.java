package platzi.play.excepcion;

public class PeliculaExistenteExcepcion extends RuntimeException {
    public PeliculaExistenteExcepcion(String titulo) {
        super("El contenido " +  titulo + " existe en el sistema.");
    }
}
