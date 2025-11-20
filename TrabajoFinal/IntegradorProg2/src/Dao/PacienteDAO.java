/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.List;
import java.util.ArrayList;
import Config.DatabaseConnection;
import Models.Paciente;
import Models.HistoriaClinica;
import java.sql.*;
import java.util.*;
import java.sql.Statement;

/**
 *
 * @author Asus
 */
//Gestiona todas las operaciones de persistencia de personas en la base de datos.
//DAO concreto para la entidad Paciente.
//Gestiona operaciones CRUD y búsquedas sobre la tabla `paciente`.
public class PacienteDAO implements GenericDAO<Paciente>{
    
   /** Inserta un nuevo paciente.*/
    private static final String INSERT_SQL =
            "INSERT INTO paciente (nombre, apellido, dni, fecha_nacimiento, eliminado) " +
            "VALUES (?, ?, ?, ?, ?)";
    
    /** Actualiza datos de un paciente (sin tocar eliminado). */
    private static final String UPDATE_SQL =
    "UPDATE paciente SET nombre=?, apellido=?, dni=?, fecha_nacimiento=? " +
    "WHERE id=?";
    
    /** Soft delete: marca eliminado=TRUE. */
    private static final String DELETE_SQL =
            "UPDATE paciente SET eliminado=TRUE WHERE id=?";
    
     /** Obtiene un paciente por su ID (incluye JOIN con historia_clinica). */
    private static final String SELECT_BY_ID_SQL =
    "SELECT p.*, h.id AS hc_id, h.nro_historia, h.grupo_sanguineo, " +
    "h.antecedentes, h.medicacion_actual, h.observaciones " +
    "FROM paciente p " +
    "LEFT JOIN historia_clinica h ON p.id = h.paciente_id " +
    "WHERE p.id = ? AND p.eliminado = FALSE";
    
    /** Lista todos los pacientes activos con sus historias clínicas (si existen). */
    private static final String SELECT_ALL_SQL =
    "SELECT p.*, h.id AS hc_id, h.nro_historia, h.grupo_sanguineo, " +
    "h.antecedentes, h.medicacion_actual, h.observaciones " +
    "FROM paciente p " +
    "LEFT JOIN historia_clinica h ON p.id = h.paciente_id " +
    "WHERE p.eliminado = FALSE";
    
   //constructor  para que al agregar al paciente se cree una historia clinica y si se elimina se elimine 
   private final HistoriaClinicaDAO historiaClinicaDAO;

    public PacienteDAO(HistoriaClinicaDAO historiaClinicaDAO) {
        if (historiaClinicaDAO == null) {
            throw new IllegalArgumentException("HistoriaClinicaDAO no puede ser null");
        }
        this.historiaClinicaDAO = historiaClinicaDAO;
    }
    
    // Inserta un paciente (versión sin transacción).
    
    @Override
public void insertar(Paciente paciente) throws Exception {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {

        conn = DatabaseConnection.getConnection();
        conn.setAutoCommit(false); // INICIA TRANSACCIÓN

        stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, paciente.getNombre());
        stmt.setString(2, paciente.getApellido());
        stmt.setString(3, paciente.getDni());

        if (paciente.getFechaNacimiento() != null)
            stmt.setDate(4, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
        else
            stmt.setNull(4, Types.DATE);

        stmt.setBoolean(5, paciente.isEliminado());

        stmt.executeUpdate();
        setGeneratedId(stmt, paciente);

        // Insertar historia clínica si existe
        if (paciente.getHistoriaClinica() != null) {
            HistoriaClinica hc = paciente.getHistoriaClinica();
            hc.setPaciente(paciente);
            historiaClinicaDAO.insertTx(hc, conn);
        }

        conn.commit(); // ❇️ Todo OK

    } catch (Exception ex) {

        if (conn != null) conn.rollback(); // ❗ Revertir

        throw ex;

    } finally {

        if (stmt != null) stmt.close();

        if (conn != null) {
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}
    
    //Inserta un paciente usando una conexión externa (para transacciones).
    @Override
    public void insertTx(Paciente paciente, Connection conn) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getDni());

            if (paciente.getFechaNacimiento() != null)
                 stmt.setDate(4, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
            else
                stmt.setNull(4, Types.DATE);

            stmt.setBoolean(5, paciente.isEliminado());

            stmt.executeUpdate();
            setGeneratedId(stmt, paciente);
        }
        if (paciente.getHistoriaClinica() != null) {
            HistoriaClinica hc = paciente.getHistoriaClinica();
            hc.setPaciente(paciente);
            historiaClinicaDAO.insertTx(hc, conn);
        }
    }
    
    
    //Actualizar
    @Override
    public void actualizar(Paciente paciente) throws Exception {
        try (Connection conn= DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getDni());
            
            if (paciente.getFechaNacimiento() != null)
                stmt.setDate(4, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
            
            else
                stmt.setNull(4, Types.DATE);
            
            
            
            stmt.setInt(5, paciente.getId());

            

            
            stmt.executeUpdate();
        }
    }
    
    
   
