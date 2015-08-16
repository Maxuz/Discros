<%@page import="java.util.*"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>

<div style="margin-top: 60px; background-color: floralwhite; margin-bottom: 10px">
    <br><h2 style="text-align: center;">Tienda virtual</h2>
    <ul id="cd-gallery-items" class="cd-container" style="padding-top: 20px">
			
                   <% 
                        try{ 
                        DiscosFunciones funciones = new DiscosFunciones();
                        Disco dis = new Disco();
                     //   ArrayList<Disco> lista = new ArrayList<>();
                        ArrayList<Model.Disco> lista = new ArrayList<Model.Disco>();
                        lista = funciones.getAll();
                        
                        int i;
                        int f = lista.size();
                        for(i=0;i<f;i++) 
                        {%>
                             <li>
                                 <img src="img/thumb.jpg" alt="Preview image" class="img-responsive" style=" float: left;" >
                                 <div class="texto-tienda">
                                     
                                     Artista: <% dis = lista.get(i); 
                                                 out.print(dis.getArtista()); 
                                              %> <br>
                                     Album:<br>
                                     Ver Canciones:<br>
                                 </div>
                                </li>
                       <% }
                       
                        }
                       catch (Exception e)
                       {
                                        session.setAttribute("errorCatch", e.toString());
                                        RequestDispatcher rd =null;
                                                                               
                                        rd=request.getRequestDispatcher("error.jsp");
                                        rd.forward(request,response);
                       }
                       %>
                       

		</ul> <!-- cd-gallery-items -->
                
</div>                