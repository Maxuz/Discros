
package Model;

import java.util.Calendar;
import java.util.Date;
import javax.print.attribute.standard.DateTimeAtCompleted;


public class Cancion {
     
   // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private String nombre;
    private float precio;
    private long isrc;
    private int track;
    private float duracion;
    
    //CLAVE FORÁNEA
    private long upc;
    
    //NO SE GUARDA EN LA TABLA CANCION, SIRVE PARA LA TABLA PEDIDOS_CANCIONES
    
    
    private Date hora;
   
    
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
     public Cancion()
     { }
    
     public Cancion(String nombre, float precio, long isrc, int upc, float duracion, int track)
     {
     this.nombre=nombre;
     this.precio=precio;
     this.isrc=isrc;
     this.upc=upc;
     this.duracion=duracion;
     this.track=track;
     }
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS ">
     public void setDatos(String nombre, float precio,long isrc, long upc, float duracion, int track)
     {
     this.nombre=nombre;
     this.precio=precio;
     this.isrc=isrc;
     this.upc=upc;
     this.duracion=duracion;
     this.track=track;
     }
     
     public void setHora(Date hora)
     {
         this.hora=hora;
     }
     
    // </editor-fold>
    
    // <editor-fold desc="GET DE DATOS">
   
    
    public String getNombre()
    {
        return this.nombre;
    }
    public float getPrecio()
    {
        return this.precio;
    }
    public long getIsrc()
    {
        return this.isrc;
    }
    public long getUpc()
    {
        return this.upc;
    }
    public float getDuracion()
    {
        return this.duracion;
    }
    public int getTrack()
    {
        return this.track;
    }
    
    public Date getHora()
    {
        return this.hora;
    }
       
    // </editor-fold>
    
    
}
