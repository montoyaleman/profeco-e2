package DAOs;

import Entidades.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDAO {

    // Método para obtener todos los productos (Read)
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

    // Método para obtener un producto por ID (Read)
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
    
//    // Método para obtener un producto por ID (Read)
//    public List<Producto> obtenerProductosPorNombre(String nombre) {
//        List<Producto> lista = new ArrayList<>();
//        String sql = "SELECT * FROM Producto WHERE nombre LIKE %?%";
//
//        try (Connection conn = Conexion.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, nombre);
//            ResultSet rs = pstmt.executeQuery(sql);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    producto = new Producto();
//                    producto.setIdProducto(rs.getInt("idProducto"));
//                    producto.setIdEmpresa(rs.getInt("idEmpresa"));
//                    producto.setNombre(rs.getString("nombre"));
//                    producto.setDescripcion(rs.getString("descripcion"));
//                    producto.setPrecio(rs.getDouble("precio"));
//                    producto.setOferta(rs.getBoolean("oferta"));
//                    producto.setEtiquetas(rs.getString("etiqueta"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return producto;
//    }

    // Método para crear un nuevo producto (Create)
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

    // Método para actualizar un producto (Update)
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

    // Método para eliminar un producto (Delete)
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
