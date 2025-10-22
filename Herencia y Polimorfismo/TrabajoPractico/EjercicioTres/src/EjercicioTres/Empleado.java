/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioTres;

/**
 *
 * @author Asus
 */
public class Empleado {
    
    
    public double calcularSueldo(Empleado e) {
        if (e instanceof EmpleadoPlanta) {
            return 1500000.0;
        } else if (e instanceof EmpleadoTemporal) {
            return 950000.0;
        } else {
            return 0;
        }
    }
    
}
