/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Reporte;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class ReporteDAO {
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
}
