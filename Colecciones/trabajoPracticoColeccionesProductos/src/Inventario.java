
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Inventario {
    
    private ArrayList<Producto> productos;
    
    public Inventario() {
        this.productos = new ArrayList<>();}
    
    
    public void agregarProducto(Producto p) {
        
        this.productos.add(p);
        
    
    }
    public void listarProductos(){
        for (Producto p : productos) {
            
            System.out.println(p);
            
        }
    }
    public Producto buscarProducto(String ID) {
        int i = 0;
        Producto prodEncontrado = null;
        while (i < productos.size() && !this.productos.get(i).getID().equals(ID)) {
            i++;
        }
        if (i < productos.size()) {
            prodEncontrado = this.productos.get(i);
        }
        return prodEncontrado;
           
    }
    
    
    public Producto eliminarProducto(String ID){
        Producto prodABorrar = buscarProducto(ID);
        this.productos.remove(prodABorrar);
        return prodABorrar;
      
    }
    
    public Producto actualizarStock(String ID, int nuevaCantidad){
     Producto prod = buscarProducto(ID);
      if (prod != null){
          System.out.println("producto encontrado: " + prod.getNombre()+" Nueva cantidad :" + nuevaCantidad );         
      }else{
          System.out.println("Producto no encontrado");
      }return prod;

    }
     
    public int calcularStockTotal() {
     int total = 0;
      for (Producto p : productos) {
          total += p.getCantidad(); 
     } System.out.println("El total de productos es: "+ total);
    return total;
     
    }
  public int obtenerProductoConMayorStock(){
   Producto ProdMax = null;
        int cantMax = -1;//lo inicializo en -1 porque  no pueden tener km negativos entronces el 1  ya me va a sumar.
        for (Producto producto : productos) {
            if (producto.getCantidad()> cantMax) {
                cantMax= producto.getCantidad();// para cambiar el valor a este nuevo valor 
                // y como no solo quiero dar el valor maximo y tambien quiero dar cual auto es el que lo tiene hago 
                ProdMax = producto;
  }  
        }System.out.println("el producto con mayor stock es: " + ProdMax);
        return cantMax;
  } 
    

public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
    ArrayList<Producto> filtrados = new ArrayList<>();

    for (Producto p : productos) {
        if (p.getCategoria() == categoria) {
            filtrados.add(p);
        }
    }

    return filtrados;
}
public void filtrarProductosPorPrecio(double min, double max){
    boolean encontrado = false;

    System.out.println("Productos con precio entre " + min + " y " + max + ":");
    for (Producto p : productos) {
        if (p.getPrecio() >= min && p.getPrecio() <= max) {
            System.out.println(p.getNombre() + " | Precio: $" + p.getPrecio());
            encontrado = true;
        }}
        if (!encontrado) {
        System.out.println("No se encontraron productos en ese rango de precio.");
    }
    
    

} 
public void mostrarCategoriasDisponibles() {
    System.out.println("Categorías disponibles:");
    for (CategoriaProducto categoria : CategoriaProducto.values()) {
        System.out.println("- " + categoria);
    }
}
}


 
    

