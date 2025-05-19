package DAOs;

import Entidades.Producto;
import java.sql.*;
import java.util.*;

/**
 * Clase de acceso a datos para la entidad Producto.
 * Proporciona métodos para realizar operaciones CRUD (Create, Read, Update, Delete)
 * sobre la tabla Producto en la base de datos.
 */
public class ProductoDAO {

    /**
     * Obtiene una lista de todos los productos almacenados en la base de datos.
     *
     * @return Lista de objetos Producto.
     */
    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Producto";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setIdEmpresa(rs.getInt("idEmpresa"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setOferta(rs.getBoolean("oferta"));
                p.setEtiquetas(rs.getString("etiqueta"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Obtiene un producto específico de la base de datos por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return Objeto Producto si se encuentra, de lo contrario null.
     */
    public Producto obtenerProductoPorId(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM Producto WHERE idProducto = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setIdEmpresa(rs.getInt("idEmpresa"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setOferta(rs.getBoolean("oferta"));
                    producto.setEtiquetas(rs.getString("etiqueta"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    /**
     * Obtiene una lista de productos que coinciden con el nombre proporcionado.
     *
     * @param nombre El nombre del producto a buscar.
     * @return Lista de objetos Producto que coinciden con el nombre.
     */
    public List<Producto> obtenerProductosPorNombre(String nombre) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE \""+nombre+"\"";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //pstmt.setString(1, "%"+nombre+"%");
            ResultSet rs = pstmt.executeQuery(sql);

            if (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setIdEmpresa(rs.getInt("idEmpresa"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setOferta(rs.getBoolean("oferta"));
                producto.setEtiquetas(rs.getString("etiqueta"));
                lista.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Crea un nuevo producto en la base de datos.
     *
     * @param producto El objeto Producto a crear.
     */
    public void crearProducto(Producto producto) {
        String sql = "INSERT INTO Producto (idEmpresa, nombre, descripcion, precio, oferta, etiqueta) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, producto.getIdEmpresa());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setDouble(4, producto.getPrecio());
            pstmt.setBoolean(5, producto.isOferta());
            pstmt.setString(6, producto.getEtiquetas());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un producto existente en la base de datos.
     *
     * @param producto El objeto Producto con los datos actualizados.
     */
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE Producto SET idEmpresa = ?, nombre = ?, descripcion = ?, precio = ?, oferta = ?, etiqueta = ? WHERE idProducto = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, producto.getIdEmpresa());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setDouble(4, producto.getPrecio());
            pstmt.setBoolean(5, producto.isOferta());
            pstmt.setString(6, producto.getEtiquetas());
            pstmt.setInt(7, producto.getIdProducto());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     *
     * @param id El ID del producto a eliminar.
     */
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM Producto WHERE idProducto = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
