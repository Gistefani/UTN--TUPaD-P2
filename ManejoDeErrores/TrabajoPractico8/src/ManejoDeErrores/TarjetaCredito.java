/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeErrores;

/**
 *
 * @author Asus
 */
public class TarjetaCredito implements PagoConDescuento {

    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.90;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago de $" + monto + " procesado con Tarjeta de Crédito.");
    }
    
}
