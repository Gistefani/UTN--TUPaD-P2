package EjercicioUno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Auto extends Vehiculo {
    
    private int cantidadDePuertas;

  
    public Auto(int cantidadDePuertas, String marca, String modelo) {
        super(marca, modelo);
        this.cantidadDePuertas = cantidadDePuertas;
    }

   
    @Override
    public void mostrarInfo(){
        System.out.println("Modelo: " + this.modelo + " ,marca: " + this.marca + ", cantidad de puertas: " + cantidadDePuertas);
    }
    
    
    
    
    
    
}
