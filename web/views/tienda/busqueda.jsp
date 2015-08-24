<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Actions.Util"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>
<%@page import="Model.Cancion"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
    <br><h2 style="text-align: center;">Resultados de la búsqueda</h2>
    
    
    
     <% String list = request.getParameter("lista");
       if(list==null)
       {%>
            <div style="margin-left:  15px;"><a href="t_index.jsp"><h4>&laquo; Volver atrás</h4></a></div> <hr>
       <%}
       else
       {%>
       <div style="margin-left:  15px;"><a href="t_listas.jsp?tipo=<%out.print(request.getParameter("tipo"));%>"><h4>&laquo; Volver atrás</h4></a></div> <hr>
     <%}%>     
    
    <!-- CÓDIGO PARA CARGAR EL ARRAY DE LOS DISCOS -->
    <%  
     
    //VARIABLES PARA LAS SOLICITUDES A LA BASE DE DATOS
    DiscosFunciones funciones = new DiscosFunciones();
    CancionesFunciones funcionesCanciones = new CancionesFunciones();

    //VARIABLES DE DISCOS
    Disco dis = new Disco();
    ArrayList<Model.Disco> lista = new ArrayList<Model.Disco>();

    //VARIABLES AUXILIARES
    boolean ctrlTipo = false;

    //RECUPERA PARÁMETRO DE LA URL
    String tipo = (String)request.getParameter("tipo");
       
    //SEGÚN EL TIPO RECIBIDO REALIZA LA CONSULTA PERTINENTE
        Util util = new Util();
        int tipoInt = util.getInt(tipo);
        String texto = (String)request.getParameter("texto");
        
        switch(tipoInt) {
            //TODOS           
            case 1:
                lista=funciones.getAll();
                break;
            //ARTISTA    
            case 2:
                lista=funciones.getAll(tipo, texto);
                break;
            //ALBUM    
            case 3:
                lista=funciones.getAll(tipo, texto);
                break;
            //GENERO
            case 4:
                lista=funciones.getAll(tipo, texto);
                break;
            //TIPO INCORRECTO
            case 0:
                ctrlTipo=true;
                break;
           
       }
    
    
    %>
    
    <!-- CÓDIGO QUE REALIZA EL CONTROL DE LA CARGA DE LA LISTA DE DISCOS-->
    <% 
       
    int i;
    int f = lista.size();


    if(ctrlTipo)
    {%> <!-- HTML PARA UN TIPO DE BÚSQUEDA INCORRECTO -->
            <h4 style="font-style: italic; margin-left:20px; text-align: center;"> NO SE RECONOCE EL TIPO DE BÚSQUEDA QUE DESEA REALIZAR.<br>
            Por favor, intente nuevamente.</h4>  <br><br><br>
        
    <%}else{
            if(f==0)
            {%><!-- HTML PARA UN RESULTADO DE BÚSQUEDA VACÍO -->
            <h4 style="font-style: italic; margin-left:20px; text-align: center;">Cantidad de resultados: <%out.print(f);;%> <br>
            No se han encontrado resultados para su búsqueda.</h4>  <br><br><br>
            
            <%}else{%>
                
            <h4 style="font-style: italic; margin-left:  20px">Cantidad de resultados: <%out.print(f);;%></h4>
                <ul id="cd-gallery-items" class="cd-container" style="padding-top: 20px;">
			
                   <%  
                        for(i=0;i<f;i++) 
                        { dis = lista.get(i); 
                          double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                            %>
                             <li>
                                 <img src="img/thumb.jpg" alt="Preview image" class="img-responsive" style=" float: left;" >
                                 <div class="texto-tienda" style="text-align: left;" id="disco">
                                     
                                     <strong>Artista:</strong><%out.print(dis.getArtista());%><br>
                                     <strong>Album:</strong><%out.print(dis.getAlbum());%> <br>
                                     <strong>Género:</strong><%out.print(dis.getGenero());%> <br>
                                     <strong>Precio:</strong>  $<%out.print(precio);%> <br>
                                     
                                     <% boolean stock = false;
                                        int cant = dis.getStock();
                                        if(cant>0){
                                        out.print("<strong>En stock: "+cant+" disponibles.</strong>");
                                        stock=true;
                                        }else{
                                        %><strong style="color: red;">Sin stock</strong>
                                        <%}
                                     %> <br>
                                     
                                    
                                     <% ArrayList<Model.Cancion> listaCancion;
                                        listaCancion = funcionesCanciones.getAll(dis.getUpc());
                                        int s = listaCancion.size();
                                        
                                        if(s>1)
                                        {
                                     %>
                                    <a onclick="show('layer<%= dis.getUpc() %>')" style="cursor: pointer">Mostrar canciones..</a></br></br>
                                    <div id="layer<%= dis.getUpc() %>" style="display:none;">
                                        <div style="border: ridge #0f0fef 1px;">
                                            <%
                                            Cancion can = new Cancion();
                                            

                                            
                                            %>
                                            <div>
                                                <table>
                                                    <tr>
                                                        <th>Track</th>
                                                        <th>Nombre</th>
                                                        <th>Duraci&oacute;n</th>
                                                        <th>Precio</th>
                                                        <th></th>
                                                    </tr>
                                                    <% for(int j = 0; j < s; j++) 
                                                    {
                                                        can = listaCancion.get(j);%>
                                                        <tr>
                                                            <td><%= can.getTrack() %></td>
                                                            <td><%= can.getNombre() %></td>
                                                            <td><%= can.getDuracion() %></td>
                                                            <td><%= can.getPrecio() %></td>
                                                        </tr>
                                                    <%
                                                    }
                                                    %>
                                                </table>
                                            </div>
                                        </div>
                                     </div>
                                    <%}%>
                                     
                                </div>
                                 <%if(stock){%>               
                                <button id="agregarItem" onclick="agregar('<% out.print(dis.getUpc());%>' )">

                                    <img src="img/addCarrito.png" style="width: 50px; height: 50px; float: right;" alt=""/>
                                </button>
                                 <%}%>
                           </li>
                                
                       <% } %>
                      

		</ul> <!-- cd-gallery-items -->
                 
            <%}    
    }                 
    %>
    
   
              
</div>                
