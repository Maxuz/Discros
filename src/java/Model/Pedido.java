package Model;

import java.util.Date;


public class Pedido {
    
    
    
    // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private int id_pedido;
    private float valor;
    private Date fecha;
    private Date fecha_entrega;
    
    //VARIABLES DE ESTADO
    private String entrega;
    private String pago;
    private String forma;
    
    //CLAVE FORÁNEA
    private String email;
    
    
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
    
    public Pedido()
    {}
    
    public Pedido(int id, float valor, Date fecha_c, String entrega, String pago, String forma, String email)
    {
        this.id_pedido=id;
        this.valor=valor;
        this.fecha=fecha_c;
        this.entrega=entrega;
        this.pago=pago;
        this.forma=forma;
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
        this.entrega=estado;
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
        return this.entrega;
    }
    
    public String getPago()
    {
        return this.pago;
    }
    
    public String getFormaPago()
    {
        return this.forma;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    // </editor-fold>
    
    
    
}
