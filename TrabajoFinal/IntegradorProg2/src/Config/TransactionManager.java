/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.SQLException; 

/**
 *
 * @author Asus
 * 
 * //Clase auxiliar para manejar transacciones manuales en la base de datos.
 * Compatible con DatabaseConnection y los DAO de tu proyecto.
 */
public class TransactionManager implements AutoCloseable{
    
    private final Connection connection;
    private boolean transactionActive;
    
    //Crea un TransactionManager usando una conexión existente.

    public TransactionManager(Connection connection) throws SQLException {
        if (connection == null) {
            throw new IllegalArgumentException("La conexión no puede ser null.");
        }
        this.connection = connection;
        this.transactionActive = false;
    }
    
    
    //Crea un TransactionManager con una nueva conexión de DatabaseConnection.
     
    public static TransactionManager create() throws SQLException {
        return new TransactionManager(DatabaseConnection.getConnection());
    }

    public Connection getConnection() {
        return connection;
    }

     // Inicia una transacción manual.
     
    public void begin() throws SQLException {
        if (connection.isClosed()) {
            throw new SQLException("No se puede iniciar la transacción: la conexión está cerrada.");
        }
        connection.setAutoCommit(false);
        transactionActive = true;
    }
    
     
     //Confirma (commit) la transacción activa.
     
    public void commit() throws SQLException {
        if (!transactionActive) {
            throw new SQLException("No hay una transacción activa para confirmar.");
        }
        connection.commit();
        transactionActive = false;
        connection.setAutoCommit(true);
    }
    
    
     //Revierte los cambios (rollback) de la transacción activa.
     
    public void rollback() {
        if (transactionActive) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.err.println("⚠ Error durante rollback: " + e.getMessage());
            } finally {
                transactionActive = false;
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ignored) {}
            }
        }
    }
    //Cierra la conexión y asegura que la transacción haya sido finalizada.
     
    @Override
    public void close() {
        try {
            if (transactionActive) {
                rollback();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("⚠ Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public boolean isTransactionActive() {
        return transactionActive;
    }

    
    
    
    
}
