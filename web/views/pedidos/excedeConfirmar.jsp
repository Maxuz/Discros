
<%@page import="Actions.Discos.DiscosFunciones"%>
<%@page import="Actions.Discos.utilDiscos"%>
<%@page import="Model.Usuario"%>
<%@page import="Model.Disco"%>
<%@page import="Model.Cancion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="Actions.Usuarios.UsuariosFunciones"%>
<%@page import="Model.Pedido"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
 <div class="row" style="margin-left: 10%; margin-right: 10%; ">  
     
     
     <!-- CONTROLA SI HAY UN USUARIO LOGUEADO-->
     
    <% //BLOQUEA SI NO HAY USUARIO REGISTRADO
        
        if(session.getAttribute("nombre")==null){%>
        <br><h3 style="text-align: center; font-style: italic;">Lo sentimos, acceso sólo para usuarios logueados.</h3><hr>
        <h4 style="text-align: center;"><a href="u_login.jsp" >Inicie sesión</a></h4><hr><br>
     
        <%   response.sendRedirect("u_login.jsp"); }  
        else {
                //MUESTRA MENSAJE DE ÉXITO    
                %>
                <%  
                if(session.getAttribute("mensajeExito")!=null)
                {%>
                <h1 style="font-style: italic; text-align: center;"><% out.print(session.getAttribute("mensajeExito").toString());%></h1>
               <%}
                else{
                 
                    //VERIFICA SI EL USUARIO HA INTENTADO FINALIZAR EL PEDIDO PREVIAMENTE 
                    if((ArrayList<Model.Disco>)session.getAttribute("listaCanciones")==null)
                    {  %>
                    
                         <!-- USUARIOS LOGUEADOS, QUE NO FINALIZARON EL PEDIDO  -->
                         <br><h3 style="font-style: italic; text-align: center;">Lo sentimos, pero primero debe finalizar un pedido.</h3><hr><br><br><br>
                  <%}else{
                   %>   
                   
                   
                        <!-- USUARIOS LOGUEADOS, QUE FINALIZARON EL PEDIDO PERO SU PEDIDO TIENE PROBLEMAS EN EL STOCK -->
                        <br><h2 style="text-align: center;">Problemas en el Stock</h2><hr>
                        <h3 style="text-align: center;">Los siguientes discos tienen problemas con el stock.</h3><br>
                        
                       <!-- TABLA DE DISCOS QUE TIENEN PROBLEMAS CON EL STOCK -->
                                 
                                 <div class="table-responsive"  id="itemsPedido">
                                 <table class="table" id="tablaCanciones" style="text-align: center;">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 
                                 <tr>
                                     <td><strong>Artista</strong></td>
                                     <td><strong>Album</strong></td>
                                     <td><strong>Precio</strong></td>
                                     <td><strong>Cant. en pedido</strong></td>
                                     <td><strong>Stock</strong></td>
                                     <td><strong>Excedente</strong></td>
                                 </tr>
                                   
                           
                           <%
                           ArrayList<Model.Cancion> lista = (ArrayList<Model.Cancion>)session.getAttribute("listaCanciones");
                           ArrayList<Model.Disco> carrito = (ArrayList<Model.Disco>)session.getAttribute("listaCarrito");
                           utilDiscos utilD = new utilDiscos();
                           
                           int i, cant = lista.size();
                           
                           for (i=0; i<cant ;i++)
                           {
                               Cancion can = lista.get(i);
                               int excede = can.getExcede();
                               
                            if(excede>0){  
                                
                                        
                            %>    
                               
                            <tr >
                             <td><%out.print(utilD.getArtista(carrito, can.getUpc())); %></td>
                             <td><%out.print(utilD.getAlbum(carrito, can.getUpc())); %></td>
                             <td>$<%out.print(can.getPrecio()); %></td>
                             <td><%out.print(can.getCantidad()); %></td>
                             <td><%out.print(utilD.getStock(carrito, can.getUpc())); %></td>
                             <td style="color: red;"><strong><%out.print(can.getExcede()); %></strong></td>
                             </tr>
                                 
                        <%}
                           lista.get(i).setCantidad(utilD.getStock(carrito, can.getUpc()));
                           }%>
                        
                           </table>
                           </div>
                           <hr>
                           
                             <h5 style="font-style: italic; text-align: center;"> 
                             Le proponemos el siguiente pedido, donde se reduce la cantidad de discos que va a comprar al número del stock disponible.<br> 
                             Si usted presiona <strong>Realizar compra</strong>, en este paso usted da por finalizado el pedido que se detalla al final de la página.
                             <br>
                             Sino, presione <strong>Cancelar pedido</strong> y modificarlo luego como usted quiera.<br>
                             Muchas gracias.
                             </h5>
                            <hr>
                            
                            
                            
                         <!-- TABLA QUE TIENE LOS DATOS DEL PEDIDO PROPUESTO-->        
                         <div class="table-responsive"  id="itemsPedido">
                         <table class="table" id="tablaCanciones" style="text-align: center;">
                         <!-- CODIGO PARA EL ENCABEZADO-->
                         <tr>
                             <td><strong>Artista</strong></td>
                             <td><strong>Album</strong></td>
                             <td><strong>Cantidad</strong></td>
                             <td><strong>Valor unitario</strong></td>
                             <td><strong>Valor Total</strong></td>
                         </tr>
                           <%
                           float temp=0;
                           session.setAttribute("valorTotalCarrito", null);
                           for (i=0; i<cant ;i++)
                           {
                               Cancion can = lista.get(i);
                                        
                            %>    
                               
                            <tr >
                             <td><%out.print(utilD.getArtista(carrito, can.getUpc())); %></td>
                             <td><%out.print(utilD.getAlbum(carrito, can.getUpc())); %></td>
                             <td><%out.print(can.getCantidad()); %></td>
                             <td>$<%out.print(can.getPrecio()); %></td>
                             <td>$<%out.print(can.getPrecio()*can.getCantidad()); %></td>
                            </tr>
                                 
                            <% 
                                if(session.getAttribute("valorTotalCarrito")==null)
                                {
                                   temp= can.getPrecio()*can.getCantidad();
                                   
                                }else   {
                                            temp = temp + can.getPrecio()*can.getCantidad() ;
                                        }
                            
                               session.setAttribute("valorTotalCarrito", temp);
                           }
                        
                           session.setAttribute("listaCanciones", null);
                           session.setAttribute("listaCanciones", lista);
                          %>
                          <tr>
                              <td><strong>TOTAL</strong></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td><strong>$<%out.print(session.getAttribute("valorTotalCarrito")); %></strong></td>
                          </tr>
                              
                          
                           </table>
                           </div>
                           <br><br>
                           <input type="button"  class="btn btn-primary btn-large" value="Realizar compra" onClick=" window.location.href='pAlta.do' "> 
                           <input type="button"  class="btn btn-default" value="Cancelar pedido" onClick=" window.location.href='pCancelar.do' "> 
                           <br><br>
                      <%}
                }
        }
 %>
</div>                
</div>                
           
       