    //eliminar
   
       @Override
       public void eliminar(int id) throws Exception {
        try (Connection conn= DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)){
        
        stmt.setInt(1,id);
        int rowAffected = stmt.executeUpdate();
        
        if(rowAffected == 0){
            throw new SQLException("No se encontro la persona con ID: "+ id);
        }
        }
                   
       
       }

    @Override
public Paciente getById(int id) throws Exception {
    Paciente paciente = null;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setDni(rs.getString("dni"));
                paciente.setEliminado(rs.getBoolean("eliminado"));

                // --- FECHA DE NACIMIENTO (controla NULL) ---
                java.sql.Date fechaSql = rs.getDate("fecha_nacimiento");
                if (fechaSql != null) {
                    paciente.setFechaNacimiento(fechaSql.toLocalDate());
                } else {
                    paciente.setFechaNacimiento(null);
                }

                // --- Historia clínica si existe ---
                int hcId = rs.getInt("hc_id");

                if (!rs.wasNull()) { // mejor que comparar != 0

                    HistoriaClinica hc = new HistoriaClinica();
                    hc.setId(hcId);

                    // ENUM (si no es null)
                    String grupo = rs.getString("grupo_sanguineo");
                    if (grupo != null) {
                        hc.setGrupoSanguineo(
                            Enum.valueOf(Models.GrupoSanguineo.class, grupo)
                        );
                    }

                    hc.setAntecedentes(rs.getString("antecedentes"));
                    hc.setMedicacionActual(rs.getString("medicacion_actual"));
                    hc.setObservaciones(rs.getString("observaciones"));

                    paciente.setHistoriaClinica(hc);
                }
            }
        }
    }

    return paciente;
}
   @Override
public List<Paciente> getAll() throws Exception {
    List<Paciente> pacientes = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Paciente p = new Paciente();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setDni(rs.getString("dni"));

            // 🟢 Manejo seguro de fecha
            java.sql.Date fechaSql = rs.getDate("fecha_nacimiento");
            p.setFechaNacimiento(
                    fechaSql != null ? fechaSql.toLocalDate() : null
            );

            p.setEliminado(rs.getBoolean("eliminado"));
            
            HistoriaClinica hc = historiaClinicaDAO.getByPacienteId(p.getId());
            p.setHistoriaClinica(hc);
            
            pacientes.add(p);
        }
    }

    return pacientes;
}
private void setPacienteParameters(PreparedStatement stmt, Paciente paciente) throws SQLException {
    stmt.setString(1, paciente.getNombre());
    stmt.setString(2, paciente.getApellido());
    stmt.setString(3, paciente.getDni());

    if (paciente.getFechaNacimiento() != null)
        stmt.setDate(4, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
    else
        stmt.setNull(4, java.sql.Types.DATE);

    stmt.setBoolean(5, paciente.isEliminado());

    if (paciente.getHistoriaClinica() != null)
        stmt.setLong(6, paciente.getHistoriaClinica().getId());
    else
        stmt.setNull(6, java.sql.Types.BIGINT);
} 
private void setGeneratedId(PreparedStatement stmt, Paciente paciente) throws SQLException {
    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
           paciente.setId((int) generatedKeys.getLong(1)); // usa el setter heredado de Base
        } else {
            throw new SQLException("No se generó un ID para el paciente.");
        }
    }
}      

    
}
