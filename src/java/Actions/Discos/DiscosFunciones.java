package Actions.Discos;

import Actions.Conexion;
import Model.Disco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DiscosFunciones {
    
    // <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">
    public boolean alta(Disco disco) throws Exception
     {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                
                pst = con.prepareStatement("INSERT INTO `discos` values('"+disco.getUpc()+"','"+disco.getArtista()+"','"+disco.getAlbum()+"','"+disco.getGenero()+"','"+disco.getFecha()+"','"+disco.getStock()+"'"
                        + ",'"+disco.getDescripcion()+"','"+disco.getImagen()+"')");
                
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
        return status; 
    
        
    }
    
    public void baja (int UPC) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from discos where upc=?");  
            pst.setInt(1, UPC);
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
    
    public void modificar (Disco disco) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `discos` SET artista=?, album=?, genero=?, fecha_salida=?, stock=?, descripcion=?, imagen=? WHERE upc='"+ disco.getUpc()+"' ");
               
            pst.setString(1, disco.getArtista());
            pst.setString(2, disco.getAlbum());
            pst.setString(3, disco.getGenero());
            pst.setString(4, disco.getFecha());
            pst.setInt(5, disco.getStock());
            pst.setString(6, disco.getDescripcion());
            pst.setString(7, disco.getImagen());
            
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
    
     // </editor-fold>
    
    // <editor-fold desc="FUNCIONES: GETS">
    public Disco getOne (int UPC) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         Disco disco = new Disco();
         
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from discos where upc='"+UPC+"'");  
            rs = pst.executeQuery();  
            
           
            if(rs.next()){
            //String texto = rs.getString("email");
            disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"),rs.getString("fecha_salida"));
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
         // </editor-fold>
        
         return disco; 
    }
     // </editor-fold>
    
    // <editor-fold desc="FUNCIONES: OTRAS">
    public boolean buscar(int UPC) throws Exception
    {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select * from discos where upc=?");  
                pst.setInt(1, UPC);
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
