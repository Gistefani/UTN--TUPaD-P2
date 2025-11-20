
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
        
        Inventario e = new Inventario();
        
        e.agregarProducto(new Producto("mouse",6000,24,CategoriaProducto.ELECTRONICA));
        e.agregarProducto(new Producto("mesa",35000,8,CategoriaProducto.HOGAR));
        e.agregarProducto(new Producto("harina",900,240,CategoriaProducto.ALIMENTOS));
        e.agregarProducto(new Producto("remera",3000,50,CategoriaProducto.ROPA));
        e.agregarProducto(new Producto("parlante",300000,40,CategoriaProducto.ELECTRONICA));
        
        System.out.println("=== LISTADO DE PRODUCTOS ===");
        e.listarProductos();
       
        
        e.buscarProducto("P01");
      
      
       Producto encontrado = e.buscarProducto("P3");

     if (encontrado != null) {
         System.out.println("=== PRODUCTOS ENCONTRADO ===");
         System.out.println(encontrado);
     } else {
      System.out.println("No se encontró el producto con ID: " + "P3");
     }
      
      
     System.out.println("=== PRODUCTOS DE CATEGORÍA ELECTRÓNICA ===");

     ArrayList<Producto> filtrados = e.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);

       if (filtrados.isEmpty()) {
           System.out.println("No hay productos en esta categoría.");
      } else {
        for (Producto p : filtrados) {
            System.out.println(p);
        }
    }
   //System.out.println("=== ELIMINAR UN PRODUCTO ===");
   
    
   // Producto eliminarProd = e.eliminarProducto("P2");

     //if (eliminarProd != null) {
       //  System.out.println("=== PRODUCTOS ELIMINADO ===");
        // e.listarProductos();
     //} else {
     // System.out.println("No se encontró el producto con ID: " + "P2");
     //}
    System.out.println("=== ACTUALIZAR EL STOCK  ===");   
    
    e.actualizarStock("P1", 32);
    
     System.out.println("=== MOSTRAR EL TOTAL DE STOCK  ==="); 
     
     e.calcularStockTotal();
     
     System.out.println("=== MOSTRAR EL PRODUCTO CON MAS STOCK  ==="); 
     
     e.obtenerProductoConMayorStock();
     
      System.out.println("=== FILTRAR POR PRECIO  ==="); 
      
     e.filtrarProductosPorPrecio(1000, 3000);
    
     System.out.println("=== MOSTRAR LAS CATEGORIAS  ==="); 
     
     e.mostrarCategoriasDisponibles();
    }
   
        
    }
    

