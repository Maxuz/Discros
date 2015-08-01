
package Model;


public class Cancion {
     
   // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private String nombre;
    private float precio;
    private int isrc;
    private int track;
    private float duracion;
    
    //CLAVE FORÁNEA
    private int upc;
    
    
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
     public Cancion()
     { }
    
     public Cancion(String nombre, float precio, int isrc, int upc, float duracion, int track)
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
     public void setDatos(String nombre, float precio, int isrc, int upc, float duracion, int track)
     {
     this.nombre=nombre;
     this.precio=precio;
     this.isrc=isrc;
     this.upc=upc;
     this.duracion=duracion;
     this.track=track;
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
    public int getIsrc()
    {
        return this.isrc;
    }
    public int getUpc()
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
       
    // </editor-fold>
    
    
}
