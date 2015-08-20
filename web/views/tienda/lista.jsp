<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Actions.Discos.DiscosFunciones"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
    
   
    
                   <% 
                       
                        String tipo = request.getParameter("tipo");
                        if(!tipo.equals("artista") && !tipo.equals("genero"))
                        {%><br>
                         
                         <h1 style=" margin-left:20px; text-align: center;"> Resultado de listado</h1>  <hr>
                         <div style="margin-left:  15px;"><a href="t_index.jsp"><h4>&laquo; Volver atrás</h4></a></div> 
                         <h4 style=" margin-left:20px; text-align: center; font-style: italic;"> Parámetro de tipo desconocido.</h4>
                         
                      <%}else{
                        DiscosFunciones funciones = new DiscosFunciones();
                         
                        
                        ArrayList<String> lista = new ArrayList<String>();
                        
                        if(tipo.equals("artista"))
                        {lista = funciones.getListaArtistas();
                        
                        %>
                     
                        <br><h2 style="text-align: center;">Listado de Artistas</h2>  
                        <div style="margin-left:  15px;"><a href="t_index.jsp"><h4>&laquo; Volver atrás</h4></a></div> 
                        <hr>
                        <%
                        }else{ if(tipo.equals("genero"))
                                {lista = funciones.getListaGeneros();
                        %>
                       
                        <br> <h2 style="text-align: center;margin-top: 3px;">Listado de Géneros</h2> 
                        <% %>
                        <div style="margin-left:  15px;"><a href="t_index.jsp"><h4>&laquo; Volver atrás</h4></a></div> <hr>
                        <%
                                }
                            }
                        
                        
                        int i;
                        int f = lista.size();
                        
                        for(i=0;i<f;i++) 
                        { 
                            %>
                             
                            <div style="margin-left: 50px; ">
                                <a href="
                                   t_busqueda.jsp?texto=<%out.print(lista.get(i).toString());%>&tipo=<%out.print(tipo);%>&lista=true                                    
                                   "><strong># <%out.print( lista.get(i).toString() );%></strong></a><br>
                           </div>                                    
                                
                       <% } %> 
                        
                  <% } %> <br><br>
                      


              
</div>                
