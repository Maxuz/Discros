package Model;


public class Usuario {
    
    // <editor-fold desc="DEFINICIÓN DE VARIABLES">
    private String email;
    private String pass;
    
    private String tipo;
    
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String provincia;
    private int dni;
    private Boolean estado;
    // </editor-fold>  

    // <editor-fold desc="CONSTRUCTORES">
    
    
    public Usuario(){}

    public Usuario(String email, String pass,String nombre, String apellido, String direccion, String ciudad, String provincia, Integer dni) {
        this.email = email;
        this.pass = pass;
        
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.provincia=provincia;
        this.dni=dni;
       
        this.tipo = "cliente";
        this.estado = true;
    }
    
    public Usuario(String email, String pass) {
        this.email = email;
        this.pass = pass;
        
     
    }
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS PERSONALES USADO EN EL ALTA DEL USUARIO">
    public void setDatos(String email, String pass, String nombre, String apellido, String direccion, String ciudad, String provincia, Integer dni, String tipo, boolean estado)
    {   this.email=email;
        this.pass=pass;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.provincia=provincia;
        this.dni=dni;
        this.tipo = tipo;
        this.estado = estado;
    }    
    // </editor-fold>
    
    // <editor-fold desc="SET DE DATOS PERSONALES USADO EN EL ALTA DEL USUARIO">
    public void setDatospersonales(String nombre, String apellido, String direccion, String ciudad, String provincia, Integer dni)
    {   
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.provincia=provincia;
        this.dni=dni;
        this.tipo = "cliente";
    }    
    // </editor-fold>
    
    // <editor-fold desc="GETS DATOS DE SESION">
    public String getEmail()
    {
        return this.email;
    }
   
    public boolean getEstado()
    {
        return this.estado;
    }
    
    public String getPass()
    {
        return this.pass;
    }
    // </editor-fold>
    
    // <editor-fold desc="GETS DATOS PERSONALES">
    public String getNombre()
    {return this.nombre;
    }
    
    public String getApellido()
    {return this.apellido;
    }
    
    public String getDireccion()
    {return this.direccion;
    }
    
    public String getCiudad()
    { return this.ciudad;
    }
    
    public String getProvincia()
    { return this.provincia;
    }
    
    public Integer getdni()
    { return this.dni;
    }
    
    public String getTipo()
    {
        return this.tipo;
    }
    // </editor-fold>
    
   
   
}
