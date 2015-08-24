
package Model;


public class Cancion {
     
   // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private String nombre;
    private float precio;
    private long isrc;
    private int track;
    private float duracion;
    
    //CLAVE FORÁNEA
    private long upc;
    
    //NO SE GUARDA EN LA TABLA CANCIÓN. SIRVEN PARA TRABAJAR EN: 'p_confirmar.jsp', 'p_excedeConfirmar.jsp' Y 'pAlta.do' PARA LUEGO CARGAR EN LA TABLA PEDIDOS_CANCIONES.
    private int cantidad;
    private int excede;
    
    //NO SE GUARDA EN LA TABLA CANCIÓN, SIRVEN PARA TRABAJAR EN: 'u_pedidosDetalle.jsp', PARA LUEGO REALIZAR LAS BÚSQUEDAS DE LAS CANCIONES EN LOS PEDIDOS.
    private String artista;
    private String album;
    
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
     
     //SET DE DATOS PARA LA BASE DE DATOS
     public void setDatos(String nombre, float precio,long isrc, long upc, float duracion, int track)
     {
     this.nombre=nombre;
     this.precio=precio;
     this.isrc=isrc;
     this.upc=upc;
     this.duracion=duracion;
     this.track=track;
     }
     
     //SET DE DATOS PARA LAS VARIABLES TEMPORALES
     public void setCantidad(int cant)
     {
         this.cantidad = cant;
     }
   
     public void setExcede(int excede)
     {
         this.excede=excede;
     }
     
     public void setArtista(String artista)
     {
         this.artista=artista;
     }

     public void setAlbum(String album)
     {
         this.album=album;
     }
     
     public void setUPC(long upc)
     {
         this.upc=upc;
     }
     
    // </editor-fold>
    
    // <editor-fold desc="GET DE DATOS">
   
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

     
    //GET PARA VARIABLES TEMPORALES 
    public int getExcede()
    {
        return this.excede;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public String getArtista()
    {
         return this.artista;
     }

    public String getAlbum()
    {
         return this.album;
     }
     
    public int getCantidad()
    {
    return this.cantidad;
    }
       
    // </editor-fold>
    
    
}
