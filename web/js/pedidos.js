function ocultarTarjeta()
{
    $("#datosTarjetas").addClass('hidden').show();
    
};

function mostrarTarjeta()
{
    $("#datosTarjetas").removeClass('hidden').show();
    
};

function verDetalles()
{
    $("#verDetalles").addClass('hidden').show();
    $("#ocultarDetalles").removeClass('hidden').show();
    $("#itemsPedido").removeClass('hidden').show();
    
};

function ocultarDetalles()
{
    $("#verDetalles").removeClass('hidden').show();
     $("#ocultarDetalles").addClass('hidden').show();
    $("#itemsPedido").addClass('hidden').show();
    
};


function imprimirDiv(muestra)
{var ficha=document.getElementById(muestra);var ventimp=window.open(' ','popimpr');ventimp.document.write(ficha.innerHTML);ventimp.document.close();ventimp.print();ventimp.close();}


var funciones = {
 validarr: function(e)
{ 
    var msj = "";
    
    var tipo = $('#tipo').val();
    var texto = $('#texto').val();          
    window.alert("holaaa");
    window.alert('holaaa');
    
     if(!estaVacio(tipo))
    {    $("#formTipo").addClass('has-error');
         msj="error";
    }else   {
             $("#formTipo").removeClass('has-error');
            }
            
    if(!estaVacio(texto))
    {    $("#formText").addClass('has-error');
         msj="error";
    }else   {
             $("#formText").removeClass('has-error');
            }
       
    
    if(msj==="")
    {
     return false;   
        
    }else{
        
     return false;   
    }
         
  
}
}; 

$(document).ready(function(){
    $("#actualizarAdmin").submit(function(e){
    funciones.validarr(e);
    });   
    
});

