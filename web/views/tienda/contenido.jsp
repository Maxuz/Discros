<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>

<div style="margin-top: 60px; background-color: floralwhite; margin-bottom: 10px">
    <br><h2 style="text-align: center;">Tienda virtual</h2>
    <ul id="cd-gallery-items" class="cd-container" style="padding-top: 20px">
			
                   <% 
                       
                        DiscosFunciones funciones = new DiscosFunciones();
                        CancionesFunciones funcionesCanciones = new CancionesFunciones();
                        Disco dis = new Disco();
                        ArrayList<Model.Disco> lista = new ArrayList<Model.Disco>();
                        
                        lista = funciones.getAll();
                        
                        int i;
                        int f = lista.size();
                        for(i=0;i<f;i++) 
                        { dis = lista.get(i); 
                          double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                            %>
                             <li>
                                 <img src="img/thumb.jpg" alt="Preview image" class="img-responsive" style=" float: left;" >
                                 <div class="texto-tienda" style="text-align: left;">
                                     
                                     <strong>Artista:</strong><%out.print(dis.getArtista());%><br>
                                     <strong>Album:</strong><%out.print(dis.getAlbum());%> <br>
                                     <strong>Precio:</strong>  $<%out.print(precio);%> <br>
                                     <strong>Stock:</strong><%out.print(dis.getStock());%> <br>
                                     <a href="#">Ver canciones..</a><br><br>
                                     <button id="<% out.print(dis.getUpc());%>">Agregar a carrito</button>
                                     
                                 </div>
                                </li>
                                
                       <% } %>
                       

		</ul> <!-- cd-gallery-items -->
                
</div>                