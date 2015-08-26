
<%@page import="Model.PedidoReporte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Pedido"%>
<%@page import="Actions.Pedidos.PedidosFunciones"%>
<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
  <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >   
   
    
     <% 
       
       //VERIFICA SI HAY USUARIO LOGUEADO
       if(session.getAttribute("email")!=null)
       {   
                
                PedidosFunciones funcionesPedidos = new PedidosFunciones();
                
               //PÁGINA PARA ADMINISTRADORES
                if(session.getAttribute("tipoUsuario")!=null)
            {
                    ArrayList<Model.PedidoReporte> lista = funcionesPedidos.getAllPendientes();
                    int i, cantidad = lista.size();
                    PedidoReporte ped = new PedidoReporte();
                    %>
                    <div id="imprimir">
                    <br><h2 style="text-align: center;">Reporte de pedidos pendientes</h2><hr>
                    <div style="text-align: center;">
                    <h3 style="font-style: italic;"> Cantidad de pedidos pendientes encontrados: <%out.print(cantidad); %></h3>
                    <br>
                    </div>

                     
                     <div class="table-responsive"  id="itemsPedido">
                     <table class="table" id="tablaCanciones">
                     <!-- CODIGO PARA EL ENCABEZADO-->
                     <br>
                     <tr>
                         <td><strong>ID</strong></td>
                         <td><strong>Fecha</strong></td>
                         <td><strong>Email</strong></td>
                         <td><strong>Nombre</strong></td>
                         <td><strong>Apellido</strong></td>
                    </tr>


                     <!-- VERIFICA SI HAY OBJETOS EN LA LISTA PARA MOSTRALOS-->
                  <% 

                    for(i=0;i<cantidad;i++)
                    {   ped= lista.get(i);
                       

                        %>
                         <tr>
                         <td><%out.print(ped.getID()); %></td>
                         <td><%out.print(ped.getFecha()); %></td>
                         <td><%out.print(ped.getEmail()); %></td>
                         <td><%out.print(ped.getNombre()); %></td>
                         <td><%out.print(ped.getApellido()); %></td>
                         </tr>
                 <%}%>
                     </table>
                     </div>
                     </div>
                     
                     <button type="button" class="btn btn-info" onclick="imprimirDiv('imprimir')">Imprimir</button>
                     <button type="button" class="btn btn-default">Volver a página principal</button>
                     <br><hr> 
                    
                    
                    
               <%
                }
                //ENTRA SI EL USUARIO NO ES ADMINISTRADOR
                else{ 
                      %>
                    <br><h2 style="text-align: center;">Reporte de pedidos pendientes</h2><hr>
                    <div style="text-align: center;">
                    <h3 style="font-style: italic;"> Ingreso sólo para usuarios administradores. </h3>
                    <br><br>     
                    <a href="u_login.jsp"><strong> Iniciar sesión</strong></a>
                    </div>
                       <%
                             
                    }
             
       //MENSAJE PARA USUARIOS NO LOGUEADOS
       }else{
            %>
         <br><h2 style="text-align: center;">Reporte de pedidos pendientes</h2><hr>
        <div style="text-align: center;">
        <h3 style="font-style: italic;"> Usuario no logueado. </h3>
        <br><br>     
        <a href="u_login.jsp"><strong> Iniciar sesión</strong></a>
        </div>
           <%
            }
       
     %>     
     <br> <br> <br>
</div>
</div>