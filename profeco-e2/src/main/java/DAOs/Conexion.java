/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase utilizada para conectarse a la base de datos del programa.
 * Proporciona un método estático para obtener una conexión a la base de datos.
 *
 * @author montoya
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/profeco";
    private static final String USER = "root";
    private static final String PASSWORD = "1234"; // O la contraseña que hayas definido

    /**
     * Obtiene una conexión a la base de datos utilizando los parámetros de conexión definidos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar conectarse a la base de datos.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
