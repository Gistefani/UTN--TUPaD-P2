/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.util.List;
import Dao.GenericDAO;
import Models.HistoriaClinica;


/**
 *
 * @author Asus
 */
public class HistoriaClinicaServiceImpl implements GenericService <HistoriaClinica> {
  
   private final GenericDAO <HistoriaClinica> historiaClinicaDAO;
   
   
   //constructor con inyeccion de dependencias
   
   public HistoriaClinicaServiceImpl (GenericDAO<HistoriaClinica> HistoriaClinicaDAO){
   
   if(HistoriaClinicaDAO == null){
   throw new IllegalArgumentException("HistoriaClinica No puede Ser null");
   
   
   }
   this.historiaClinicaDAO = HistoriaClinicaDAO;
   }
    
  //insertar nueva historia Clinica
   
   @Override
    public void insertar(HistoriaClinica historiaClinica) throws Exception {
        validateHistoriaClinica(historiaClinica);
        historiaClinicaDAO.insertar(historiaClinica); 
    }
   
  //Actualizar historia clinica si existe
   
   
   
   @Override
   public void actualizar (HistoriaClinica historiaClinica) throws Exception{
       
       validateHistoriaClinica(historiaClinica);
       if (historiaClinica.getId()<=0){
          throw new IllegalArgumentException("El ID de la hIstoria Clinica debe ser mayor a o para actualizar");
                  
       }
       historiaClinicaDAO.actualizar(historiaClinica);
   
   
   
   }
   //Eliminar 
   
     @Override
    public void eliminar(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID de la historia clínica debe ser mayor a 0 para eliminar.");
        }

        historiaClinicaDAO.eliminar(id);
    }
   
   
   
   

   //obtiene una Hisotoria Clinica por su ID
    @Override
    public HistoriaClinica getById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID de la historia clínica debe ser mayor a 0.");
        }

        return historiaClinicaDAO.getById(id);
    }
   //obtiene todas las historias clinicas
   @Override
   public List<HistoriaClinica> getAll()throws Exception{
   
   return historiaClinicaDAO.getAll();
   }
   
   
   //validacion
   private void validateHistoriaClinica(HistoriaClinica historiaClinica){
   
   if(historiaClinica == null){
        throw new IllegalArgumentException("La hIstoria Clinica no puede ser null");
   
   }
   
   
   
   }

    

    

    
   
   
   }

