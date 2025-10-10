/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Libro {
    
    private static int contador = 0;
    private String isbn; //Identificador único del libro.

    
    private String titulo; // Título del libro.
    private int anioPublicacion; //Año de publicación.
    private Autor autor;  //Autor del libro.
    

    public Libro( String titulo, int anioPublicacion, Autor autor) {
        contador++;
        
        this.isbn = "L" + contador;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", anioPublicacion=" + anioPublicacion + ", autor=" + autor + '}';
    }
    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }
    
    
    
}
