/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase utilizada para conectarse a la base de datos del programa
 * @author montoya
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/profeco";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // O la contraseña que hayas definido

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
