<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
  

<!-- FORMULARIO DE REGISTRO DE NUEVO DISCO-->
<div class="row"  >
    <br>
   
    
    <%  String s = (String)session.getAttribute("tipoUsuario");
        
        //VERIFICA QUE HAYA USUARIO LOGUEADO     
        if(s!=null)
                {%>
                
                <!--VERIFICA QUE NO HAYA MENSAJES CARGADOS EN LA VARIABLE DE SESI�N COMO RESPUESTA DEL SERVIDOR-->
                <% if(session.getAttribute("mensajeExito")!= null)
                {%>
                        <!--SERVIDOR DEVUELVE MENSAJE DE �XITO-->
                      
                        <div class="alert alert-success" style="text-align: center;">
                           
                       <% out.print((String)session.getAttribute("mensajeExito"));
                       session.setAttribute("mensajeExito", null);
                       %>
                       </div>
                       
                       <hr><div style="margin-left:  15px;"><a href="p_admin.jsp"><h4>&laquo; Volver al men� principal..</h4></a></div> <br><br>
                            
                       
                       <%}
                              
                
                else{   if(s.equals("admin"))
                        {%> 
                        
                            <h2 style="text-align: center;">Administraci�n de usuarios.</h2><hr>
                            <div class="col-md-4">
				
                            </div>
                            <div class="col-md-4" style="text-align: center;">
                                <br>
                                <button type="button" class="btn btn-danger btn-lg btn-block" onclick=" window.location.href='u_baja.jsp'">INHABILITAR USUARIO</button>
                                <br><br><br>
                                    
                           </div>
				<div class="col-md-4">
                                 
				</div>
			</div>

                                    

                          
                      <% }else{%>
                                    <!--RESTRICCI�N PARA LOS NO ADMINISTRADORES -->
                                    <h3 style="text-align: center; font-style: italic;">
                                    Lo sentimos, p�gina s�lo habilitada para administradores.
                                    </h3>
                                    <hr> 
                           <%}
                    
                  }%>
            
        <%}else{%>     <!--RESTRICCI�N PARA USUARIO NO LOGUEADO-->
                        <h3 style="text-align: center; font-style: italic;">
                        Lo sentimos, debe iniciar sesi�n como administrador.
                        </h3>
                        <hr> 
                        
                    <%}%>
              
       
        
    
  </div>


    



         