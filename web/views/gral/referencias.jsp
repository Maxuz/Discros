
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/stylePropio.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/validaciones.js"></script>
    <script src="js/tienda.js"></script>
    
    <% if(session.getAttribute("itemsTotal")==null)
    {
            session.setAttribute("itemsTotal", "0");
    }%>