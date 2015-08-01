package Actions.PedidosCanciones;

import Actions.Conexion;
import Model.PedidosCanciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosCancionesFunciones {
    
// <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">
          
    public void alta(PedidosCanciones pc) throws Exception
     {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                
                pst = con.prepareStatement("INSERT INTO `pedidos_canciones` values( '"+pc.getId_pedido()+"','"+pc.getIsrc()+"','"+pc.getUpc()+"','"+pc.getCantidad()+"')");
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
    
    public void baja (int id_pedido, int isrc, int upc) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from pedidos_canciones where id_pedido=?, isrc=?, upc=? ");  
            pst.setInt(1, id_pedido);
            pst.setInt(2, isrc);
            pst.setInt(3, upc);
            
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
    
    public void modificar (PedidosCanciones pc) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `pedidos` SET cantidad=? where id_pedido=?, isrc=?, upc=? ");
               
            pst.setInt(1, pc.getCantidad());
            pst.setInt(2, pc.getId_pedido());
            pst.setInt(3, pc.getIsrc());
            pst.setInt(4, pc.getUpc());
                    
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
    public PedidosCanciones getOne (int id_pedido, int isrc, int upc) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         PedidosCanciones pedido_cancion = new PedidosCanciones();
         
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from pedidos_canciones where id_pedido=?, isrc=?, upc=? ");  
            rs = pst.executeQuery();  
            
            if(rs.next())
            {
              pedido_cancion.setDatos(rs.getInt("id_pedido"), rs.getInt("upc"), rs.getInt("isrc"), rs.getInt("cantidad"));
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
        
         return pedido_cancion; 
    }
// </editor-fold>
    
// <editor-fold desc="FUNCIONES: OTRAS">
    public boolean buscar(int id_pedido, int upc, int isrc) throws Exception
    {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select * from pedidos_canciones where id_pedido=?, isrc=?, upc=? ");  
                
                pst.setInt(1, id_pedido);
                pst.setInt(2, isrc);
                pst.setInt(3, upc);
                
               
                
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
    
     public void actualizar (int id_pedido, int isrc, int upc, int cantidad ) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `pedidos_canciones` SET cantidad=? WHERE where id_pedido=?, isrc=?, upc=? ");
               
            pst.setInt(1, cantidad);
            pst.setInt(2, id_pedido);
            pst.setInt(3, isrc);
            pst.setInt(4, upc);
             
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
     
}
