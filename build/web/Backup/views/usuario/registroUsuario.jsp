<div class="container-fluid" style="background-color: #ffffff; margin-bottom: 4px;">
	<div class="row">
             
            
            <h1 style="text-align: center; font-family: 'Slabo 27px', serif;"> Registro de usuario</h1>
             
             <HR width=95% align="center">
             <div class="col-md-8" >
                    <form role="form">
                    <div class="form-group" style="margin:80px; margin-top: 0PX;">
                        
                        
                        
                    <h3>Ingrese datos de Inicio de Sesi�n</h3>       
                    <HR width=100% align="left">
                    
                     <label>Email</label>
                    <input type="text" class="form-control" placeholder="luismiguel@hotmail.com"><br>
                     <% //ERROR: EMAIL REGISTRADO.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        Integer condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> Email ya registrado.</div> ");}
                                       ;
                                    
                                    %> 
                                    
                    <label>Contrase�a</label>
                    <input type="password" class="form-control" placeholder="Contrase�a"><br>
                     <% //ERROR: CONTRASE�A NO V�LIDA.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"><strong>Error!</strong> Contrase�a no v�lida.</div> ");}
                                       ;
                                    
                                    %> 
                                    
                    <label>Repetir Contrase�a</label>
                    <input type="password" class="form-control" placeholder="Repetir contrase�a"><br>
                    <% //ERROR: CONTRASE�A DIFERENTE.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> Contrase�as no coinciden.</div> ");}
                                       ;
                                    
                                    %> 
                    
                    
                    <h3>Ingrese sus datos personales</h3>
                    <HR width=100% align="left">
                    
                    
                    <label>Nombre(s)</label>
                    <input type="text" class="form-control" placeholder="Nombre(s)"><br>
                    <% //ERROR: NOMBRE INCORRECTO.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> Nombre(s) incorrecto.</div> ");}
                                       ;
                                    
                                    %> 
                                    
                                    
                    <label>Apellido(s)</label>
                    <input type="text" class="form-control" placeholder="Apellido(s)"><br>
                    <% //ERROR: APELLIDO INCORRECTO.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> Apellido(s) incorrecto.</div> ");}
                                       ;
                                    
                                    %>
                                    
                    <label>DNI</label>
                    <input type="text" class="form-control" placeholder="DNI"><br>
                    <% //ERROR: DNI INCORRECTO.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> DNI incorrecto.</div> ");}
                                       ;
                                    
                                    %>
                    
                   <label>Pa�s</label>
                   <select  class="form-control">
                        <% //REALIZAR CORRECTAMENTE EL LLENADO DEL COMBOBOX
                            
                            for ( int factor = 1; factor <= 9; factor ++ ) {
                             out.print(" <option>"+factor+"</option>");
                                }
                    
                        %>   
                     </select><br>
                     
                     <label>Provincia</label>
                    <select  class="form-control" >
                        <% //REALIZAR CORRECTAMENTE EL LLENADO DEL COMBOBOX
                            
                            for ( int factor = 1; factor <= 9; factor ++ ) {
                             out.print(" <option>"+factor+"</option>");
                                }
                    
                        %>   
                     </select><br>
                     
                    <label>Ciudad</label>
                    <input type="text" class="form-control" placeholder="Campo de texto"><br>
                    <% //ERROR: CIUDAD INCORRECTA.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> Ciudad incorrecta.</div> ");}
                                       ;
                                    
                                    %>
                    
                    <label>Direcci�n</label>
                    <input type="text" class="form-control" placeholder="Direcci�n"><br>
                    <% //ERROR: DIRECCI�N INCORRECTA.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> Direcci�n incorrecta.</div> ");}
                                       ;
                                    
                                    %>
                    
                    <label>CP</label>
                    <input type="text" class="form-control" placeholder="Campo de texto"><br>
                   <% //ERROR: CODIGO POSTAL INCORRECTO.

                                        //ESCRIBIR CONDICI�N PARA MOSTRAR O NO EL DIV
                                        condicion = 0;
                                        if (condicion==0){ out.print("<div class=\"alert alert-danger\"> <strong>Error!</strong> C�digo Postal incorrecto.</div> ");}
                                       ;
                                    
                                    %>
                   
                    
                     <button type="submit" class="btn btn-success">Registrarme</button>
                    </div>
                        
                        
                    </form>
                    
                    
               
		</div>
                 
		<div class="col-md-4">
                    
		</div>
	</div>
</div>