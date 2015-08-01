package Actions.Productos;

import Actions.Conexion;
import Model.Disco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class ProductosFunciones {
    
    // <editor-fold desc="ALTA - BAJA - MODIFICACIÓN">
    public boolean alta(Disco prod) throws Exception
      {    boolean status = false;  
    
         //ConexionSingleton temp = ConexionSingleton.getInstance();
         //Connection conexion = temp.getConexion();
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("INSERT INTO `usuarios` values('"+prod.getArtista()+"','"+prod.getAlbum()+"'"
                        + ",'"+prod.getUpc()+"','"+prod.getStock()+"')");
                
            pst.executeUpdate(); 
            
            rs = pst.executeQuery();  
            status = rs.next();
         // </editor-fold>
            
              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
               // <editor-fold desc="CIERRA: CON, PST, RS">
            if (con != null) {  
                try {  
                    Actions.Conexion.cerrarConexion();
                   
                 } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                    //e.printStackTrace();  
                }  
            }
            // </editor-fold>
        
        }  
        return status;  
   }
    
    
    
    public void actualizar(Disco prod)
    {
    
    }
    
    public void baja (Disco prod)
    {
    
    }
    
    // </editor-fold>
    
    // <editor-fold desc="GETS">
    public void getOne (String tipo, String codigo)
    {
        
    }
    
    public void getAll(String tipo)
    {
        
    }
    // </editor-fold >
    
    // <editor-fold desc="OTRAS CONSULTAS">
    public boolean buscar(Disco prod, String tipo, Integer codigo)
    {
        return true;
    }
    // </editor-fold>
    
}
