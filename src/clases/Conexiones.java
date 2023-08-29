package clases;

import java.sql.Connection;
import java.sql.*;

public class Conexiones {

    public static Connection conexion() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferre", "root", "");
            return cn;

        } catch (SQLException e) {
            System.out.println("Error en la conexión " + e);
        }
        return null;

    }
}
