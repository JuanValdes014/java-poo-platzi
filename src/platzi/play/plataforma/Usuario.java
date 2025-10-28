package platzi.play.plataforma;

import platzi.play.contenido.Contenido;

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

    public void ver(Contenido contenido) {
        System.out.println(nombre + " está viendo...");

        contenido.reproducir();
    }
}
