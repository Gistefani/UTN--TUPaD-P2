/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.Scanner;
import Dao.PacienteDAO;
import Dao.HistoriaClinicaDAO;
import Service.HistoriaClinicaServiceImpl;
import Service.PacienteServiceImpl;

/**
 *
 * @author Asus
 */
public class AppMenu {
    
    //unico scaner para toda la aplicacion
    private final Scanner scanner;
    
    //Handler ejecuta operaciones de menu
    private final MenuHandler menuHandler;
    
    
    //flag que controla el loop principal del menu
    private boolean running;
    
    //constructor que inicializa la aplicacion
    
    public AppMenu(){
    
    this.scanner = new Scanner(System.in);
    
    PacienteServiceImpl pacienteService = createPacienteService();
    
    this.menuHandler = new MenuHandler (scanner, pacienteService);
    this.running = true;
    }
    //punto de entrada a la aplicacion Java
    public static void main (String[]args){
       AppMenu app = new AppMenu();
       app.run();
    }
    
    
    
    
    
    //Loop principal del menu
    
    public void run() {
        while (running) {
            try {
                MenuDisplay.mostrarMenuPrincipal();
                int opcion = Integer.parseInt(scanner.nextLine());
                processOption(opcion);

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, por favor ingrese un número.");
            }
        }

        scanner.close();
    }
    //procceso de la opcion y paso al menu handler.
    private void processOption(int opcion){
        switch (opcion) {
            case 1 -> menuHandler.crearPaciente();
            case 2 -> menuHandler.listarPacientes();
            case 3 -> menuHandler.actualizarPaciente();
            case 4 -> menuHandler.eliminarPaciente();
            case 5 -> menuHandler.listarHistoriaClinica();
            case 6 -> menuHandler.actualizarHistoriaClinicaPorId();
            case 7 -> menuHandler.eliminarHistoriaClinica();            
            case 0 -> {
                System.out.println("Saliendo...");
                running = false;
            }
            default -> System.out.println("Opcion no valida.");
        }
    }
    //crea la cadena de dependencia de servicios
    private PacienteServiceImpl createPacienteService() {
        HistoriaClinicaDAO historiaClinicaDAO = new HistoriaClinicaDAO();
        PacienteDAO pacienteDAO = new PacienteDAO(historiaClinicaDAO);
        HistoriaClinicaServiceImpl historiaClinicaService = new HistoriaClinicaServiceImpl(historiaClinicaDAO);
        return new PacienteServiceImpl(pacienteDAO, historiaClinicaService);
    }
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    

