/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Empresa;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class EmpresaDAO {
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
}
