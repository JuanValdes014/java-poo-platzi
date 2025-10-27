package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = LocalDateTime.now();
    }

    public  String nombre;
    public  String email;
    public LocalDateTime fechaRegistro;

    public void ver(Pelicula pelicula) {
        System.out.println(nombre + " está viendo...");

        pelicula.reproducir();
    }
}
