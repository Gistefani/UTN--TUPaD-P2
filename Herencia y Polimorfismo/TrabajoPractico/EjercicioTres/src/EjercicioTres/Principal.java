package EjercicioTres;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
public class Principal {

   
    public static void main(String[] args) {
       
        ArrayList<Empleado> empleados = new ArrayList<>();
               
        empleados.add(new EmpleadoPlanta());
        empleados.add(new EmpleadoTemporal());
         
        for(Empleado e : empleados) {
            System.out.println("El empleado "  + " cobra: " + e.calcularSueldo(e));
            
        }
    }
    
    }
    

