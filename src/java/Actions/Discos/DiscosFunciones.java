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
    public boolean alta(Disco disco,float precio) throws Exception
     {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;
         ResultSet rs = null;  
         
         con.setAutoCommit(false);
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
               
                pst = con.prepareStatement("INSERT INTO `discos` (upc, artista, album, genero, stock, descripcion, imagen)"+" values(?,?,?,?,?,?,?)");
                pst.setLong(1, disco.getUpc());
                pst.setString(2, disco.getArtista());
                pst.setString(3, disco.getAlbum());
                pst.setString(4, disco.getGenero());
                pst.setInt(5, disco.getStock());
                pst.setString(6, disco.getDescripcion());
                pst.setString(7, disco.getImagen());
                pst.executeUpdate();  
                
                pst = con.prepareStatement("INSERT INTO `canciones` (isrc, nombre, duracion, precio, upc, track)"+" values(?,?,?,?,?,?)" );
                pst.setLong(1, 0);
                pst.setString(2, "");
                pst.setFloat(3, 0);
                pst.setFloat(4, precio);
                pst.setLong(5, disco.getUpc());
                pst.setInt(6, 0);
                pst.executeUpdate();
                
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
    
    public void modificar (Disco disco,ArrayList<Model.Cancion> canciones,float precio) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         con.setAutoCommit(false);
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `discos` SET artista=?, album=?, genero=?, stock=?, descripcion=? WHERE upc=?");
               
            pst.setString(1, disco.getArtista());
            pst.setString(2, disco.getAlbum());
            pst.setString(3, disco.getGenero());
            pst.setInt(4, disco.getStock());
            pst.setString(5, disco.getDescripcion());
            pst.setLong(6,disco.getUpc());
            
            pst.executeUpdate();  
            
            pst = con.prepareStatement("UPDATE `canciones` SET nombre = ?, duracion = ?, precio = ?, track = ? WHERE upc = ? and isrc = ?");
            pst.setString(1, "");
            pst.setFloat(2, 0);
            pst.setFloat(3, precio);
            pst.setInt(4, 0);
            pst.setLong(5, disco.getUpc());
            pst.setLong(6, 0);
            pst.executeUpdate();
          
              for (int i = 1; i < canciones.size(); i++) {
                // Controlar si la cancion existe. Si existe UPDATE, si no INSERT
                Cancion get = canciones.get(i);
                pst = con.prepareStatement("SELECT count(*) FROM canciones WHERE isrc=? and upc=?" );
                pst.setLong(1, get.getIsrc());
                pst.setLong(2, disco.getUpc());
                rs = pst.executeQuery();
                rs.next();
                if(rs.getInt(1) == 0){
                    pst = con.prepareStatement("INSERT INTO `canciones`(isrc, nombre, duracion, precio, track, upc) values(?,?,?,?,?,?)");
                }
                else{
                    pst = con.prepareStatement("UPDATE `canciones` SET nombre = ?, duracion = ?, precio = ?, track = ? WHERE upc = ? and isrc = ?");
                }
                pst.setString(1, get.getNombre());
                pst.setFloat(2, get.getDuracion());
                pst.setFloat(3, get.getPrecio());
                pst.setInt(4, get.getTrack());
                pst.setLong(5, disco.getUpc());
                pst.setLong(6, get.getIsrc());
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
                                    rs.getInt("stock"));
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
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getLong("upc"),
                                    rs.getInt("stock"));
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
                                pst = con.prepareStatement("select * from discos where artista like '%"+texto+"%'");  
                                cond = true;
                                break;
                                }
                case "album":   {
                                pst = con.prepareStatement("select * from discos where album like '%"+texto+"%'");  
                                cond=true;
                                break;
                                }
                case "genero":  {
                                pst = con.prepareStatement("select * from discos where genero like '%"+texto+"%'");  
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
                                    rs.getInt("stock"));
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
    
     public ArrayList<Disco>  getAll(String columna, String texto, int pagina, int cantPagina) throws Exception
    {
        // <editor-fold desc="CONEXIÃ“N A LA BD - DECLARACIÃ“N Y ASIGNACIÃ“N DE VARIABLES">
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;
        ArrayList<Disco> lista = new ArrayList<>();
        // </editor-fold>
        
        try{
            // <editor-fold desc="QUERY Y RESULTADO">
            String sql = String.format("SELECT * FROM discos WHERE %s like ? LIMIT ?, ?", columna);
            pst = con.prepareStatement(sql);
            
            pst.setString(1, "%" + texto + "%");
            pst.setInt(2, (pagina - 1) * cantPagina);
            pst.setInt(3, cantPagina);
            
            rs = pst.executeQuery();  
            while(rs.next())
            {
                Disco disco = new Disco();
                disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"));
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
                }
                catch (Exception e) {  
                   System.out.println(e);  
                }  
            }  
            if(pst != null) {  
                try {  
                    pst.close();  
                }
                catch (Exception e) {  
                   System.out.println(e);  
                }  
            }
            if (rs != null) {  
                try {  
                    rs.close();  
                }
                catch (Exception e) {  
                    System.out.println(e);
                    //e.printStackTrace();  
                }
            }
        }
        // </editor-fold> 
        return lista; 
    }
    
    public ArrayList<Disco>  getAll (int pagina, int cantPagina) throws Exception
    {
        // <editor-fold desc="CONEXIÃ“N A LA BD - DECLARACIÃ“N Y ASIGNACIÃ“N DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
       
         ArrayList<Disco> lista = new ArrayList<>();
         
        // </editor-fold>
         
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              //ESCRIBIR LA CONSULTA CORRECTA
            pst = con.prepareStatement("select * from discos limit ?, ?");
            pst.setInt(1, (pagina - 1) * cantPagina);
            pst.setInt(2, cantPagina);
            
            rs = pst.executeQuery();  
            
            while(rs.next())
            {
                Disco disco = new Disco();
                
                disco.setDatos(rs.getString("artista"), rs.getString("album"),rs.getString("genero"),
                                    rs.getString("descripcion"), rs.getString("imagen"),rs.getInt("upc"),
                                    rs.getInt("stock"));
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
 
    public boolean buscar(long UPC) throws Exception
    {     boolean status = false;  
        
         // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select * from discos where upc=?");  
                pst.setLong(1, UPC);
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
    
    public int getStock(long UPC)throws Exception
    {
         //<editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         int stock;
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
                pst = con.prepareStatement("select stock from discos where upc=?");  
                pst.setLong(1, UPC);
                rs = pst.executeQuery();  
                rs.next();
                stock = rs.getInt("stock");
                          
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
          return stock;
    }
    
    public void setStock (int stock, long upc) throws Exception
    {
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
         
         
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
            pst = con.prepareStatement("UPDATE `discos` SET stock=? WHERE upc=? ");
               
            pst.setInt(1, stock);
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
    
     public int cantDiscos() throws Exception
    {    
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
         int cant = 0;  
        
         Connection con = Conexion.getConexion();
         PreparedStatement pst = null;  
         ResultSet rs = null;  
        
        // </editor-fold>
        
          try { // <editor-fold desc="QUERY Y RESULTADO">
              
                pst = con.prepareStatement("SELECT COUNT(*) FROM discos");  
                rs = pst.executeQuery();  
                if(rs.next())
                {
                    cant = rs.getInt(1);
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
            // </editor-fold>
        
        }  
        return cant; 
    
        
    }
    
    public int cantDiscos(String columna, String texto) throws Exception
    { 
        // <editor-fold desc="CONEXIÓN A LA BD - DECLARACIÓN Y ASIGNACIÓN DE VARIABLES">
        int cant = 0;
        Connection con = Conexion.getConexion();
        PreparedStatement pst = null;  
        ResultSet rs = null;
        
        // </editor-fold>
        try {
            // <editor-fold desc="QUERY Y RESULTADO">
            String sql = String.format("SELECT count(*) FROM discos WHERE %s like ?", columna);
            pst = con.prepareStatement(sql);
            
            pst.setString(1, "%" + texto + "%");
            rs = pst.executeQuery();  
            if(rs.next())
            {
                cant = rs.getInt(1);
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
            // </editor-fold>
        }  
        return cant;
    }
    
     // </editor-fold>
}
