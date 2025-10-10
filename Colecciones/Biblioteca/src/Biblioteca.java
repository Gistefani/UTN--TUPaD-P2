
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;

    
    public Biblioteca() {
        this.libros = new ArrayList<>();}

    
    public void agregarLibros(Libro e) {
        
        this.libros.add(e);
    }
    
    public void listarLibros(){
        for (Libro l : libros) {
            
            System.out.println(l);
            
        }
    }
        
    public Libro buscarLibro(String isbn) {
    for (Libro libro : libros) {
        if (libro.getIsbn().equals(isbn)) {
            return libro; // devuelve el libro encontrado inmediatamente
        }
    }
    return null;
           
        
    }   
    
    public Libro eliminarLibro(String isnb){
        Libro libBorrar = buscarLibro(isnb);
        this.libros.remove(libBorrar);
        return libBorrar;
      
    }
      
    public int contarLibros() {
    
    return libros.size();
     
    }
    
  
    public ArrayList<Libro> filtrarPorAnio(int anioPublicacion) {
    ArrayList<Libro> filtrados = new ArrayList<>();

    for (Libro l : libros) {
        if (l.getAnioPublicacion()== anioPublicacion) {
            filtrados.add(l);
        }
    }

    return filtrados;
    }
    public void listarAutores() {
        for (Libro libro : libros) {
            System.out.println("- " + libro.getAutor().getNombre());
        }
    }
}

    
    
    




/*



 
• mostrarAutoresDisponibles()*/