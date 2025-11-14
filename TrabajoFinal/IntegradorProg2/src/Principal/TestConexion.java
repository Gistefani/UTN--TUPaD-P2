/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.sql.Connection;
import Config.DatabaseConnection;
/**
 *
 * @author Asus
 */
public class TestConexion {
    public static void main(String[] args) {
    Connection conn = DatabaseConnection.getConnection();
         if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        } else {
            System.out.println("No se pudo conectar a la base.");
         }
    }
}
    
    

