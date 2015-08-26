package Actions.Canciones;

import Actions.Conexion;
import Model.Cancion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CancionesFunciones {
   
// <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">
          
    public boolean alta(Cancion cancion) throws Exception
     {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                
                pst = con.prepareStatement("INSERT INTO `canciones` values( '"+cancion.getIsrc()+"','"+cancion.getNombre()+"','"+cancion.getDuracion()+"','"+cancion.getPrecio()+"'"
                        + ",'"+cancion.getUpc()+"','"+cancion.getTrack()+"')");
                
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
    public void alta(ArrayList<Model.Cancion> lista, String upc) throws Exception
     {    
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         con.setAutoCommit(false);
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                for (int i = 0; i < lista.size(); i++) {
                  Cancion get = lista.get(i);
                
                pst = con.prepareStatement("INSERT INTO `canciones` (isrc, nombre, duracion, precio, upc, track)"+" values(?,?,?,?,?,?)" );
                pst.setLong(1, get.getIsrc());
                pst.setString(2, get.getNombre());
                pst.setFloat(3, get.getDuracion());
                pst.setFloat(4, get.getPrecio());
                pst.setLong(5,Long.parseLong(upc));
                pst.setInt(6, get.getTrack());
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
                    con.setAutoCommit(true);
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
    public void baja (long UPC, long ISRC) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from canciones where upc=? and isrc=? ");  
            pst.setLong(1, UPC);
            pst.setLong(2, ISRC);
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
    
    public void modificar (Cancion cancion) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `canciones` SET nombre=?, duracion=?, precio=?, track=? WHERE upc=? and isrc=? ");
               
            pst.setString(1, cancion.getNombre());
            pst.setFloat(2, cancion.getDuracion());
            pst.setFloat(3, cancion.getPrecio());
            pst.setInt(4, cancion.getTrack());
            pst.setLong(5, cancion.getUpc());
            pst.setLong(6, cancion.getIsrc());
                    
            
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
    public Cancion getOne (long UPC, long ISRC) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         Cancion cancion = new Cancion();
          
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from canciones where upc=? and isrc=?");  
            pst.setLong(1, UPC);
            pst.setLong(2, ISRC);
            
            rs = pst.executeQuery();  
            
           
            if(rs.next()){
            
            cancion.setDatos(rs.getString("nombre"), rs.getFloat("precio"),rs.getInt("isrc"),
                                    rs.getLong("upc"), rs.getFloat("duracion"),rs.getInt("track"));
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
        
         return cancion; 
    }
    
     public ArrayList<Cancion>  getAll (long UPC) throws Exception
    {
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        ArrayList<Cancion> lista = new ArrayList<Cancion>();
         
        try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("SELECT * FROM canciones WHERE upc = ? AND isrc <> 0 ORDER BY track");  
            pst.setLong(1, UPC);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                Cancion can = new Cancion();
                can.setDatos(rs.getString("nombre"), rs.getFloat("precio"),rs.getLong("isrc"),
                    rs.getLong("upc"), rs.getFloat("duracion"),rs.getInt("track"));
                lista.add(can);
            }

            
              } 
          catch (Exception e) {  
                throw e;  
              } 
          finally {  
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
        
        }  
          return lista;
       // </editor-fold>   
    }  

    
// <editor-fold desc="FUNCIONES: OTRAS">
    public boolean buscar(long UPC, long ISRC) throws Exception
    {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select * from canciones where upc=? and isrc=? ");  
                pst.setLong(1, UPC);
                pst.setLong(2, ISRC);
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
    
    public void bajaAll (long UPC) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("delete from canciones where upc=? ");  
            pst.setLong(1, UPC);
           
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
    
      public void modificarPrecio (float precio, long upc) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `canciones` SET precio=? WHERE isrc=0 and upc=? ");
            
            pst.setFloat(1, precio);
            pst.setLong(2, upc);
            
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
