<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px;">
    <div class="row">
    <div class="col-md-6 col-md-offset-3" style=" text-align: center;">
    <br>
    <h2 style="text-align: center;">Inhabilitar un usuario</h2><hr>
    
    <%  String s = (String)session.getAttribute("tipoUsuario");
        
        //VERIFICA QUE HAYA USUARIO LOGUEADO     
        if(s!=null)
                {%>
                
                <!--VERIFICA QUE NO HAYA MENSAJES CARGADOS EN LA VARIABLE DE SESIÓN COMO RESPUESTA DEL SERVIDOR-->
                <%  if(s.equals("admin"))
                    {
                    
                        //VERIFICA SI ES ADMINISTRADOR
                        if(session.getAttribute("mensajeExito")== null)
                        { 

                            //VERIFICA SI HAY MENSAJE DE ERROR QUE DEVUELVE EL CONTROLADOR Y EN TAL CASO LO MUESTRA
                            if(session.getAttribute("mensajeError")!=null)
                            {%>
                                <br>        
                                <div class="alert alert-danger" style="text-align: center;">
                                <% 
                                   out.print((String)session.getAttribute("mensajeError"));
                                   session.setAttribute("mensajeError", null);
                                %>
                                </div>
                            <%}%>

                            <form role="form" id="login" method="post" onsubmit="validaEmail(event)" action="uBorrar.do">

                            <div class="form-group " id="email">
                            <label class="control-label">Ingrese Email</label>
                            <div class="input-group" >   
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-color"></span></span>
                            <input type="email" class="form-control" name="email" id="texto" placeholder="Introduce Email">
                            </div>    
                            </div>

                            <button type="submit" class="btn btn-default" > <strong>Inhabilitar</strong> </button>
                            <br><br>

                            </form>     

                    <%}else{%>
                        <!--SERVIDOR DEVUELVE MENSAJE DE ÉXITO-->
                        <div class="alert alert-success" style="text-align: center;">
                           
                        <% out.print((String)session.getAttribute("mensajeExito"));
                        session.setAttribute("mensajeExito", null);
                        %>
                        </div>
                       
                        <hr><div style="margin-left:  15px;"><a href="p_admin.jsp"><h4>&laquo; Volver al menú principal..</h4></a></div> <br><br>  
                    <%}%>
                      
             <%}else{%>   
                <!--RESTRICCIÓN PARA LOS NO ADMINISTRADORES -->
                <h3 style="text-align: center; font-style: italic;">
                Lo sentimos, página sólo habilitada para administradores.
                </h3>
                <hr> 
                <%}%>
            
        <%}else{%>  
            <!--RESTRICCIÓN PARA USUARIO NO LOGUEADO-->
            <h3 style="text-align: center; font-style: italic;">
            Lo sentimos, debe iniciar sesión como administrador.
            </h3>
            <hr> 
            <%}%>
   </div> 
  </div>
</div>

    
                        
                            


         