/* global global */


var validacion = {
    ejecutar: function (){
        var email = $("#email").val();
        var pass = $("#pass").val();
        
        /*VALIDAR QUE NO SEAN VACÍOS*/
        if(valido(email, pass))
        {
        $.ajax("usuario.do", {
             method: "POST",
             contentType: 'application/json',
             
             error: function (a, b, c){
                 alert("Ocurrió un error al validar un usuario");
                 
                 
                 /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                 $('#divError').removeClass('hidden').text("<strong> ERROR GRAVE EN EL CONTROLADOR.");
                 
             },
             
             success: function (data, textStatus, jqXHR) {
                if (data.result=true)
                {     
                    
                    
                      $('#divError').removeClass('hidden').text("Contraseña re correcta."); 
                }
                else {
                    /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                    $('#divError').removeClass('hidden').text("Contraseña incorrectaaaaaaa.");
                    
                }
                
            },
             data: {
                        funcion: alta
                     
                     }
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