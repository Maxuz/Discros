package Model;

public class PedidosCanciones {

    // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private int id_pedido;
    private int isrc;
    private int upc;
    private int cantidad;
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
    
    public PedidosCanciones()
    {}
    public PedidosCanciones(int id_pedido, int isrc, int upc, int cantidad)
    {
    this.id_pedido=id_pedido;
    this.isrc=isrc;
    this.upc=upc;
    this.cantidad=cantidad;
    }

   
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS ">
    
    public void setDatos(int id, int upc, int isrc,int cantidad)
    {
        this.id_pedido=id;
        this.upc=upc;
        this.isrc=isrc;
        this.cantidad=cantidad;
    }
    
    // </editor-fold>
    
    // <editor-fold desc="GET DE DATOS">
    public int getId_pedido()
    {
        return this.id_pedido;
    }
    public int getIsrc()
    {
        return this.isrc;
    }
    public int getUpc()
    {
        return this.upc;
    }
    public int getCantidad()
    {
        return this.cantidad;
    }
    // </editor-fold>
    

}
