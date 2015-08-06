package Actions;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class Conexion {
    
  //static Connection con ; // atribut per a guardar l’objecte connexió.
  static Connection con ;
  
  public static Connection getConexion() throws Exception{
        
        String host = "localhost";//cambiar por tu host de la base de datos
        String user = "root";//cambiar por tu usuario de la base de datos
        String pass = "root";//cambiar por tu contraseña de la base de datos
        String dtbs = "dbtp";//cambiar por tu nombre de la base de datos
 
        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            
            con = DriverManager.getConnection(newConnectionURL);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al abrir la conexión.");
        }
            return con;
    }
  
   public static void cerrarConexion() throws SQLException{
        try {
                
            con.close();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
