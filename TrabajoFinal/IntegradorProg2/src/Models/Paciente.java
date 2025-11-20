/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class Paciente extends Base{
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private HistoriaClinica historiaClinica;
    
    
    
    
//constructor vacio
  public Paciente(){
     super();
}


//constructor completo
public Paciente(int id, boolean eliminado, String nombre, String apellido,
                    String dni, LocalDate fechaNacimiento, HistoriaClinica historiaClinica) {
        super(id,eliminado);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.historiaClinica = historiaClinica;
   
    
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
    
   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{id=").append(getId())
          .append(", nombre='").append(nombre).append('\'')
          .append(", apellido='").append(apellido).append('\'')
          .append(", dni='").append(dni).append('\'');

        if (fechaNacimiento != null) {
            sb.append(", fechaNacimiento=").append(fechaNacimiento);
        }

        if (historiaClinica != null) {
            sb.append(",").append(historiaClinica.toString());
        }

        sb.append('}');
        return sb.toString();
    }
}
    
    





