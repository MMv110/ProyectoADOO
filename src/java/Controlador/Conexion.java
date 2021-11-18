package Controlador;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    public Conexion()
        {
        String cadena="jdbc:mysql://localhost:3306/proyectotriangulo";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadena,"root","1234");
            System.out.println("conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }    
        }
    public Connection getConexion(){
        return con;
    }   
}
