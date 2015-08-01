package Actions.Usuarios;

import Model.Usuario;
import Actions.Conexion;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.util.ArrayList;
import java.util.Collection;


/* LIBRERÍAS QUE FUERON IMPORTADASS PERO QUE NO SE UTILIZAN
import java.sql.SQLException;  
import java.sql.DriverManager;  
import java.io.IOException;
import Actions.ConexionSingleton;
import java.sql.Statement;
*/

public class UsuariosFunciones {
  
// <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">   
  
public void alta (Usuario user) throws Exception
    {    
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
                 
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                // <editor-fold desc="CODIGO NO SE USA. COMENTADO POR LAS DUDAS">
                    //String sql = "INSERT INTO `usuarios`(`email`,`password`,`id_usuario`) VALUES (`"+email+"`,`"+pass+"`,`"+id+"`)";
                    // pst = con.prepareStatement("INSERT INTO `usuarios`(email=?, password=?, id_usuario=?");
                   //
              /*pst.setString(1, email); 
                pst.setString(2, pass);
                pst.setInt(3, id);
                */
                   
              
                 // </editor-fold>
              
               
                pst = con.prepareStatement("INSERT INTO `usuarios` values('"+user.getEmail()+"','"+user.getPass()+"','"+user.getTipo()+"','"+user.getNombre()+"','"+user.getApellido()+"'"
                        + ",'"+user.getDireccion()+"','"+user.getCiudad()+"','"+user.getdni()+"','"+user.getProvincia()+"')");
                
                pst.executeUpdate();
                
              
                
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
      
    }

public void baja (Usuario user) throws Exception
    {   
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         String email = user.getEmail();
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from discos where upc=?");  
            pst.setString(1, email);
            pst.executeUpdate();  
          
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
        
    }

public void modificar (Usuario user) throws Exception
    {    
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
                 
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                
              //COMPLETAR LA CONSULTA UPDATE
                pst = con.prepareStatement("UPDATE `usuarios` SET password=?, nombre=?, apellido=?, direccion=?, ciudad=?, dni=?, provincia=? WHERE email='"+ user.getEmail()+"' ");
                pst.setString(1, user.getPass());
                pst.setString(2, user.getNombre());
                pst.setString(3, user.getApellido());
                pst.setString(4, user.getDireccion());
                pst.setString(5, user.getCiudad());
                pst.setInt(6, user.getdni());
                pst.setString(7, user.getProvincia());
               
                
                pst.executeUpdate();
                
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
       //return status;  
    }


// </editor-fold>

// <editor-fold desc="FUNCIONES: GETS">
public Usuario getOne (String email) throws Exception
    {   
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         Usuario user = new Usuario();
         
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from usuarios where email='"+email+"'");  
            rs = pst.executeQuery();  
            
           
            if(rs.next()){
            String texto = rs.getString("email");
            user.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), rs.getString("direccion"),rs.getString("ciudad"),rs.getString("provincia"),rs.getInt("dni"));
            }
             
            
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
          
            
          }
            return user;    
       
    
// </editor-fold>
}

public ArrayList<Usuario>  getAll () throws Exception
    {    
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         ArrayList<Usuario> lista = new ArrayList<Usuario>();
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("select * from usuarios ");  
        
            rs = pst.executeQuery();  
            Usuario user = new Usuario();
            
            while(rs.next())
            {
                user.setDatos(rs.getString("email"), rs.getString("password"),rs.getString("nombre"),rs.getString("apellido"), rs.getString("direccion"),rs.getString("ciudad"),rs.getString("provincia"),rs.getInt("dni"));
                lista.add(user);
            }

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
            /*if (rs != null) {  
                try {  
                    
                    rs.close();  
                } catch (Exception e) {  
                    System.out.println(e);
                    //e.printStackTrace();  
                }  
            }*/
            // </editor-fold>
        
        }  
          return lista;
   }

 // </editor-fold>

// <editor-fold desc="FUNCIONES: OTRAS">
public boolean buscar(String email) throws Exception
{        boolean status = false;  
    
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select * from usuarios where email=?");  
                pst.setString(1, email);  
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

public boolean login (Usuario user) throws Exception
    {    boolean status = false;  
    
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         String email = user.getEmail();
         String pass = user.getPass();
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("select * from usuarios where email=? and password=?");  
            pst.setString(1, email);  
            pst.setString(2, pass);  
  
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
 // </editor-fold>   


}
