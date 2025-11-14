/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Asus
 * Proporcionar campos comunes a todas las entidades (id, eliminado)
 */
public abstract class Base {
       private int id;
       private boolean eliminado;
         
//Constructor completo con todos los campos.
        protected Base(int id, boolean eliminado) {
        this.id = id;
        this.eliminado = eliminado;
         }
 //Constructor por defecto.       
         protected Base() {
        this.eliminado = false;
    }
//Obtiene el ID de la entidad.         
         public int getId() {
        return id;
    }
//Establece el ID de la entidad.         
        public void setId(int id) {
        this.id = id;
          }
//Verifica si la entidad está marcada como eliminada.        
        public boolean isEliminado() {
        return eliminado;
    }
 //Marca o desmarca la entidad como eliminada.
 // En el contexto del soft delete, esto se usa para "eliminar" sin borrar físicamente.
     
        public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }    

}
