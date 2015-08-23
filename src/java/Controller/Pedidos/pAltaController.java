package Controller.Pedidos;

import Actions.Pedidos.PedidosFunciones;
import Actions.Usuarios.UsuariosFunciones;
import Model.Cancion;
import Model.Disco;
import Model.Pedido;
import java.io.IOException;
import Actions.Canciones.CancionesFunciones;
import Actions.Discos.DiscosFunciones;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class pAltaController extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
       HttpSession sesion = request.getSession(true);  
       try{ UsuariosFunciones funcionesUsuario = new UsuariosFunciones();
            if(sesion.getAttribute("email")!=null)
            {
                        
                        
                   if(sesion.getAttribute("listaCarrito")!=null)
                   {
                        //INSTANCIACIÓN DE OBJETOS PARA REALIZAR LA CARGA
                        PedidosFunciones funciones = new PedidosFunciones();
                        CancionesFunciones funcionesCanciones = new CancionesFunciones();
                        DiscosFunciones funcionesDiscos=new DiscosFunciones();
                        Cancion cancion = new Cancion();
                        int i, f;    
                        boolean hayExcedente=false;
                        

                        //DEFINIR ID AUTOINCREMENTADO
                        int id = 1;    

                        //SE INSTANCIA UN PEDIDO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                        String email = sesion.getAttribute("email").toString();
                        float valor = Float.parseFloat(sesion.getAttribute("valorTotalCarrito").toString());
                        Date fecha = new Date();
                        String pago;
                        String entrega="Pendiente";
                        String formapago;

                        String opt = request.getParameter("optradio");

                        if(opt.equals("puerta"))
                        {
                          pago="Pendiente";
                          formapago="Puerta";
                        }else{
                                 pago="Pagado";
                                 formapago="Tarjeta";
                             }

                        //RECUPERO LISTA DEL CARRITO Y PREPARO EL ARREGLO DE CANCIONES PARA EL PEDIDO
                        ArrayList<Cancion> listaCancion = new ArrayList<>();
                        ArrayList<Disco> lista = (ArrayList<Disco>)sesion.getAttribute("listaCarrito");
                        
                        //CONTROL DE LOS DISCOS DE LOS CARRITOS Y ACTUALIZACIÓN DE CANTIDAD PARA GUARDAR EN PEDIDOS_CANCIONES
                       for(i=0; i<lista.size(); i++)
                        {   Disco dis = lista.get(i);
                            cancion = funcionesCanciones.getOne(dis.getUpc(), 0);
                            boolean discoenLista = false;
                            if(listaCancion.isEmpty())
                            {   cancion.setCantidad(1);
                                listaCancion.add(cancion);
                            }
                            else{
                                    for(f=0; f<listaCancion.size(); f++)
                                    {   
                                         Cancion can = listaCancion.get(f);
                                         if(can.getUpc()==dis.getUpc())
                                         {   
                                              listaCancion.get(f).setCantidad(can.getCantidad()+1);
                                              discoenLista = true;
                                              break;
                                         }
                                    }
                                    if(!discoenLista){ 
                                                        cancion.setCantidad(1); 
                                                        listaCancion.add(cancion);} 
                                    
                                }   
                        }
                        
                        //CONTROL DE LAS CANTIDADES DE DISCOS POR COMPRAR Y LA CANTIDAD ACTUAL EN STOCK.
                        for(f=0; f<listaCancion.size(); f++)
                        {   Cancion can = listaCancion.get(f);
                            int stock = funcionesDiscos.getStock(can.getUpc());
                            if(stock<can.getCantidad())
                            {
                                listaCancion.get(f).setExcede(stock-can.getCantidad());
                                hayExcedente=true;
                                
                            }else{listaCancion.get(f).setExcede(0);}
                        }
                        
                        if(hayExcedente)
                        {
                            sesion.setAttribute("listaCanciones", listaCancion);
                            response.sendRedirect("p_excedeConfirmar.jsp");
                            
                        }else{
                        
                                Pedido pedido = new Pedido(id, valor, fecha, entrega, pago, formapago, email);
                                funciones.alta(pedido, listaCancion);

                                sesion.setAttribute("mensajeExito", "La compra se realizó correctamente. <br> Muchas gracias por elegirnos!");
                                response.sendRedirect("p_confirmar.jsp");
                                }
                        
                   }else{
                                response.sendRedirect("p_confirmar.jsp");
                        }
            } else{
                           
                            response.sendRedirect("p_confirmar.jsp");
                   } 


            }
        catch (Exception e)
            {
                sesion.setAttribute("errorCatch", e.toString());
                response.sendRedirect("error.jsp");
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
