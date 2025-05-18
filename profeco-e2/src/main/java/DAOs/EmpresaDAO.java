package DAOs;

import Entidades.Empresa;
import java.sql.*;
import java.util.*;

public class EmpresaDAO {

    // Método para obtener todas las empresas (Read)
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
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setTipoNegocio(rs.getString("tipoNegocio"));
                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para obtener una empresa por ID (Read)
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
                    empresa.setEmail(rs.getString("email"));
                    empresa.setPassword(rs.getString("password"));
                    empresa.setTipoNegocio(rs.getString("tipoNegocio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    // Método para crear una nueva empresa (Create)
    public void crearEmpresa(Empresa empresa) {
        String sql = "INSERT INTO Empresa (nombre, email, password, tipoNegocio) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empresa.getNombre());
            pstmt.setString(2, empresa.getEmail());
            pstmt.setString(3, empresa.getPassword());
            pstmt.setString(4, empresa.getTipoNegocio());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una empresa (Update)
    public void actualizarEmpresa(Empresa empresa) {
        String sql = "UPDATE Empresa SET nombre = ?, email = ?, password = ?, tipoNegocio = ? WHERE idEmpresa = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empresa.getNombre());
            pstmt.setString(2, empresa.getEmail());
            pstmt.setString(3, empresa.getPassword());
            pstmt.setString(4, empresa.getTipoNegocio());
            pstmt.setInt(5, empresa.getIdEmpresa());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una empresa (Delete)
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
