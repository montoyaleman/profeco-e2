package DAOs;

import Entidades.Reporte;
import java.sql.*;
import java.util.*;

public class ReporteDAO {

    // Método para obtener todos los reportes (Read)
    public List<Reporte> obtenerReportes() {
        List<Reporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reporte";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reporte r = new Reporte();
                r.setIdReporte(rs.getInt("idReporte"));
                r.setFechaCreacion(rs.getDate("fechaCreacion"));
                r.setIdEmpresa(rs.getInt("idEmpresa"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setEstado(rs.getString("estado"));
                lista.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para obtener un reporte por ID (Read)
    public Reporte obtenerReportePorId(int id) {
        Reporte reporte = null;
        String sql = "SELECT * FROM Reporte WHERE idReporte = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    reporte = new Reporte();
                    reporte.setIdReporte(rs.getInt("idReporte"));
                    reporte.setFechaCreacion(rs.getDate("fechaCreacion"));
                    reporte.setIdEmpresa(rs.getInt("idEmpresa"));
                    reporte.setIdUsuario(rs.getInt("idUsuario"));
                    reporte.setDescripcion(rs.getString("descripcion"));
                    reporte.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporte;
    }

    // Método para crear un nuevo reporte (Create)
    public void crearReporte(Reporte reporte) {
        String sql = "INSERT INTO Reporte (fechaCreacion, idEmpresa, idUsuario, descripcion, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(reporte.getFechaCreacion().getTime()));
            pstmt.setInt(2, reporte.getIdEmpresa());
            pstmt.setInt(3, reporte.getIdUsuario());
            pstmt.setString(4, reporte.getDescripcion());
            pstmt.setString(5, reporte.getEstado());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un reporte (Update)
    public void actualizarReporte(Reporte reporte) {
        String sql = "UPDATE Reporte SET fechaCreacion = ?, idEmpresa = ?, idUsuario = ?, descripcion = ?, estado = ? WHERE idReporte = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(reporte.getFechaCreacion().getTime()));
            pstmt.setInt(2, reporte.getIdEmpresa());
            pstmt.setInt(3, reporte.getIdUsuario());
            pstmt.setString(4, reporte.getDescripcion());
            pstmt.setString(5, reporte.getEstado());
            pstmt.setInt(6, reporte.getIdReporte());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un reporte (Delete)
    public void eliminarReporte(int id) {
        String sql = "DELETE FROM Reporte WHERE idReporte = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
