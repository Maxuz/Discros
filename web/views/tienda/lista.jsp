<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Actions.Discos.DiscosFunciones"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
    
   
                   <%  
                        DiscosFunciones funciones = new DiscosFunciones();
                         
                        
                        ArrayList<String> lista = new ArrayList<String>();
                        String tipo = request.getParameter("tipolista");
                        
                        
                        if(tipo.equals("artista"))
                        {lista = funciones.getListaArtistas();
                        
                        %>
                     
                        <br><h2 style="text-align: center;">Listado de Artistas</h2>  
                        <div style="margin-left:  15px;"><a href="javascript:window.history.back();"><h4>&laquo; Volver atrás</h4></a></div> 
                        <hr>
                        <%
                        }else{ if(tipo.equals("genero"))
                                {lista = funciones.getListaGeneros();
                        %>
                       
                        <br> <h2 style="text-align: center;margin-top: 3px;">Listado de Géneros</h2> 
                        <div style="margin-left:  15px;"><a href="javascript:window.history.back();"><h4>&laquo; Volver atrás</h4></a></div> <hr>
                        <%
                                }
                            }
                        
                        
                        int i;
                        int f = lista.size();
                        
                        for(i=0;i<f;i++) 
                        { 
                            %>
                             
                            <div style="margin-left: 50px; ">
                                <a href="#"><strong># <%out.print( lista.get(i).toString() );%></strong></a><br>
                           </div>                                    
                                
                       <% } %> <br><br>
                      


              
</div>                
