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

