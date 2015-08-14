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
     $('#divErrorEmail1').removeClass('hidden').text("Ingrese email.");
      mensaje = mensaje + " email\n";
    } 
    if(!estaVacio(mail2)){
       $('#divErrorEmail2').removeClass('hidden').text("Ingrese verificación de email.");
       mensaje = mensaje + "email2\n";
    }
    if (mail != mail2){
       mensaje = mensaje + "emails disntitos\n";
       $('#divErrorEmail2').removeClass('hidden').text("Los email no coinciden.");
    }
    if(!estaVacio(pass)){
      mensaje = mensaje + "contraseña\n";
      $('#divErrorPass').removeClass('hidden').text("Ingresar contraseña.");
    }
    if(!estaVacio(pass2)){
        mensaje = mensaje + "contraseña2\n";
        $('#divErrorPass2').removeClass('hidden').text("Ingresar verificación de contraseña.");
    }
    if(pass != pass2){
        mensaje = mensaje + "contraseñas distintas\n";
        $('#divErrorPass2').removeClass('hidden').text("Las contraseñas no coinciden.");
    }
    if(!estaVacio(nombre)){
        mensaje = mensaje + "nombre\n";
        $('#divErrorNombre').removeClass('hidden').text("Ingrese el nombre.");
    }
    if(!soloTexto(nombre)){
        mensaje = mensaje + "Solo letras nombre\n";
        $('#divErrorNombre').removeClass('hidden').text("Solo debe ingresar letras en el nombre.");
    }
    if (!estaVacio(apellido)){
        mensaje = mensaje + "apellido\n";
        $('#divErrorApellido').removeClass('hidden').text("Ingrese apellido.");
    }
    if(!soloTexto(apellido)){
        mensaje = mensaje + "solo letras apellido\n"
        $('#divErrorApellido').removeClass('hidden').text("Solo debe ingresar letras en el apellido.");
    }
    if (!estaVacio(dni)){
        mensaje = mensaje + "dni\n";
        $('#divErrorDni').removeClass('hidden').text("Ingrese dni.");
    }
    if(!soloNumero(dni)){
        mensaje = mensaje + "debe ingresar unicamente numeros en el campo dni\n";
        $('#divErrorDni').removeClass('hidden').text("El dni no puede contener letras.");
    }
    if(!estaVacio(provincia)){
        mensaje = mensaje +"provincia\n";
        $('#divErrorProvincia').removeClass('hidden').text("Seleccione una provincia.");
    }
    if(!estaVacio(ciudad)){
        mensaje = mensaje +"ciudad\n";
        $('#divErrorCiudad').removeClass('hidden').text("Ingrese ciudad.");
    }
    if(!estaVacio(direccion)){
        mensaje = mensaje +"debe completar el campo direccion\n";
        $('#divErrorDirec').removeClass('hidden').text("Ingrese dirección.");
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