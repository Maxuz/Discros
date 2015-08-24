
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
           if(request.getParameter("id")!=null && !request.getParameter("id").equals("") && request.getParameter("tipo")!=null && !request.getParameter("tipo").equals(""))
           {    
                String email = session.getAttribute("email").toString();
                String tipo = request.getParameter("tipo").toString();
                PedidosFunciones funcionesPedidos = new PedidosFunciones();
                int id= Integer.parseInt(request.getParameter("id"));
               //PÁGINA PARA ADMINISTRADORES
                if(tipo.equals("admin"))
                {
                %>
                    
               <%
                }
                //VUELVE A EVALUAR SI EL TIPO ES VÁLIDO
                else{ 
                        //PÁGINA PARA CLIENTES
                        if(tipo.equals("cliente"))
                        {//VERIFICA QUE HAYA PEDIDO PARA ESTE USUARIO
                            if(funcionesPedidos.buscar(id,email))
                            {
                               //VERIFICA QUE EL PEDIDO NO ESTÉ ENTREGADO PARA PODER REALIZAR LA INFORMACIÓN 
                               Pedido ped = funcionesPedidos.getOne(id);
                               if(!ped.getEstado().equals("entregado"))
                               {    
                               %>
                                    <div class="row">
                                    <form role="form" class="form-horizontal" id="actualizar" method="post" action="pModificar.do" >
                                                                            
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
                                    <option value="reclamado">Reclamar</option>
                                    <option value="entregado">Recibido</option>
                                   
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
                                   
                                   <%
                               }
                            //MENSAJE PARA EL PEDIDO NO ENCONTRADO PARA ESTE USUARIO
                            }else{
                               %>
                                
                               <%
                            }    
                        //MENSAJE PARA TIPO NO VÁLIDO
                        }else{
                           %>
                            
                           <%
                        }     
                    }
            //MENSAJE PARA LA URL INCORRECTA   
           }else{
               %>
                    
               <%
           }  
       //MENSAJE PARA USUARIOS NO LOGUEADOS
       }else{
            %>

           <%
            }
       
     %>     
     <br> <br> <br>
</div>
</div>