package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        int x =10 , y, z;
        System.out.println("ingrese y : ");
        
        try{
           y = new Scanner(System.in).nextInt();
           z = x /y;
            System.out.println("Resultado: "+ z);
        
        }
        catch(InputMismatchException ime){
            System.out.println("No es un entero");
            
        }
        catch(ArithmeticException ae){
            System.out.println("No se puede dividir por cero");
            
        }
        catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
            e.printStackTrace();
            
        }
        
        System.out.println("Finalizado");
        
        
    }
    
}
