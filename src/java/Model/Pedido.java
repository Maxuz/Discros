package Model;

import java.util.Date;


public class Pedido {
    
    
    
    // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private int id_pedido;
    private float valor;
    private Date fecha;//VERIFICAR CÓMO SE USA LA VARIABLE DATE
    private String estado;
    
    //CLAVE FORÁNEA
    private String email;
    
    
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
    
    public Pedido()
    {}
    
    public Pedido(int id, float valor, Date fecha_c, String estado, String email)
    {
        this.id_pedido=id;
        this.valor=valor;
        this.fecha=fecha_c;
        this.estado=estado;
        this.email=email;
        
    }
   
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS ">
    
    public void setDatos(int id, float valor, Date fecha_c, String estado, String email)
    {
        this.id_pedido=id;
        this.valor=valor;
        this.fecha=fecha_c;
        this.email=email;
        this.estado=estado;
    }
    
   
    
    // </editor-fold>
    
    // <editor-fold desc="GET DE DATOS">
    public int getID()
    {
        return this.id_pedido;
    }
    
    public float getValor()
    {
        return this.valor;
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
    // </editor-fold>
    
    
    
}
