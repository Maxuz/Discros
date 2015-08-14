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
     mensaje = mensaje + "debe completar el campo email\n";   
    } 
    if (!isEmail(mail)){
       mensaje = mensaje + "formato de mail incorrecto\n";
    }
    if(!estaVacio(mail2)){
        mensaje = mensaje + "debe completar el campo verificar email\n";
    }
    if (mail != mail2){
       mensaje = mensaje + "los emails no son iguales\n";
    }
    if(!estaVacio(pass)){
      mensaje = mensaje + "debe completar el campo contraseña\n";
    }
    if(!estaVacio(pass2)){
        mensaje = mensaje + "debe completar el campo repetir contraseña\n";
    }
    if(pass != pass2){
        mensaje = mensaje + "las contraseñas no coinciden\n";
    }
    if(!estaVacio(nombre)){
        mensaje = mensaje + "debe completar el campo nombre\n";
    }
    if(!soloTexto(nombre)){
        mensaje = mensaje + "solo debe ingresar letras en el campo nombre\n";
    }
    if (!estaVacio(apellido)){
        mensaje = mensaje + "debe completar el campo apellido\n";
    }
    if(!soloTexto(apellido)){
        mensaje = mensaje + "solo debe ingresar letras en el campo apellido\n"
    }
    if (!estaVacio(dni)){
        mensaje = mensaje + "debe completar el campo dni\n";
    }
    if(!soloNumero(dni)){
        mensaje = mensaje + "debe ingresar unicamente numeros en el campo dni\n";
    }
    if(!estaVacio(provincia)){
        mensaje = mensaje +"debe seleccionar una provincia\n";
    }
    if(!estaVacio(ciudad)){
        mensaje = mensaje +"debe completar el campo ciudad\n";
    }
    if(!estaVacio(direccion)){
        mensaje = mensaje +"debe completar el campo direccion\n";
    }
    if(mensaje == ""){
        return true;
    }
    
    //si llego aca es por qué no se verifico todo
    //podemos ver lo de mostrar el mensaje 
    //o solo retornar false cuando corta
    //revisar...
    alert(mensaje);
    //esto último es para que no se ejecute el submit
    //hay que ver como lo usamos con el servlet
    event.preventDefault();
    return false;
}

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