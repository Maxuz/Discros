<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Actions.Util"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>
<%@page import="Model.Cancion"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
<br><h2 style="text-align: center;">Resultados de la búsqueda</h2>
    
     <% 
       //SE REALIZA ESTE CONTROL PARA VALIDAR QUÉ LINK SE LE ASIGNA A VOLVER ATRÁS
       String list = request.getParameter("lista");
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
     //RECUPERA PARÁMETRO DE LA URL
     String tipo = (String)request.getParameter("tipo");  
     String texto = (String)request.getParameter("texto");
   
     //SETEA VARIABLE DE CONTROL PARA VALIDAR LA URL
     boolean ctrlURL = false;
     
     //CONTROLA LOS PARÁMETROS ENVIADOS EN LA URL
     if(request.getParameter("texto")==null || request.getParameter("texto").toString().equals("") )
     {
            ctrlURL = false;
            //VALIDA HABER RECIBIDO ALGO DEL PARÁMETRO TIPO
            if(tipo!=null)
            {
                if(tipo.equals("todos"))
                { 
                    ctrlURL=true;
                }else{
                      ctrlURL=false;
                     }
            }else{
                ctrlURL = false;
            }
     }else{
            if(tipo!=null){
                ctrlURL=true;
            }else{
               ctrlURL=false; 
            }
         }
     
    //SEGÚN EL RESULTADO ANTERIOR, SIGUE CARGANDO EL CÓDIGO O MUESTRA MENSAJE DE ERROR 
    if(ctrlURL)
    { 
        String sPagActual = (String)request.getParameter("pagina");

        //VARIABLES PARA LAS CONSULTAS A LA BASE DE DATOS
        DiscosFunciones funciones = new DiscosFunciones();
        CancionesFunciones funcionesCanciones = new CancionesFunciones();

        //VARIABLES DE DISCOS
        Disco dis = new Disco();
        ArrayList<Model.Disco> lista = new ArrayList<Model.Disco>();

        //SETEA VARIABLE PARA CONTROLAR EL TIPO INGRESADO
        boolean ctrlTipo = false;

        //SEGÚN EL TIPO RECIBIDO OBTIENE EL 'INT' CORRESPONDIENTE PARA EL SWITCH
        Util util = new Util();
        int tipoInt = util.getInt(tipo);
       
        //CODIGO UTILIZADO EN LA PAGINACIÓN
        if(sPagActual == null || sPagActual.equals("")){
            sPagActual = "1";
        }
        int pagActual = Integer.parseInt(sPagActual);
        int cantPagina = 6;
        
        //EJECUTA LA CONSULTA CORRESPONDIENTE SEGÚN EL 'INT' OBTENIDO ANTERIORMENTE
        switch(tipoInt) {
            //TIPO TODOS           
            case 1:
                lista=funciones.getAll(pagActual, cantPagina);
                break;
            //TIPO ARTISTA    
            case 2:
                lista=funciones.getAll(tipo, texto, pagActual, cantPagina);
                break;
            //TIPO ALBUM    
            case 3:
                lista=funciones.getAll(tipo, texto, pagActual, cantPagina);
                break;
            //TIPO GENERO
            case 4:
                lista=funciones.getAll(tipo, texto, pagActual, cantPagina);
                break;
            //TIPO INCORRECTO
            case 0:
                ctrlTipo=true;
                break;
       }
    %>
    
            <!-- CÓDIGO QUE REALIZA EL CONTROL DE LA CARGA DE LA LISTA DE DISCOS-->
            <%
            //EVALÚA EL 'CTRLTIPO', SETEADO EN EL SWITCH ANTERIOR
            if(ctrlTipo)
            {%>     
                    <!-- HTML PARA UN TIPO DE BÚSQUEDA INCORRECTO -->
                    <h4 style="font-style: italic; margin-left:20px; text-align: center;"> NO SE RECONOCE EL TIPO DE BÚSQUEDA QUE DESEA REALIZAR.<br>
                    Por favor, intente nuevamente.</h4>  <br><br><br>

         <%}else{
                //EL TIPO ES CORRECTO, POR LO TANTO SE OBTUVO UNA LISTA 
                int i;
                int f = lista.size();
                
                //EVALÚA EL TAMAÑO DE LA LISTA
                if(f==0)
                    {
                    //LISTA VACÍA, MUESTRA MENSAJE
                    %><!-- HTML PARA UN RESULTADO DE BÚSQUEDA VACÍO -->
                    <h4 style="font-style: italic; margin-left:20px; text-align: center;">Cantidad de resultados: <%out.print(f);;%> <br>
                    No se han encontrado resultados para su búsqueda.</h4>  <br><br><br>

                    <%}else{%>

                        <h4 style="font-style: italic; margin-left:  20px">Cantidad de resultados: <%out.print(f);;%></h4>
                        <ul id="cd-gallery-items" class="cd-container" style="padding-top: 20px;">	
                        <%  
                        
                        //CARGA TODOS LOS DISCOS DE LA LISTA RECIBIDA
                        for(i=0;i<f;i++) 
                        { dis = lista.get(i); 
                          double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                          String aux = dis.getImagen();
                        %>
                         <li>
                            <img src="<%out.print(aux);%>" alt="Preview image" class="img-responsive" style=" float: left;" >
                            <div class="texto-tienda" style="text-align: left;" id="disco">         
                                <div>
                                    <strong>Artista: </strong><%out.print(dis.getArtista());%><br>
                                    <strong>Album: </strong><%out.print(dis.getAlbum());%> <br>
                                    
                                    <%
                                       int cant = dis.getStock();
                                       
                                       //EVALÚA EL STOCK, SI HAY STOCK MUESTRA EL BOTÓN PARA COMPRAR
                                       if(cant != 0){%>
                                        <button id="agregarItem" onclick="agregar('<% out.print(dis.getUpc());%>' )" style="float: left; margin-left: 20px; margin-top: 10px;">
                                        <img src="img/addCarrito.png" style="width: 50px; height: 50px; float: right;" alt="Agregar al carrito" title="Agregar al carrito"/>
                                        </button> 
                                     <%}else{
                                            //MUESTRA MENSAJE DE FALTANTE DE STOCK
                                            %> 
                                            <strong style="color: red;">Sin stock</strong>
                                            <%}%>
                                    
                                    <!-- BOTÓN QUE ABRE MODAL PARA MOSTRAR DETALLES DEL DISCO-->
                                    <a class="btn btn-info" data-toggle="modal" data-target="#layer<%= dis.getUpc() %>" style="margin-left: 30px; margin-top: 20px;">Mostrar m&aacute;s..</a></br></br>
                                </div>
                                
                                <!-- DECLARACIÓN DEL MODAL -->
                                <div id="layer<%= dis.getUpc() %>" class="modal fade" role="dialog">
                                    <div class="modal-dialog">
                                        
                                        <!-- CONDENIDO DEL MODAL-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Informaci&oacute;n del disco</h4>
                                            </div>
                                            
                                            <!--MUESTRA LOS DETALLES DEL DISCO-->
                                            <div class="modal-body">
                                                <strong>Artista: </strong><%out.print(dis.getArtista());%><br>
                                                <strong>Album: </strong><%out.print(dis.getAlbum());%> <br>
                                                <strong>Género: </strong><%out.print(dis.getGenero());%> <br>
                                                <strong>Precio: </strong>$<%out.print(precio);%> <br>
                                                <%
                                                   //VERIFICA SI HAY STOCK 
                                                   if(cant > 0){
                                                      out.print("<strong>En stock</strong>");
                                                   }
                                                %> <br><br>
                                                <%
                                                //CREA VARIABLES DE CANCIONES PARA TRABAJAR CON LA TABLA   
                                                Cancion can = new Cancion();
                                                ArrayList<Model.Cancion> listaCancion;
                                                
                                                //TRAE TODAS LAS CANCIONES DEL DISCO
                                                listaCancion = funcionesCanciones.getAll(dis.getUpc());

                                                int s = listaCancion.size();
                                                %>
                                                <div>
                                                    <table class="table" style="font-size: 14px;">
                                                        <tr>
                                                            <th style="width: 15%">Track</th>
                                                            <th style="width: 60%">Nombre</th>
                                                            <th style="width: 25%">Duraci&oacute;n</th>
                                                        </tr>
                                                        <% 
                                                        //RECORRE LISTA DE CANCIONES PARA CARGAR DATOS    
                                                        for(int j = 0; j < s; j++) 
                                                        {
                                                            can = listaCancion.get(j);%>
                                                            <tr>
                                                                <td style="width: 15%"><%= can.getTrack() %></td>
                                                                <td style="width: 60%"><%= can.getNombre() %></td>
                                                                <td style="width: 25%"><%= can.getDuracion() %></td>
                                                            </tr>
                                                        <%
                                                        }
                                                        %>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    <% } %>
		</ul> <!-- cd-gallery-items -->
                 
            <%}    
    }    
    
    //CODIGO PARA PAGINAR PÁGINA
    if(!ctrlTipo){
    %>
    <div style="text-align: center; font-size: 18px;">
        <%
        int cant = 0;
        if(tipoInt == 1) {
            cant = funciones.cantDiscos();
        }
        else{
            cant = funciones.cantDiscos(tipo, texto);
        } 
        int totalPag = (int)Math.ceil((double)cant / (double)cantPagina);
        for(int c = 1; c <= totalPag; c++)
        {
            if(tipoInt == 1){
                %><a href="t_busqueda.jsp?tipo=<%= tipo %>&pagina=<%= c %>"> <%= c %> </a><%
            }
            else{
                %><a href="t_busqueda.jsp?texto=<%= texto %>&tipo=<%= tipo %>&pagina=<%= c %>"><%= c %></a><%
            }
        }%>
    </div>
<%}
}else{//URL INCORRECTA
        %>
        <h4 style="font-style: italic; margin-left:20px; text-align: center;"> URL INCORRECTA.<br>
        Por favor, intente nuevamente.</h4>  <br><br><br>
     <%}%>
    
</div>                
 