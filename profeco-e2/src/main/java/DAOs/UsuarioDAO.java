package DAOs;

import Entidades.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    // Método para obtener todos los usuarios (Read)
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidoPaterno(rs.getString("apellidoPaterno"));
                u.setApellidoMaterno(rs.getString("apellidoMaterno"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para obtener un usuario por ID (Read)
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // Método para crear un nuevo usuario (Create)
    public void crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombres, apellidoPaterno, apellidoMaterno, email, password, isAdmin) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidoPaterno());
            pstmt.setString(3, usuario.getApellidoMaterno());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getPassword());
            pstmt.setBoolean(6, usuario.isIsAdmin());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un usuario (Update)
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET nombres = ?, apellidoPaterno = ?, apellidoMaterno = ?, email = ?, password = ?, isAdmin = ? WHERE idUsuario = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidoPaterno());
            pstmt.setString(3, usuario.getApellidoMaterno());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getPassword());
            pstmt.setBoolean(6, usuario.isIsAdmin());
            pstmt.setInt(7, usuario.getIdUsuario());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un usuario (Delete)
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
