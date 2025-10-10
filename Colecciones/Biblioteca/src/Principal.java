
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Biblioteca a = new Biblioteca();
        
        a.agregarLibros(new Libro("Antes del fin",1998,new Autor("Ernesto Sabato","Argentino")));
        a.agregarLibros(new Libro("El tunel",1948,new Autor("Ernesto Sabato","Argentino")));
        a.agregarLibros(new Libro("Agilmente",2012,new Autor("Estanislao Bachrach","Argentino")));
        a.agregarLibros(new Libro("The sand",1978,new Autor("Stephen Edwin king","Estadounidense")));
        a.agregarLibros(new Libro("IT",1986,new Autor("Stephen Edwin king","Estadounidense")));
        a.agregarLibros(new Libro("El resplandor",1977,new Autor("Stephen Edwin king","Estadounidense")));
        a.agregarLibros(new Libro("El pasillo de la muerte",1996,new Autor("Stephen Edwin king","Estadounidense")));
        a.agregarLibros(new Libro("Carrie",1974,new Autor("Stephen Edwin king","Estadounidense")));
        
    System.out.println("=== LISTADO DE LIBROS ===");
    a.listarLibros();
    
    System.out.println("=== BUSCAR UN LIBROS ===");
    
     Libro encontrado = a.buscarLibro("L1");

     if (encontrado != null) {
         System.out.println(" PRODUCTOS ENCONTRADO ");
         System.out.println(encontrado);
     } else {
      System.out.println("No se encontró el producto con Isbn: " + "L1");
     }
    
    System.out.println("=== BUSCAR LIBROS POR AÑOS  ===");
    
    ArrayList<Libro> filtrados = a.filtrarPorAnio(1977);

       if (filtrados.isEmpty()) {
           System.out.println("No hay libros publicados este año");
      } else {
        for (Libro l : filtrados) {
            System.out.println(l);
        }
    }
       System.out.println("=== PRODUCTOS ELIMINADO ===");
    Libro eliminarLibro = a.eliminarLibro("L8");

     if (eliminarLibro != null) {
         System.out.println("=== PRODUCTOS ELIMINADO ===");
         a.listarLibros();
     } else {
      System.out.println("No se encontró el libro con ISNB " + "L8");
     }
    
    System.out.println("=== MOSTRAR EL TOTAL DE LIBROS  ===");
    
    System.out.println("la cantidad de libros en la biblioteca es: "+ a.contarLibros());
    
    
    System.out.println("=== MOSTRAR LOS AUTORES  ==="); 
     
    a.listarAutores();
    }
    
    
    
    
    
    
    
}
