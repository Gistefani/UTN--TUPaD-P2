/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Paciente;
import java.util.List;
import Dao.PacienteDAO;

/**
 *
 * @author Asus
 */
public class PacienteServiceImpl implements GenericService<Paciente>{
    
    
    
     private final PacienteDAO pacienteDAO;
    private final HistoriaClinicaServiceImpl historiaClinicaService;
    
    // Constructor con inyección de dependencias
    public PacienteServiceImpl(PacienteDAO pacienteDAO, HistoriaClinicaServiceImpl historiaClinicaService) {
        if (pacienteDAO == null) {
            throw new IllegalArgumentException("PacienteDAO no puede ser null");
        }
        if (historiaClinicaService == null) {
            throw new IllegalArgumentException("HistoriaClinicaService no puede ser null");
        }

        this.pacienteDAO = pacienteDAO;
        this.historiaClinicaService = historiaClinicaService;
    }

    // Getter necesario para MenuHandler
    public HistoriaClinicaServiceImpl getHistoriaClinicaService() {
        return historiaClinicaService;
    }

    @Override
    public void insertar(Paciente paciente) throws Exception {
       validatePaciente(paciente);
        pacienteDAO.insertar(paciente);
    }

    @Override
    public void actualizar(Paciente paciente) throws Exception {
         validatePaciente(paciente);
         
         if (paciente.getId() <= 0) {
            throw new IllegalArgumentException("El ID del paciente debe ser mayor a 0 para actualizar.");
        }

        pacienteDAO.actualizar(paciente);
         
    }

    @Override
    public void eliminar(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0 para eliminar.");
        }

        pacienteDAO.eliminar(id);
    }

    @Override
    public Paciente getById(int id) throws Exception {
       if (id <=0){
          throw new UnsupportedOperationException("el id debe ser mayor a 10"); 
       }return pacienteDAO.getById(id);
    }

    @Override
    public List<Paciente> getAll() throws Exception {
        return pacienteDAO.getAll();
    }
  private void validatePaciente (Paciente paciente){
   if (paciente == null){
          throw new IllegalArgumentException("El paciente no puede ser null");
        }
        if (paciente.getNombre() == null || paciente.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del paciente es obligatorio");
        }
        if (paciente.getApellido() == null || paciente.getApellido().isBlank()) {
            throw new IllegalArgumentException("El apellido del paciente es obligatorio");
        }
        if (paciente.getDni() == null || paciente.getDni().isBlank()) {
            throw new IllegalArgumentException("El DNI del paciente es obligatorio");
        }
    }
   
   
   
   }
  
  
    
    

