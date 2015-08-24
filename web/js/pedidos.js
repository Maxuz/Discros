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

function validaBusqueda(e)
{ 
    var tipo = $('#tipo').val();;
              
    if(!estaVacio(tipo))
    {    $("#formTipo").addClass('has-error');
         e.preventDefault();
         return false;
    }else   {
             $("#formTipo").removeClass('has-error');
            
            return true;
            }
         
  
}; 

$(document).ready(function(){
    $("#actualizar").submit(function(e){
    validaBusqueda(e);
    });   
    
});

