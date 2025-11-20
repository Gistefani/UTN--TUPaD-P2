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
import java.time.LocalDate;
import Dao.PacienteDAO;
import Service.HistoriaClinicaServiceImpl;


/**
Controlador de las opciones del Menu
 */
public class MenuHandler {
    private final Scanner scanner;
    private final PacienteServiceImpl pacienteService;
    private final HistoriaClinicaServiceImpl historiaClinicaService;
    private final PacienteDAO pacienteDAO;
    
    
    public MenuHandler(Scanner scanner,PacienteServiceImpl pacienteService,HistoriaClinicaServiceImpl historiaClinicaService,
                   PacienteDAO pacienteDAO){
    this.scanner = scanner;
    this.pacienteService  = pacienteService;
    this.historiaClinicaService = historiaClinicaService;
        this.pacienteDAO = pacienteDAO;
    }
    
    //Pacientes
    public void crearPaciente() {

    try {
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("DNI: ");
        String dni = scanner.nextLine();

        System.out.println("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaInput = scanner.nextLine();

        LocalDate fechaNacimiento = null;

        if (!fechaInput.isBlank()) {
            try {
                fechaNacimiento = LocalDate.parse(fechaInput);
            } catch (Exception e) {
                System.out.println("⚠ Formato inválido. Se guardará sin fecha.");
            }
        }

        Paciente p = new Paciente();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setFechaNacimiento(fechaNacimiento);
        p.setEliminado(false);

        // crear TAMBIÉN LA HISTORIA CLÍNICA 
        pacienteService.insertarConHistoria(p);

        System.out.println("Paciente registrado con historia clínica asignada.");

    } catch (Exception e) {
        System.out.println("Error al registrar el paciente: " + e.getMessage());
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
                 System.out.println("\n--- Historia Clínica ---");
                System.out.println("ID: " + hc.getId()
                    + ", Antecedentes: " + hc.getAntecedentes()
                    + ", Medicación actual: " + hc.getMedicacionActual()
                    +"Observaciones: " + hc.getObservaciones()                                );
                    
                
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
            
            System.out.print("Nuevas observaciones (actual: "
                + hc.getObservaciones() + ", Enter para mantener): ");
            String obs = scanner.nextLine().trim();
            if (!obs.isEmpty()) hc.setObservaciones(obs);

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
    
    public void agregarHistoriaClinicaAPaciente() {
    try {
        System.out.print("ID del paciente: ");
        int pacienteId = Integer.parseInt(scanner.nextLine());

        Paciente paciente = pacienteService.getById(pacienteId);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Verificar si ya tiene historia clínica
        if (paciente.getHistoriaClinica() != null) {
            System.out.println("Este paciente ya tiene una historia clínica asignada.");
            System.out.println("ID historia: " + paciente.getHistoriaClinica().getId());
            System.out.println("Antecedentes: " + paciente.getHistoriaClinica().getAntecedentes());
            System.out.println("Medicación actual: " + paciente.getHistoriaClinica().getMedicacionActual());
            System.out.println("Si desea modificar la historia existente, use la opción de actualizar historia clínica.");
            return;
        }

        // Crear nueva historia clínica
        HistoriaClinica hc = new HistoriaClinica();

        System.out.print("Nro historia: ");
        hc.setNroHistoria("HC-" + paciente.getId()); // sugerencia automática

        System.out.print("Antecedentes: ");
        hc.setAntecedentes(scanner.nextLine());

        System.out.print("Medicación actual: ");
        hc.setMedicacionActual(scanner.nextLine());

        System.out.print("Observaciones: ");
        hc.setObservaciones(scanner.nextLine());

        hc.setEliminado(false);
        hc.setPaciente(paciente); // asocia paciente con historia

        // Insertar en la base de datos
        historiaClinicaService.insertar(hc);

        // Asociar en memoria
        paciente.setHistoriaClinica(hc);

        // Actualizar paciente en BD si quieres guardar la relación (opcional)
        pacienteDAO.actualizar(paciente);

        System.out.println("Historia clínica creada y asociada correctamente.");

    } catch (Exception e) {
        System.err.println("Error al asociar historia clínica: " + e.getMessage());
    }
}

}
      

      
      
      
      
      
      
      
  

 
    

