/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.List;
import java.util.Scanner;
import Models.Paciente;
import Models.HistoriaClinica;
import Service.PacienteServiceImpl;

/**
Controlador de las opciones del Menu
 */
public class MenuHandler {
    private final Scanner scanner;
    private final PacienteServiceImpl pacienteService;
    
    
    public MenuHandler(Scanner scanner,PacienteServiceImpl pacienteService){
    this.scanner = scanner;
    this.pacienteService  = pacienteService;
    }
    
    //Pacientes
    public void crearPaciente(){
    
     try{
        
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("DNI: ");
        String dni = scanner.nextLine();
        
        Paciente p = new Paciente();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setEliminado(false);
        
        pacienteService.insertar(p);
         System.out.println("Paciente Registrado Correctamente.!");
    }catch(Exception e){
         System.out.println("Error al registrar el paciente: "+e.getMessage());
    }
    
    }
    public void listarPacientes(){
      try{
          List<Paciente> pacientes = pacienteService.getAll();
          pacientes.forEach(System.out::println);
      }catch(Exception e){
         System.out.println("Error al listar el paciente: "+ e.getMessage());
    
    }
    } 
   public void actualizarPaciente() {
        try {
            System.out.print("ID del paciente a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            Paciente p = pacienteService.getById(id);
            if (p == null) {
                System.out.println("Paciente no encontrado.");
                return;
            }

            System.out.print("Nuevo nombre (actual: " + p.getNombre() + ", Enter para mantener): ");
            String nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty()) p.setNombre(nombre);

            System.out.print("Nuevo apellido (actual: " + p.getApellido() + ", Enter para mantener): ");
            String apellido = scanner.nextLine().trim();
            if (!apellido.isEmpty()) p.setApellido(apellido);

            System.out.print("Nuevo DNI (actual: " + p.getDni() + ", Enter para mantener): ");
            String dni = scanner.nextLine().trim();
            if (!dni.isEmpty()) p.setDni(dni);

            pacienteService.actualizar(p);
            System.out.println("Paciente actualizado correctamente.");

        } catch (Exception e) {
            System.err.println("Error al actualizar paciente: " + e.getMessage());
        }
    }
//Eliminar paciente con soft delete.
   public void eliminarPaciente() {
        try {
            System.out.print("ID del paciente a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            pacienteService.eliminar(id);
            System.out.println("Paciente eliminado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar paciente: " + e.getMessage());
        }
    }

//listar las historias clinicas activas
   
   public void listarHistoriaClinica() {
        try {
            List<HistoriaClinica> historial =
                pacienteService.getHistoriaClinicaService().getAll();

            if (historial.isEmpty()) {
                System.out.println("No se encontraron historias clínicas.");
                return;
            }

            for (HistoriaClinica hc : historial) {
                System.out.println("ID: " + hc.getId()
                    + ", Antecedentes: " + hc.getAntecedentes()
                    + ", Medicación actual: " + hc.getMedicacionActual());
            }

        } catch (Exception e) {
            System.err.println("Error al listar historias clínicas: " + e.getMessage());
        }
    }
  public void actualizarHistoriaClinicaPorId() {
        try {
            System.out.print("ID de historia clínica a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            HistoriaClinica hc =
                pacienteService.getHistoriaClinicaService().getById(id);

            if (hc == null) {
                System.out.println("Historia clínica no encontrada.");
                return;
            }

            System.out.print("Nuevo antecedente (actual: "
                    + hc.getAntecedentes() + ", Enter para mantener): ");
            String ant = scanner.nextLine().trim();
            if (!ant.isEmpty()) hc.setAntecedentes(ant);

            System.out.print("Nueva medicación (actual: "
                    + hc.getMedicacionActual() + ", Enter para mantener): ");
            String med = scanner.nextLine().trim();
            if (!med.isEmpty()) hc.setMedicacionActual(med);

            pacienteService.getHistoriaClinicaService().actualizar(hc);
            System.out.println("Historia clínica actualizada correctamente.");

        } catch (Exception e) {
            System.err.println("Error al actualizar historia clínica: " + e.getMessage());
        }
    }

    public void eliminarHistoriaClinica() {
        try {
            System.out.print("ID de historia clínica a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            pacienteService.getHistoriaClinicaService().eliminar(id);
            System.out.println("Historia clínica eliminada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar historia clínica: " + e.getMessage());
        }
    }

}
      

      
      
      
      
      
      
      
  

 
    

