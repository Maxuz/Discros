package Model;

import java.util.Date;


public class PedidoReporte{
    
    
    
    // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private int id_pedido;
    private Date fecha;
    private String estado;
    private String email;
    private String nombre;
    private String apellido;
    
    
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
    
    public PedidoReporte()
    {}
     
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS ">
   
    
    //SET QUE SE USA EN EL GETALLPENDIENTE DE PEDIDOSFUNCIONES
    public void setDatos(int id, Date fecha_c, String entrega, String email, String nombre,  String apellido)
    {
        this.id_pedido=id;
        this.fecha=fecha_c;
        this.estado=entrega;
        this.email=email;
        this.nombre=nombre;
        this.apellido=apellido;
    }
   
    
    // </editor-fold>
    
    // <editor-fold desc="GET DE DATOS">
    public int getID()
    {
        return this.id_pedido;
    }
    
    
    public Date getFecha()
    {
        return this.fecha;
    }
    
    public String getEstado()
    {
        return this.estado;
    }

    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getApellido()
    {
        return this.apellido;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    
    // </editor-fold>
    
    
    
}
