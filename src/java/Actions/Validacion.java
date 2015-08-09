package Actions;


public class Validacion {
    
    public boolean estaVacio (String var)
    {   return (var==null && var.length()==0);
    }
    
    public boolean esIgual (String cadena1, String cadena2)
    {
        if (cadena1.equals(cadena2))
            {return true;}
        else
            {return false;}
    }
    
}
