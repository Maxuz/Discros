package Actions.Pedidos;

import Actions.Conexion;
import Model.Cancion;
import Model.Pedido;
import Actions.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Actions.Discos.DiscosFunciones;

public class PedidosFunciones {

 
// <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">
          
    public boolean alta(Pedido pedido, ArrayList<Cancion> lista) throws Exception
     {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         DiscosFunciones funcionesDisco = new DiscosFunciones();
         
         con.setAutoCommit(false);
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("INSERT INTO `pedidos` (email, valor, estado, fecha, pago, formapago)"+" values(?,?,?,?,?,?)");  
                //pst.setInt(1, pedido.getID());
                pst.setString(1, pedido.getEmail());
                pst.setFloat(2, pedido.getValor());
                pst.setString(3, pedido.getEstado());
                pst.setDate(4, Util.convertUtilDateToSqlDate(pedido.getFecha()));  
                pst.setString(5, pedido.getPago());
                pst.setString(6,pedido.getFormaPago());
                pst.executeUpdate();
                 
                
                for(Cancion can:lista)
                {
                  pst = con.prepareStatement("INSERT INTO `pedidos_canciones` (id_pedido, isrc, upc,cantidad)"+" values(last_insert_id(),?,?,?)"); 
                 // pst.setInt(1, pedido.getID());
                  pst.setLong(1, can.getIsrc());
                  pst.setLong(2, can.getUpc());
                  pst.setInt(3, can.getCantidad());
                  pst.executeUpdate();
                  
                  
                  
                  int stock = funcionesDisco.getStock(can.getUpc());
                  stock = stock-1;
                  pst = con.prepareStatement("UPDATE `discos` SET stock=? WHERE upc=? ");
                  
                  pst.setInt(1, stock);
                  pst.setLong(2, can.getUpc());

                  pst.executeUpdate(); 
                }
                
                // </editor-fold>
            } 
          catch (Exception e) {  
                con.rollback();
                throw e;  
              } 
          finally {  
               // <editor-fold desc="CIERRA: CON, PST, RS">
            if (con != null) {  
                try {  
                    con.commit();
                    Actions.Conexion.cerrarConexion();
                    con.setAutoCommit(true);
                  
                   
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
    
    public void baja (int id) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            
            pst = con.prepareStatement("delete from pedidos where id_pedido=? ");  
            pst.setInt(1, id);
            
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
    
    public void modificar (Pedido pedido) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `pedidos` SET valor=?, estado=?, fecha=? WHERE id_pedido=? ");
               
            pst.setFloat(1, pedido.getValor());
            pst.setString(2, pedido.getEstado());
            pst.setDate(3, Actions.Util.convertUtilDateToSqlDate(pedido.getFecha()));
            
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
    public Pedido getOne (int id) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         Pedido pedido = new Pedido();
         
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from pedidos where id_pedido=? ");
            pst.setInt(1, id);
            rs = pst.executeQuery();  
            
           
            if(rs.next())
            {
              pedido.setDatos(rs.getInt("id_pedido"), rs.getFloat("valor"),rs.getDate("fecha"),
                                    rs.getString("estado"), rs.getString("email"));
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
        
         return pedido; 
    }
    
    
    
    public ArrayList<Pedido>  getAll (String email) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<Pedido> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from pedidos where email=? ORDER BY fecha DESC");  
            pst.setString(1, email);
            rs = pst.executeQuery();  
             
            while(rs.next())
            {  Pedido pedido = new Pedido();
                
               pedido.setDatos(rs.getInt("id_pedido"), rs.getFloat("valor"),rs.getDate("fecha"), rs.getString("estado"), email);
               lista.add(pedido);
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
         
         return lista; 
    }
    
    
// </editor-fold>
    
// <editor-fold desc="FUNCIONES: OTRAS">
    public boolean buscar(int id) throws Exception
    {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select * from pedidos where id_pedido=? ");  
                pst.setInt(1, id);
               
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
    
    public boolean buscar (int id, String email) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         boolean status;
         
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from pedidos where id_pedido=? and email=? ");
            pst.setInt(1, id);
            pst.setString(2, email);
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
          
            
          }
         // </editor-fold>
        
         return status; 
    }
    
     public void actualizar (int id, String estado, float valor, String fecha) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `pedidos` SET estado=?, fecha_caduca=?, valor=? WHERE id_pedido='"+id+"' ");
               
            pst.setString(1, estado);
            pst.setString(2, fecha);
            pst.setFloat(3, valor);
            
         
            
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
