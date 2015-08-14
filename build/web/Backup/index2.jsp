<!DOCTYPE html>



<html>
   <%--HEAD--%>
   <head>
    <meta charset="utf-8">
    <!--<title><%//=sTitle%> - badbit.org</title>-->
    <title>DISCROS INC.</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <jsp:include page="views/gral/referenciasCSS.jsp"/>
    
</head>

<body>
    
<%--CONTENEDOR PRINCIPAL--%>
<div class="container">
    <div class="row clearfix">     
        <div class="col-md-12 column">
           
            <%--MENÚ--%>
             <jsp:include page="/header" />
            
             <%--CONTENIDO--%>
            <jsp:include page="views/index/contenidoIndex.jsp"/>   
            
        </div>
    </div>       
        
 <%--PIE DE PÁGINA--%>               
    <jsp:include page="/pie" />
    
</div>
</body>
</html>
