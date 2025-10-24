/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeErrores;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Pedido implements Pagable{
    
    ArrayList<Producto> productos = new ArrayList<>();
    private String estado;
    private Cliente cliente;
    
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "Pendiente";
    }
    
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    
    
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        cliente.notificar("El pedido cambió de estado a: " + nuevoEstado);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }
    }

    

