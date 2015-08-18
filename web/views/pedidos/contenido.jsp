
<%@page import="Model.Disco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="Model.Pedido"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
   
     <!-- CONTROLA SI HAY UN USUARIO LOGUEADO-->
    <% if(session.getAttribute("nombre")==null){%>
        <br><h3 style="text-align: center; font-style: italic;">Lo sentimos, acceso sólo para usuarios logueados.</h3>
        <h4 style="text-align: center;"><a href="u_login.jsp" >Inicie sesión</a></h4><hr><br>
     
        <%   response.sendRedirect("u_login.jsp"); }  
    else {%>
                <!-- MÓDULO PARA USUARIOS LOGUEADOS -->
                 <br><h2 style="text-align: center;">Confirmar pedido</h2><hr>
                 
                 <% CancionesFunciones funcionesCanciones = new CancionesFunciones();
                    //ArrayList<Model.Pedido> lista = new ArrayList<Model.Pedido>();
                    
                    if((ArrayList<Model.Disco>)session.getAttribute("listaCarrito")!=null)
                    {
                        ArrayList<Model.Disco> lista = (ArrayList<Model.Disco>)session.getAttribute("listaCarrito");
                        
                    int cantidad = lista.size();
                    int i;
                    Model.Disco dis = new Disco();
                            if(cantidad==0){%> <h3 style="text-align: center; font-style: italic;">Aún no tiene ningúna compra realizada.</h3> <%};%>
                     
                                <!-- TABLA DE CANCIONES: RECORDAR QUE EL PRECIO DE UN DISCO ES LA CANCION DEL DISCO CON CÓDIGO = 0-->
                                <div class="table-responsive" style="margin-left: 10%; margin-right: 10%;">
                                 <table class="table" id="tablaCanciones">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 <tr>
                                     <td><strong>Artista</strong></td>
                                     <td><strong>Album</strong></td>
                                     <td><strong>Genero</strong></td>
                                     <td><strong>Fecha</strong></td>
                                     <td><strong>Descripción</strong></td>
                                     <td><strong>Imagen</strong></td>
                                     <td><strong>Precio</strong></td>
                                 </tr>
                                  
                                 <!-- VERIFICA SI HAY OBJETOS EN LA LISTA PARA MOSTRALOS-->
                                 <%     if(cantidad!=0){
                            
                                        for(i=0;i<cantidad;i++)
                                        {   dis= lista.get(i);
                                            double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                                            
                                            %>
                                             <tr>
                                             <td><%out.print(dis.getArtista()); %></td>
                                             <td><%out.print(dis.getAlbum()); %></td>
                                             <td><%out.print(dis.getGenero()); %></td>
                                             <td><%out.print(dis.getFecha()); %></td>
                                             <td><%out.print(dis.getDescripcion()); %></td>
                                             <td><%out.print(dis.getImagen()); %></td>
                                             <td>$ <%out.print(precio); %></td>
                                             </tr>
                                            <%
                                        }
                                        
                                        };%>
                                        <tr>
                                            <td><strong>Total</strong></td>
                                             <td></td>
                                             <td></td>
                                             <td></td>
                                             <td></td>
                                             <td></td>
                                             <td><strong>$ <% out.print(session.getAttribute("totalValorCarrito")); %></strong></td>
                                             
                                             </tr>
                                        </table>
                                        <a class="btn btn-primary btn-large" style="float: right;" href="pAlta.do">Confirmar</a> <br><br>
                                        </div>
                                       
                                     
          <%}else{ %>
            <br><h3 style="text-align: center; ">El carrito esta vacio, para realizar su compra ingrese a la tienda</h3><hr>
            <h3 style="text-align: center;"><a href="t_index.jsp">Ingresar a la Tienda</a> </h3><br>
                    <%};
                        } %>
</div>                
