/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public enum CategoriaProducto {
    ALIMENTOS("productos comestibles"),
    ELECTRONICA ("Dispositivos electrónicos"),
    ROPA ("Prendas de vestir"),
    HOGAR ("Artículos para el hogar");
    
private final String descripcion;
         CategoriaProducto(String descripcion) {
          this.descripcion = descripcion;
       }
 
         
public String getDescripcion() {
return descripcion;
 } 
    
    
    
}
