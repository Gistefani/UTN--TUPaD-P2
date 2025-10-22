/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDos;

/**
 *
 * @author Asus
 */
public class Circulo extends Figura {
   
    private double radio;

    
    public Circulo(double radio, String nombre) {
        super(nombre);
        this.radio = radio;
    }
   
    
    
    @Override
    public void calcularArea(){
        System.out.println("El area del cirulo " + nombre + " es: " +  (radio *  3.14));
    }
    
}
