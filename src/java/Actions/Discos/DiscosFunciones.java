package Actions.Discos;

import Actions.Conexion;
import Model.Cancion;
import Model.Disco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DiscosFunciones {
    
    // <editor-fold desc="FUNCIONES: ALTA BAJA MODIFICAR">
    public boolean alta(Disco disco, ArrayList<Model.Cancion> canciones,float precio) throws Exception
     {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;
         ResultSet rs = null;  
         
         con.setAutoCommit(false);
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                /*pst = con.prepareStatement("INSERT INTO `usuarios` (email, password, tipo, nombre, apellido, direccion, ciudad, dni, provincia, estado)"+"values(?,?,?,?,?,?,?,?,?,?) ");
                pst.setString(1, user.getEmail());
                pst.setString(2, user.getPass());
                pst.setString(3, user.getTipo());
                pst.setString(4, user.getNombre());
                pst.setString(5, user.getApellido());
                pst.setString(6, user.getDireccion());
                pst.setString(7, user.getCiudad());
                pst.setInt(8, user.getdni());
                pst.setString(9, user.getProvincia());
                pst.setBoolean(10,  user.getEstado());*/
                pst = con.prepareStatement("INSERT INTO `discos` (upc, artista, album, genero, fecha_salida, stock, descripcion, imagen)"+" values(?,?,?,?,?,?,?,?)");
                pst.setInt(1, disco.getUpc());
                pst.setString(2, disco.getArtista());
                pst.setString(3, disco.getAlbum());
                pst.setString(4, disco.getGenero());
                pst.setString(5, disco.getFecha());
                pst.setInt(6, disco.getStock());
                pst.setString(7, disco.getDescripcion());
                pst.setString(8, disco.getImagen());
                pst.executeUpdate();  
                
                pst = con.prepareStatement("INSERT INTO `canciones` (isrc, nombre, duracion, precio, upc, track)"+" values(?,?,?,?,?,?)" );
                pst.setLong(1, 0);
                pst.setString(2, "");
                pst.setFloat(3, 0);
                pst.setFloat(4, precio);
                pst.setInt(5, disco.getUpc());
                pst.setInt(6, 0);
                pst.executeUpdate();
                
            
             for (int i = 0; i < canciones.size(); i++) {
             Cancion get = canciones.get(i);
              pst = con.prepareStatement("INSERT INTO `canciones`(isrc, nombre, duracion, precio, upc, track)"+" values(?,?,?,?,?,?)" );
               pst.setLong(1, get.getIsrc());
               pst.setString(2, get.getNombre());
               pst.setFloat(3, get.getDuracion());
               pst.setFloat(4, get.getPrecio());
               pst.setInt(5, disco.getUpc());
               pst.setInt(6, get.getTrack());
               pst.executeUpdate();
           } // </editor-fold>
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
            pst = con.prepareStatement("select * from discos where upc=?");  
            pst.setInt(1, UPC);
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
    
    public ArrayList<Disco>  getAll () throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<Disco> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from discos");  
            
            rs = pst.executeQuery();  
            
            
            
            while(rs.next())
            { 
                
                Disco disco = new Disco();
                
                disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"),rs.getString("fecha_salida"));
              lista.add(disco);
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
    
    
    public ArrayList<Disco>  getAll (String columna, String texto) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         boolean cond;
         ArrayList<Disco> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            
            switch(columna){
                case "artista":{
                                pst = con.prepareStatement("select * from discos where artista like %{"+texto+"}%");  
                                pst.setString(1, texto);
                                cond = true;
                                break;
                                }
                case "album":   {
                                pst = con.prepareStatement("select * from discos where album=?");  
                                pst.setString(1, texto);
                                cond=true;
                                break;
                                }
                case "genero":  {
                                pst = con.prepareStatement("select * from discos where genero=?");  
                                pst.setString(1, texto);
                                cond=true;
                                break;
                                }
                default : cond=false;break;
            }  
            
            if(cond){
            rs = pst.executeQuery();  
            while(rs.next())
            { 
                
                Disco disco = new Disco();
                
                disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"),rs.getString("fecha_salida"));
              lista.add(disco);
            }
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
    
    public ArrayList<Disco>  getAllGenero (String genero) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<Disco> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from discos where genero=?");  
            pst.setString(1, genero);
            rs = pst.executeQuery();  
             
            while(rs.next())
            { 
                
                Disco disco = new Disco();
                
                disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"),rs.getString("fecha_salida"));
              lista.add(disco);
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
    
    public ArrayList<Disco>  getAllAlbum (String album) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<Disco> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from discos where album=?");  
            pst.setString(1, album);
            rs = pst.executeQuery();  
             
            while(rs.next())
            { 
                
                Disco disco = new Disco();
                
                disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"),rs.getString("fecha_salida"));
              lista.add(disco);
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
    
    
    public ArrayList<String>  getListaArtistas () throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<String> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select artista from discos GROUP BY artista ");  
           
            rs = pst.executeQuery();  
                       
            
            while(rs.next())
            {   String st = null;
                st=rs.getString("artista");
                lista.add(st);
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
    
     public ArrayList<String>  getListaGeneros () throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<String> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select genero from discos GROUP BY genero ");  
           
            rs = pst.executeQuery();  
                       
            
            while(rs.next())
            {   String st = null;
                st=rs.getString("genero");
                lista.add(st);
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
