var validacion = {
    ejecutar: function (){
        var email = $("#txbEmail").val();
        var pass = $("#txbPass").val();
        
        /*VALIDAR QUE NO SEAN VACÍOS*/
        if(valido(email, pass))
        {
        $.ajax("usuario.do", {
             method: "POST",
             contentType: 'application/json',
             error: function (a, b, c){
                 alert("Ocurrió un error al validar un usuario");
                 /*AGREGAR DIV EN JSP PARA LA MUESTRA DE ERRORES*/
                 $('#divError').removeClass('hidden').text(c);
                 
             },
             success: function (data, textStatus, jqXHR) {
                if (data.result=true)
                {
                    
                }
                else {
                    /*AGREGAR DIV EN JSP PARA LA MUESTRA DE ERRORES*/
                    $('#divError').removeClass('hidden').text("Contraseña incorrecta.");
                    
                }
                
            },
             data: { name: "John", location: "Boston" }
            });
        } else {$('#divError').removeClass('hidden').text("Email o contraseña vacios.");};
}
};

$(document).ready(function(){
    $("#login").submit(function(e){
        e.preventDefault();
        validacion.ejecutar();
    });
});

function valido (user, pass)
{
    if (user === undefined || user==="")
        {
           return false; 
        }
        
     if (pass === undefined || pass==="")
        {
           return false; 
        }
    return true;    
        
}