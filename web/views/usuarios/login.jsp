<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px;">
    <div class="row">
    <div class="col-md-6 col-md-offset-3" style=" text-align: center;">
        
        <!-- CONTROL DE USUARIO LOGUEADO -->
        <%if(session.getAttribute("nombre")==null)
        {%>
        <h1 style="text-align:center;"> Inicio de sesión de usuario</h1>
        <hr>
        
        <form role="form" id="login" method="post" action="uLogin.do">
                                      
                                    <div class="form-group">
                                    <label for="lEmail">Email</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Introduce tu email">
                                    </div>
                                  
                                    <div class="form-group">
                                    <label for="lPass">Contraseña</label>
                                    <input type="password" class="form-control" id="pass" name="pass"  placeholder="Contraseña">
                                   
                                    <input type="text" name="funcion" id="funcion" size="5" value="login" hidden readonly="true">
                                    
                                    </div>
                                
                                     <button type="submit" class="btn btn-default">Enviar</button>
                                   
                                     <!-- USUARIO NO ENCONTRADO-->
                                    <%if(session.getAttribute("mensajeExito")!=null)
                                      {%>


                                              <br><br><br>        
                                              <div class="alert alert-danger">
                                                  <% out.print((String)session.getAttribute("mensajeExito"));
                                                      session.setAttribute("mensajeExito", null);
                                                      %>

                                              </div>

                                      <%}%>

                                     
                                    <br><br><a href="u_olvide.jsp">Olvidé mi contraseña.</a>
                                    <br><a href="u_alta.jsp">Registrarme.</a><br><br>
                                     
                                   <div>
                                   <!--DIV PARA MOSTRAR ERRORES-->
                                   <div id="divError" class="alert alert-danger hidden"></div>
                                   
                                   
                                   </div>
                                   </form>
            
        <!-- USUARIO YA LOGUEADO -->
        <%}else{%>
        <h3 style="text-align: center; font-style: italic;"> No puede acceder a este sitio, aún se encuentra logueado en el sistema.</h3>
        <%}%>
        
    </div>                             
    </div>
</div>
 