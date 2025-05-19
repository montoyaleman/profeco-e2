package DAOs;

import Entidades.Reporte;
import java.sql.*;
import java.util.*;

/**
 * Clase de acceso a datos para la entidad Reporte.
 * Proporciona métodos para realizar operaciones CRUD (Create, Read, Update, Delete)
 * sobre la tabla Reporte en la base de datos.
 */
public class ReporteDAO {

    /**
     * Obtiene una lista de todos los reportes almacenados en la base de datos.
     *
     * @return Lista de objetos Reporte.
     */
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

    /**
     * Obtiene un reporte específico de la base de datos por su ID.
     *
     * @param id El ID del reporte a buscar.
     * @return Objeto Reporte si se encuentra, de lo contrario null.
     */
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

    /**
     * Crea un nuevo reporte en la base de datos.
     *
     * @param reporte El objeto Reporte a crear.
     */
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

    /**
     * Actualiza un reporte existente en la base de datos.
     *
     * @param reporte El objeto Reporte con los datos actualizados.
     */
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

    /**
     * Elimina un reporte de la base de datos por su ID.
     *
     * @param id El ID del reporte a eliminar.
     */
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
