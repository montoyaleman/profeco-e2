package DAOs;

import Entidades.Usuario;
import java.sql.*;
import java.util.*;

/**
 * Clase de acceso a datos para la entidad Usuario.
 * Proporciona métodos para realizar operaciones CRUD (Create, Read, Update, Delete)
 * sobre la tabla Usuario en la base de datos.
 */
public class UsuarioDAO {

    /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     *
     * @return Lista de objetos Usuario.
     */
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombres(rs.getString("nombre"));
                u.setApellidoPaterno(rs.getString("apellidoPaterno"));
                u.setApellidoMaterno(rs.getString("apellidoMaterno"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                u.setIdEmpresa(rs.getInt("idEmpresa"));
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Obtiene un usuario específico de la base de datos por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return Objeto Usuario si se encuentra, de lo contrario null.
     */
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
                    usuario.setNombres(rs.getString("nombre"));
                    usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setIsAdmin(rs.getBoolean("isAdmin"));
                    usuario.setIdEmpresa(rs.getInt("idEmpresa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto Usuario a crear.
     */
    public void crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, apellidoPaterno, apellidoMaterno, email, password, isAdmin) VALUES (?, ?, ?, ?, ?, ?)";

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

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param usuario El objeto Usuario con los datos actualizados.
     */
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, email = ?, password = ?, isAdmin = ?, idEmpresa = ? WHERE idUsuario = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidoPaterno());
            pstmt.setString(3, usuario.getApellidoMaterno());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getPassword());
            pstmt.setBoolean(6, usuario.isIsAdmin());
            pstmt.setInt(7, usuario.getIdEmpresa());
            pstmt.setInt(8, usuario.getIdUsuario());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     *
     * @param id El ID del usuario a eliminar.
     */
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
