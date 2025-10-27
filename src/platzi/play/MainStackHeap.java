package platzi.play;

import platzi.play.contenido.Pelicula;

public class MainStackHeap {
    public static void main(String[] args) {
        Pelicula reyLeon = new Pelicula("Rey leon", 135, "Animada");
        Pelicula harryPotter = new Pelicula("Harry Potter", 225, "Fantasia");

        System.out.println("reyLeon: " + reyLeon.titulo);
        System.out.println("harryPotter: " + harryPotter.titulo);
    }
}
