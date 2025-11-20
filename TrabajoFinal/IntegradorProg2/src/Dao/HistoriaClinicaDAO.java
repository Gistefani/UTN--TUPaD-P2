/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Config.DatabaseConnection;
import Models.HistoriaClinica;
import Models.GrupoSanguineo;
import Models.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class HistoriaClinicaDAO implements GenericDAO <HistoriaClinica>{
    
    
    private static final String INSERT_SQL = """
    INSERT INTO historia_clinica
    (nro_historia, grupo_sanguineo, antecedentes, medicacion_actual, observaciones, eliminado, paciente_id)
    VALUES (?, ?, ?, ?, ?, ?, ?)
""";

    private static final String UPDATE_SQL = """
    UPDATE historia_clinica
    SET antecedentes = ?, medicacion_actual = ?, observaciones = ?
    WHERE id = ?
""";

    private static final String DELETE_SQL = """
        UPDATE historia_clinica SET eliminado = TRUE WHERE id = ?
    """;

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM historia_clinica WHERE id = ? AND eliminado = FALSE
    """;

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM historia_clinica WHERE eliminado = FALSE
    """;

   

    @Override
    public void insertar(HistoriaClinica hc) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            setHistoriaClinicaParameters(stmt, hc);
            stmt.executeUpdate();
            setGeneratedId(stmt, hc);
        }
    }

    @Override
    public void insertTx(HistoriaClinica hc, Connection conn) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setHistoriaClinicaParameters(stmt, hc);
            stmt.executeUpdate();
            setGeneratedId(stmt, hc);
        }
    }

    @Override
    public void actualizar(HistoriaClinica hc) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {

       
            stmt.setString(1, hc.getAntecedentes());
            stmt.setString(2, hc.getMedicacionActual());
            stmt.setString(3, hc.getObservaciones());
            stmt.setLong(4, hc.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public HistoriaClinica getById(int id) throws Exception {
        HistoriaClinica hc = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hc = mapHistoriaClinica(rs);
                }
            }
        }
        return hc;
    }

    @Override
    public List<HistoriaClinica> getAll() throws Exception {
        List<HistoriaClinica> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapHistoriaClinica(rs));
            }
        }
        return list;
    }

 

    private void setHistoriaClinicaParameters(PreparedStatement stmt, HistoriaClinica hc) throws SQLException {
        stmt.setString(1, hc.getNroHistoria());
        stmt.setString(2, hc.getGrupoSanguineo() != null ? hc.getGrupoSanguineo().name() : null);
        stmt.setString(3, hc.getAntecedentes());
        stmt.setString(4, hc.getMedicacionActual());
        stmt.setString(5, hc.getObservaciones());
        stmt.setBoolean(6, hc.isEliminado());
        stmt.setInt(7, hc.getPaciente().getId());
    }

    private void setGeneratedId(PreparedStatement stmt, HistoriaClinica hc) throws SQLException {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                hc.setId(rs.getInt(1));
            }
        }
    }

    private HistoriaClinica mapHistoriaClinica(ResultSet rs) throws SQLException {
        HistoriaClinica hc = new HistoriaClinica();
        
        hc.setId(rs.getInt("id"));
        hc.setNroHistoria(rs.getString("nro_historia"));

        String grupo = rs.getString("grupo_sanguineo");
        if (grupo != null) {
            if (grupo.endsWith("+")) {
            grupo = grupo.replace("+", "_POSITIVO");
        } else if (grupo.endsWith("-")) {
            grupo = grupo.replace("-", "_NEGATIVO");
        }

        hc.setGrupoSanguineo(GrupoSanguineo.valueOf(grupo));    
            
        }

        hc.setAntecedentes(rs.getString("antecedentes"));
        hc.setMedicacionActual(rs.getString("medicacion_actual"));
        hc.setObservaciones(rs.getString("observaciones"));
        hc.setEliminado(rs.getBoolean("eliminado"));
        
        int idPaciente = rs.getInt("paciente_id");
         if (!rs.wasNull()) {
        Paciente p = new Paciente();
        p.setId(idPaciente);
        hc.setPaciente(p);} 
         else {
        hc.setPaciente(null);
    }
        return hc;
    }
    
    public HistoriaClinica getByPacienteId(int pacienteId) throws Exception {
    String sql = "SELECT * FROM historia_clinica WHERE paciente_id = ? AND eliminado = FALSE";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, pacienteId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return mapHistoriaClinica(rs);  // usa tu método existente
            }
        }
    }
    return null; // si no tiene historia clínica
}
    
}
