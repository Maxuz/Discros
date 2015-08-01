/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;




public class Disco {
  
    // <editor-fold desc="DECLARACIÓN DE VARIABLES">
    private int upc;
    private String artista;
    private String album;
    private String genero;
    private String fecha_salida;
    private String descripcion;
    private String imagen;
    private int stock;
    // </editor-fold>
    
    // <editor-fold desc="CONSTRUCTORES">
    public Disco()
    {
    }
    
    public Disco( String artista, String album, String genero, String descripcion, String imagen, int upc, int stock, String fecha)
    {
        this.upc=upc;
        this.artista=artista;
        this.album=album;
        this.genero=genero;
        this.descripcion=descripcion;
        this.imagen=imagen;
        this.stock=stock;
        this.fecha_salida=fecha;
                
        
    }
    
    // </editor-fold>
    
    // <editor-fold desc="GETS DATOS">
    public String getDescripcion()
    {
        return this.descripcion;
    }
      
    public String getImagen()
    {
        return this.imagen;
    }
    
    public String getFecha()
    {
        return this.fecha_salida;
    }
    
    public String getArtista()
    {
        return this.artista;
    }
    
    public String getAlbum()
    { 
        return this.album;
    }
    
    public String getGenero()
    {
        return this.genero;
    }
    
    public int getUpc()
    {
        return this.upc;
    }
    
    public int getStock()
    {
        return this.stock;
    }
     
    // </editor-fold>
    
    // <editor-fold desc="SETS DE DATOS">
    public void setDatos( String artista, String album, String genero, String descripcion, String imagen, int upc, int stock, String fecha)
    {
        this.upc=upc;
        this.artista=artista;
        this.album=album;
        this.genero=genero;
        this.descripcion=descripcion;
        this.imagen=imagen;
        this.stock=stock;
        this.fecha_salida=fecha;
                
        
    }
    
    
    // </editor-fold>
    
    
   
    
    
    
}
