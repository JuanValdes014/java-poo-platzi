package platzi.play.contenido;

public class Documental extends Contenido {
    private String narrador;

    public Documental(String titulo, int duracion, Genero genero) {
        super(titulo, duracion, genero);
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo documental " + this.getTitulo() + " narrado por " + this.getNarrador() + "...");
    }

    public Documental(String titulo, int duracion, Genero genero, double calificacion, String narrador) {
        super(titulo, duracion, genero, calificacion);
        this.narrador = narrador;
    }

    public String getNarrador() {
        return narrador;
    }
}
