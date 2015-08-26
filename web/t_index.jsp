<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tienda Virtual - Discros INC</title>

    <%session.setAttribute("paginaActual", "t_index");%>
    <jsp:include page="views/gral/referencias.jsp"/>
    <jsp:include page="views/gral/t_referencias.jsp"/>
   
  </head>
  <body>

    <div class="container-fluid">
        
        <jsp:include page="views/gral/header.jsp"/>
        
        <%try{%>
        <jsp:include page="views/tienda/contenido.jsp"/>
        <%}catch (Exception e)
                       {
                                        session.setAttribute("errorCatch", e.toString());
                                        RequestDispatcher rd =null;
                                                                               
                                        rd=request.getRequestDispatcher("error.jsp");
                                        rd.forward(request,response);
                       }%>
                       
        <jsp:include page="views/gral/pie.jsp" />
        
</div>
</body>
</html>