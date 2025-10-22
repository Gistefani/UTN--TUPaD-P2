package EjercicioDos;

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

   
    public static void main(String[] args) {
 
        
        ArrayList<Figura> figuras = new ArrayList<>();
        
        figuras.add(new Circulo(5, "Circulo 1"));
        figuras.add(new Circulo(10, "Circulo 2"));
        figuras.add(new Rectangulo(10.0, 6.0, "Rectangulo 1"));
        figuras.add(new Rectangulo(12.0, 6.0, "Rectangulo 2"));
        
        
        
        for(Figura f : figuras){
            f.calcularArea();
        }
        
    }
    
}
    
    

