<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px;">
    
    <div class="row">
    <div style=" margin-left: 4%;">
        
        <% if(session.getAttribute("mensajeExito")==null)
            {%>
                    <h1 style="text-align:center;"> Has llegado a este sitio por error, vuelva al inicio.</h1>
                    
            
         <% }else{%>
                    <h1 style="text-align:center;">
                        <%out.print((String)session.getAttribute("mensajeExito"));
                        session.setAttribute("mensajeExito", null);
                        %>  
                    </h1>
                    <hr>
                   
         
            <% }%>
       <br><br>     
       <div style="text-align: center;"><a href="index.jsp"><strong>&laquo; Volver al Inicio..</strong></a></div>
       <br><br> 
        
        
     </div>
     
        
        
    </div>
</div>
 