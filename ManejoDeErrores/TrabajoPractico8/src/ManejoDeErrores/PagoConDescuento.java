/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ManejoDeErrores;

import ManejoDeErrores.Pago;

/**
 *
 * @author Asus
 */
public interface PagoConDescuento extends Pago{
    
    double aplicarDescuento(double monto);
    
}
