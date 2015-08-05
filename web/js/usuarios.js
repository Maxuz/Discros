//FUNCIONES PARA TRABAJAR CON LOS USUARIOS
var funciones = {
    
    login: function (){
        var email = $("#email").val();
        var pass = $("#pass").val();
        var funcion = $("#funcion").val();
        
        dataString = "email="+email;
        dataString = "pass="+pass;
        dataString = "funcion="+funcion;
        
        /*VALIDAR QUE NO SEAN VACÍOS*/
        if(estaVacio(email, pass))
        {
        $.ajax("usuario.do", {
             
             type: "POST",
             dataType: "json",
             data: { "email": email, "pass":pass, "funcion":funcion},
             
             error: function (a, b, c)
                     {
                       
                        /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                       $('#divError').removeClass('hidden').text("ERROR: "+ c.toString());
                 
             },
             success: function (data)
                     {
                        if (data.result=true)
                        {     
                                    

                              $('#divError').removeClass('hidden').text("Contraseña re correcta."); 
                        }
                        else {
                            /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                            $('#divError').removeClass('hidden').text("Contraseña incorrectaaaaaaa.");

                        }
                     },
            
            });
            
        } else {$('#divError').removeClass('hidden').text("Email o contraseña vacios.");};
},

    alta: function (){
        var email = $("#email").val();
        var pass = $("#pass").val();
        var funcion = $("#funcion").val();
        
        dataString = "email="+email;
        dataString = "pass="+pass;
        dataString = "funcion="+funcion;
        
        /*VALIDAR QUE NO SEAN VACÍOS*/
        if(estaVacio(email, pass))
        {
        $.ajax("usuario.do", {
             
             type: "POST",
             dataType: "json",
             data: { "email": email, "pass":pass, "funcion":funcion},
             
             error: function (a, b, c)
                     {
                       
                        /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                       $('#divError').removeClass('hidden').text("ERROR: "+ c.toString());
                 
             },
             success: function (data)
                     {
                        if (data.result=true)
                        {     
                                    

                              $('#divError').removeClass('hidden').text("Contraseña re correcta."); 
                        }
                        else {
                            /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                            $('#divError').removeClass('hidden').text("Contraseña incorrectaaaaaaa.");

                        }
                     },
            
            });
            
        } else {$('#divError').removeClass('hidden').text("Email o contraseña vacios.");};
},
    
    baja: function (){
        var email = $("#email").val();
        var pass = $("#pass").val();
        var funcion = $("#funcion").val();
        
        dataString = "email="+email;
        dataString = "pass="+pass;
        dataString = "funcion="+funcion;
        
        /*VALIDAR QUE NO SEAN VACÍOS*/
        if(estaVacio(email, pass))
        {
        $.ajax("usuario.do", {
             
             type: "POST",
             dataType: "json",
             data: { "email": email, "pass":pass, "funcion":funcion},
             
             error: function (a, b, c)
                     {
                       
                        /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                       $('#divError').removeClass('hidden').text("ERROR: "+ c.toString());
                 
             },
             success: function (data)
                     {
                        if (data.result=true)
                        {     
                                    

                              $('#divError').removeClass('hidden').text("Contraseña re correcta."); 
                        }
                        else {
                            /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                            $('#divError').removeClass('hidden').text("Contraseña incorrectaaaaaaa.");

                        }
                     },
            
            });
            
        } else {$('#divError').removeClass('hidden').text("Email o contraseña vacios.");};
},

    modificar: function (){
        var email = $("#email").val();
        var pass = $("#pass").val();
        var funcion = $("#funcion").val();
        
        dataString = "email="+email;
        dataString = "pass="+pass;
        dataString = "funcion="+funcion;
        
        /*VALIDAR QUE NO SEAN VACÍOS*/
        if(estaVacio(email, pass))
        {
        $.ajax("usuario.do", {
             
             type: "POST",
             dataType: "json",
             data: { "email": email, "pass":pass, "funcion":funcion},
             
             error: function (a, b, c)
                     {
                       
                        /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                       $('#divError').removeClass('hidden').text("ERROR: "+ c.toString());
                 
             },
             success: function (data)
                     {
                        if (data.result=true)
                        {     
                                    

                              $('#divError').removeClass('hidden').text("Contraseña re correcta."); 
                        }
                        else {
                            /*QUITA LA CLASE HIDDEN DEL DIV ERROR*/
                            $('#divError').removeClass('hidden').text("Contraseña incorrectaaaaaaa.");

                        }
                     },
            
            });
            
        } else {$('#divError').removeClass('hidden').text("Email o contraseña vacios.");};
}

};


//LLAMADAS A FUNCIONES


//LOGIN
$(document).ready(function(){
    $("#login").submit(function(e){
        e.preventDefault();
        funciones.login();
    });
});

//ALTA
$(document).ready(function(){
    $("#alta").submit(function(e){
        e.preventDefault();
        funciones.alta();
    });
});

//BAJA
$(document).ready(function(){
    $("#baja").submit(function(e){
        e.preventDefault();
        funciones.baja();
    });
});

//MODIFICAR
$(document).ready(function(){
    $("#modificar").submit(function(e){
        e.preventDefault();
        funciones.alta();
    });
});


//FUNCIONES DE APOYO
function estaVacio (user, pass)
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