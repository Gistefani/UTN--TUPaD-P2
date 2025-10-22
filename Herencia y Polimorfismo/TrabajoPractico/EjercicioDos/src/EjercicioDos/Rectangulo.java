/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDos;

/**
 *
 * @author Asus
 */
public class Rectangulo extends Figura {
    // Creamos los atributos base y altura
    private double base;
    private double altura;

    // Creamos el constructos
    public Rectangulo(double base, double altura, String nombre) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }
    
    // Sobreescribimos al metodo calcular area
    @Override
    public void calcularArea(){
        System.out.println("El area del rectangulo " + nombre + " es: " +  (base * altura));
    }
    
}
