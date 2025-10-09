/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Producto {
    
    private static int contador = 0;
    private String ID;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    
    
    public Producto (String nombre,double precio, int cantidad,CategoriaProducto categoria){
        
        contador++; 
        this.ID = "P" + contador;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        
    }

    public String getID() {
        return ID;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    

    @Override
    public String toString() {
        return "Producto{" + "ID=" + ID + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", categoria=" + categoria + '}';
    }
    
    
    
            
}
