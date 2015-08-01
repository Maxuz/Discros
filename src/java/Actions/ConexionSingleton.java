package Actions; //Cambiar por el nombre de tu paquete

import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConexionSingleton {
 
    
    static Connection con ; // atribut per a guardar l’objecte connexió.
    private static ConexionSingleton INSTANCE = null;
    
    /**Método constructor que ejecuta el método para conectar con la base de datos
     *
     */
    public ConexionSingleton() {
        performConnection();
    }
 
    /**Crea una instancia de la base de datos en caso de no estar creada.
     *
     */
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConexionSingleton();
        }
    }
 
    /**Metodo para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return retorna una instancia de la conexión a la base de datos
     */
    public static ConexionSingleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
 
    /**Método para eliminar la instancia de la conexión
     *
     */
    public static void delInstance() {
        INSTANCE = null;
        closeConnection();
    }
 
    /**Método que crea la conexión a la base de datos
     *
     */
    public void performConnection() {
 
        String host = "localhost";//cambiar por tu host de la base de datos
        String user = "root";//cambiar por tu usuario de la base de datos
        String pass = "clubnautico11";//cambiar por tu contraseña de la base de datos
        String dtbs = "dbTP";//cambiar por tu nombre de la base de datos
 
        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            
            con = DriverManager.getConnection(newConnectionURL);
            
        } catch (Exception e) {
            System.out.println("Error al abrir la conexión.");
        }
    }
 
    /**Método para cerrar la conexión con la base de dades
     *
     */
    public static void closeConnection() {
        try {
                
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
    
    
    public Connection getConexion()
    {   
        return con;
    }
}
