//hacer foco en el primer campo del formulario de usuarios
$(document).ready(function(){
$('#email').focus();
});


var valida = function(event){

    var mensaje = "";
    var mail = $('#email').val();
    var mail2= $('#email2').val();
    var pass = $('#pass').val();
    var pass2 = $('#pass2').val();
    var nombre = $('#nombre').val();
    var apellido = $('#apellido').val();
    var dni = $('#dni').val();
    var provincia = $('#provincia').val();
    var ciudad= $('#ciudad').val();
    var direccion = $('#direccion').val();

    if(!estaVacio(mail)){
     $('#lblemail1').addClass('lblError').text("(*)Email - Debe ingresar un email.");
      mensaje = mensaje + " email\n";
    } 
    if(!estaVacio(mail2)){
      $('#lblemail2').addClass('lblError').text("(*)Reescribe tu Email - Debe verificar el email.");
       mensaje = mensaje + "email2\n";
    }else if (mail != mail2){
       mensaje = mensaje + "emails disntitos\n";
       $('#lblEmail2').addClass('lblError').text("(*)Reescribe tu Email - Los correos no coinciden.");
    }
    if(!estaVacio(pass)){
      mensaje = mensaje + "contraseña\n";
      $('#lblPass').addClass('lblError').text("(*)Contraseña - Debe ingresar una contraseña.");
    }
    if(!estaVacio(pass2)){
        mensaje = mensaje + "contraseña2\n";
        $('#lblPass2').addClass('lblError').text("(*)Reescribe tu Contraseña - Debe verificar la contraseña.");
    }else if(pass != pass2){
        mensaje = mensaje + "contraseñas distintas\n";
       $('#lblPass2').addClass('lblError').text("(*)Reescribe tu Contraseña - Las contraseñas no coinciden.");
    }
    if(!estaVacio(nombre)){
        mensaje = mensaje + "nombre\n";
        $('#lblNombre').addClass('lblError').text("(*)Ingrese su nombre - Debe ingresar un nombre.");
    }else if(!soloTexto(nombre)){
        mensaje = mensaje + "Solo letras nombre\n";
       $('#lblNombre').addClass('lblError').text("(*)Ingrese su nombre - El nombre solo debe contener letras.");
    }
    if (!estaVacio(apellido)){
        mensaje = mensaje + "apellido\n";
        $('#lblApellido').addClass('lblError').text("(*)Ingrese su Apellido - Debe ingresar un apellido.");
    } else if(!soloTexto(apellido)){
        mensaje = mensaje + "solo letras apellido\n"
        $('#lblApellido').addClass('lblError').text("(*)Ingrese su Apellido - El apellido solo debe contener letras.");
    }
    if (!estaVacio(dni)){
        mensaje = mensaje + "dni\n";
       $('#lblDni').addClass('lblError').text("(*)Ingrese su DNI - Debe ingresar un DNI.");
    } else if(!soloNumero(dni)){
        mensaje = mensaje + "numeros dni\n";
        $('#lblDni').addClass('lblError').text("(*)Ingrese su DNI - Debe ingresar un DNI.");
    }
    if(provincia == "Elegir provincia.."){
        mensaje = mensaje +"provincia\n";
        $('#lblProvincia').addClass('lblError').text("(*)Elija su Provincia - Debe seleccionar una provincia.");
    }
    if(!estaVacio(ciudad)){
        mensaje = mensaje +"ciudad\n";
        $('#lblCiudad').addClass('lblError').text("(*)Ingrese su Ciudad - Debe ingresar una ciudad.");
    }
    if(!estaVacio(direccion)){
        mensaje = mensaje +"direccion\n";
        $('#lblDireccion').addClass('lblError').text("(*)Ingrese su Direccion - Debe ingresar una Direccion.");
    }   
    if(mensaje === ""){
        return true;
    }else{
        console.log(mensaje);
        event.preventDefault();
    }
};

var isEmail = function(email){
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (expr.test(email)){
        return true;
    } else {
        return false;
    }
};
var estaVacio = function(campo){
    if (campo === undefined || campo==="")
        {
           return false; 
        }
    return true;        
};
var soloNumero = function(campo){
    expr = /^([0-9])*$/;
    if(expr.test(campo))
        return true;
    else{
        return false;
    }
};
var soloTexto = function(campo){
  expr = /^[A-Za-z\_\-\.\s\xF1\xD1]+$/;
    if (expr.test(campo)){
        return true;
    }else {
        return false;
    }
};