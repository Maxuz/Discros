package Actions;

import java.sql.Date;

import java.text.SimpleDateFormat;


public class Util {
 
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
    
    //MÉTODO PARA CODIFICAR LA CONTRASEÑA 
    
    
    //MÉTODO CREADO PARA CONVERTIR JAVA.UTIL.DATE EN JAVA.SQL.DATE Y PODER GUARDAR EN LA BASE DE DATOS
    public static Date convertUtilDateToSqlDate(java.util.Date date){
        if(date != null) {
            Date sqlDate = new Date(date.getTime());
            return sqlDate;
        }
        return null;
    }   
    
    //MÉTODO PARA OBTENER LA FECHA ACTUAL
    public void fechaActual()
    {
        java.util.Date dNow = new java.util.Date();
        SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
        String currentDate = ft.format(dNow);
    }
    
}
