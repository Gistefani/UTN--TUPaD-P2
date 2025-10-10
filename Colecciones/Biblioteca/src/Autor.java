/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Autor {
    private static int contador = 0;
    private String ID;
    private String nombre;
    private String nacionalidad;
    
    public Autor(String nombre,String nacionalidad){
    
         contador++; 
        this.ID = "A" + contador;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        
    
    }

    public String getNombre() {
        return nombre;
    }
    
    

    @Override
    public String toString() {
        return "Autor{" + "ID=" + ID + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
}
