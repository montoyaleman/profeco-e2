package DAOs;

import Entidades.Empresa;
import java.sql.*;
import java.util.*;

/**
 * Clase de acceso a datos para la entidad Empresa.
 * Proporciona métodos para realizar operaciones CRUD (Create, Read, Update, Delete)
 * sobre la tabla Empresa en la base de datos.
 */
public class EmpresaDAO {

    /**
     * Obtiene una lista de todas las empresas almacenadas en la base de datos.
     *
     * @return Lista de objetos Empresa.
     */
    public List<Empresa> obtenerEmpresas() {
        List<Empresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empresa";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empresa e = new Empresa();
                e.setIdEmpresa(rs.getInt("idEmpresa"));
                e.setNombre(rs.getString("nombre"));
                e.setTipoNegocio(rs.getString("tipoNegocio"));
                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Obtiene una empresa específica de la base de datos por su ID.
     *
     * @param id El ID de la empresa a buscar.
     * @return Objeto Empresa si se encuentra, de lo contrario null.
     */
    public Empresa obtenerEmpresaPorId(int id) {
        Empresa empresa = null;
        String sql = "SELECT * FROM Empresa WHERE idEmpresa = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    empresa = new Empresa();
                    empresa.setIdEmpresa(rs.getInt("idEmpresa"));
                    empresa.setNombre(rs.getString("nombre"));
                    empresa.setTipoNegocio(rs.getString("tipoNegocio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    /**
     * Crea una nueva empresa en la base de datos.
     *
     * @param empresa El objeto Empresa a crear.
     */
    public void crearEmpresa(Empresa empresa) {
        String sql = "INSERT INTO Empresa (nombre, tipoNegocio) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empresa.getNombre());
            pstmt.setString(2, empresa.getTipoNegocio());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza una empresa existente en la base de datos.
     *
     * @param empresa El objeto Empresa con los datos actualizados.
     */
    public void actualizarEmpresa(Empresa empresa) {
        String sql = "UPDATE Empresa SET nombre = ?, tipoNegocio = ? WHERE idEmpresa = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empresa.getNombre());
            pstmt.setString(2, empresa.getTipoNegocio());
            pstmt.setInt(3, empresa.getIdEmpresa());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una empresa de la base de datos por su ID.
     *
     * @param id El ID de la empresa a eliminar.
     */
    public void eliminarEmpresa(int id) {
        String sql = "DELETE FROM Empresa WHERE idEmpresa = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
