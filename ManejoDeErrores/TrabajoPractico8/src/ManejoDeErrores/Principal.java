package ManejoDeErrores;



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
//        1. Crear una interfaz Pagable con el método calcularTotal().  
//2. Clase Producto: tiene nombre y precio, implementa Pagable.  
//3. Clase Pedido: tiene una lista de productos, implementa Pagable y calcula el 
//total del pedido.  
//4. Ampliar con interfaces Pago y PagoConDescuento para distintos medios de 
//pago (TarjetaCredito, PayPal), con métodos procesarPago(double) y 
//aplicarDescuento(double).  
//5. Crear una interfaz Notificable para notificar cambios de estado. La clase 
//Cliente implementa dicha interfaz y Pedido debe notificarlo al cambiar de 
//estado. 

      
   
     Cliente cliente = new Cliente("Pedro", "pedro@mail.com");
     Pedido pedido = new Pedido(cliente);
     
      pedido.agregarProducto(new Producto("Mouse", 5000));
      pedido.agregarProducto(new Producto("Teclado", 8000));
      
      System.out.println("Total del pedido: $" + pedido.calcularTotal());
      
      
      TarjetaCredito tarjeta = new TarjetaCredito();
        double totalConDescuento = tarjeta.aplicarDescuento(pedido.calcularTotal());
        tarjeta.procesarPago(totalConDescuento);

        pedido.cambiarEstado("Enviado");
    
    
    
    
    
    
    }
    
}
