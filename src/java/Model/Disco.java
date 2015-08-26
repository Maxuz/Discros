/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;




public class Disco {
  
    // <editor-fold desc="DECLARACIÓN DE VARIABLES">
    private long upc;
    private String artista;
    private String album;
    private String genero;
    private String fecha_salida;
    private String descripcion;
    private String imagen;
    private int stock;
    private float precioAux;
    
    //NO SE GUARDA EN LA TABLA CANCION, SIRVE PARA LA TABLA PEDIDOS_CANCIONES
    private Date hora;
    private int cantidad;
    
    // </editor-fold>
    
    // <editor-fold desc="CONSTRUCTORES">
    public Disco()
    {
    }
    
    public Disco( String artista, String album, String genero, String descripcion, String imagen, long upc, int stock)
    {
        this.upc=upc;
        this.artista=artista;
        this.album=album;
        this.genero=genero;
        this.descripcion=descripcion;
        this.imagen=imagen;
        this.stock=stock;
        this.fecha_salida="null";
                
        
    }
    
    // </editor-fold>
    
    // <editor-fold desc="GETS DATOS">
    
    public int getCantidad()
    {
    return this.cantidad;
    }
    
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
    
    public long getUpc()
    {
        return this.upc;
    }
    
    public int getStock()
    {
        return this.stock;
    }
    
     public Date getHora()
    {
        return this.hora;
    }
       
     
    // </editor-fold>
    
    // <editor-fold desc="SETS DE DATOS">
       public void setCantidad(int cant)
     {
         this.cantidad=cant;
     }
     public void setHora(Date hora)
     {
         this.hora=hora;
     }
     
    public void setDatos( String artista, String album, String genero, String descripcion, String imagen, long upc, int stock)
    {
        this.upc=upc;
        this.artista=artista;
        this.album=album;
        this.genero=genero;
        this.descripcion=descripcion;
        this.imagen=imagen;
        this.stock=stock;
        //this.fecha_salida=fecha;
                
        
    }
    
    public void setPrecioAux(float precio)
    {
        this.precioAux=precio;
    }
    // </editor-fold>
    
    
   
    
    
    
}
