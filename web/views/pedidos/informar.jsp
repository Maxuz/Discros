
<%@page import="Model.Pedido"%>
<%@page import="Actions.Pedidos.PedidosFunciones"%>
<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
  <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >   
    <br><h2 style="text-align: center;">Informar pedido</h2><hr>
    
     <% 
       
       //VERIFICA SI HAY USUARIO LOGUEADO
       if(session.getAttribute("email")!=null)
       {   
           //VERIFICA QUE LA URL SEA CORRECTA
           if(request.getParameter("tipo")!=null && !request.getParameter("tipo").equals(""))
           {    
                String email = session.getAttribute("email").toString();
                String tipo = request.getParameter("tipo");
                PedidosFunciones funcionesPedidos = new PedidosFunciones();
                
               //PÁGINA PARA ADMINISTRADORES
                if(tipo.equals("admin"))
                {
                    if(session.getAttribute("mensajeError")!=null)
                    {
                        %>
                        <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        <% out.print(session.getAttribute("mensajeError").toString()); %>
                        </div>
                        
                        <%    session.setAttribute("mensajeError", null);
                    
                    }%>                
                    
                    <form role="form" id="actualizarAdmin" name="actualizarAdmin" method="post" action="pModificar.do" >

                    <div class="col-xs-5">
                    <div class="form-group " id="formText">
                    <label class="control-label">ID de Pedido</label>
                    <div class="input-group" >   
                    <span class="input-group-addon"><span class="glyphicon glyphicon-edit"></span></span>
                    <input type="text" class="form-control" name="id" id="texto">
                    </div>    
                    </div>
                    </div>    

                    <div class="col-xs-5">
                    <div class="form-group" id="formTipo">
                    <label for="provincia" class="control-label" >Actualizar estado:</label>
                    <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-paste"></span></span>

                    <select class="form-control" name="estado" id="tipo" >
                    <option value="">Elegir opción..</option>  
                    <option value="Enviado">Enviado</option>

                    </select>

                    </div>
                    </div>
                    </div>
                    <br> <br> <br> <br>  

                    <button type="submit" class="btn btn-default">Actualizar</button>

                    </form>
                    
                    <br> <br> 
               <%
                }
                //VUELVE A EVALUAR SI EL TIPO ES VÁLIDO
                else{ 
                        //PÁGINA PARA CLIENTES
                        if(tipo.equals("cliente") && request.getParameter("id")!=null && !request.getParameter("id").equals("") )
                        {
                            int id= Integer.parseInt(request.getParameter("id"));
                            //VERIFICA QUE HAYA PEDIDO PARA ESTE USUARIO
                            if(funcionesPedidos.buscar(id,email))
                            {
                               //VERIFICA QUE EL PEDIDO NO ESTÉ ENTREGADO PARA PODER REALIZAR LA INFORMACIÓN 
                               Pedido ped = funcionesPedidos.getOne(id);
                               if(!ped.getEstado().equals("Entregado"))
                               {    
                               %>
                                    <div class="row">
                                    <form role="form" class="form-horizontal" id="actualizarCliente" method="post" action="pModificar.do" >
                                                                            
                                    <div class="col-xs-5">
                                    <div class="form-group " id="formText">
                                    <label class="control-label">ID de Pedido</label>
                                    <div class="input-group" >   
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-edit"></span></span>
                                    <input type="text" class="form-control" readonly name="id" id="texto" value="<%out.print(id);%>">
                                    </div>    
                                    </div>
                                    </div>    

                                    <div class="col-xs-5">
                                    <div class="form-group" id="formTipo">
                                    <label for="provincia" class="control-label" >Actualizar estado:</label>
                                    <div class="input-group">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-paste"></span></span>
                                    
                                    <select class="form-control" name="estado" id="tipo" >

                                    <option value="">Elegir opción..</option>  
                                    <option value="Reclamado">Reclamar</option>
                                    <option value="Entregado">Recibido</option>
                                   
                                    </select>

                                    </div>
                                    </div>
                                    </div>
                                    <br> <br> <br> <br>  
                                    
                                    <button type="submit" class="btn btn-default">Actualizar</button>
                                    
                                    </form>
                                    </div>
                                    <br> <br> 
                               <%
                               }else{
                                   %>
                                    <div style="text-align: center;">
                                    <h3 style="font-style: italic;"> El pedido ya está entregado. </h3>
                                    <br><br>     
                                    <a href="u_pedidos.jsp"><strong>&laquo; Volver al historial..</strong></a>
                                    </div>
                                   <%
                               }
                            //MENSAJE PARA EL PEDIDO NO ENCONTRADO PARA ESTE USUARIO
                            }else{
                               %>
                                <div style="text-align: center;">
                                    <h3 style="font-style: italic;"> Pedido no encontrado para este usuario. </h3>
                                    <br><br>     
                                    <a href="u_pedidos.jsp"><strong>&laquo; Volver al historial..</strong></a>
                                    </div>
                               <%
                            }    
                        //MENSAJE PARA TIPO NO VÁLIDO
                        }else{
                           %>
                            <div style="text-align: center;">
                            <h3 style="font-style: italic;"> Cliente necesita ID o tipo incorrecto.</h3>
                            <br><br>     
                            <a href="u_pedidos.jsp"><strong>&laquo; Volver al historial..</strong></a>
                            </div>
                           <%
                        }     
                    }
            //MENSAJE PARA LA URL INCORRECTA   
           }else{
               %>
                    <div style="text-align: center;">
                    <h3 style="font-style: italic;"> URL INCORRECTA </h3>
                    <br><br>     
                    <a href="u_pedidos.jsp"><strong>&laquo; Volver al historial..</strong></a>
                    </div> 
               <%
           }  
       //MENSAJE PARA USUARIOS NO LOGUEADOS
       }else{
            %>
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