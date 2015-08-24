package Actions.Discos;

import Model.Disco;
import java.util.ArrayList;

public class utilDiscos {
    
 public String getArtista(ArrayList<Disco> lista, long upc)
 {
     for(Disco dis:lista)
     {
         if(dis.getUpc()==upc)
         {
             return dis.getArtista();
         }
     }
     
     return null;
 }
    
 public String getAlbum(ArrayList<Disco> lista, long upc)
 {
     for(Disco dis:lista)
     {
         if(dis.getUpc()==upc)
         {
             return dis.getAlbum();
         }
     }
     
     return null;
 }   
 
  public int getStock(ArrayList<Disco> lista, long upc)
 {
     for(Disco dis:lista)
     {
         if(dis.getUpc()==upc)
         {
             return dis.getStock();
         }
     }
     
     return 0;
 }   
    
}
