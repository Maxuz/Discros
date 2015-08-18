package Controller;

import Actions.Pedidos.PedidosFunciones;
import Actions.Canciones.CancionesFunciones;
import Actions.PedidosCanciones.PedidosCancionesFunciones;
import Actions.Util;
import Model.PedidosCanciones;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PedidosCancionesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Util validar = new Util();
        String funcion = request.getParameter("funcion");
        
        PedidosCancionesFunciones funciones = new PedidosCancionesFunciones();
        
        CancionesFunciones funcionesCanciones = new CancionesFunciones();
        PedidosFunciones funcionesPedidos = new PedidosFunciones();
        
        if(validar.estaVacio(funcion)==true)
        {  
            switch (funcion){
                case "alta": { // <editor-fold desc="ALTA">
                                try{
                                    int isrc;
                                    int cantidad;
                                    
                                    int id_pedido = Integer.parseInt(request.getParameter("id_pedido"));
                                    
                                    if(request.getParameter("iscr").equals(""))
                                    {   
                                        isrc = 0;
                                        cantidad = Integer.parseInt(request.getParameter("cantidad"));
                                    }
                                        else{isrc = Integer.parseInt(request.getParameter("isrc"));
                                             cantidad = 1;
                                            }    
                                    
                                    int upc = Integer.parseInt(request.getParameter("upc"));
                                    
                                    if(funcionesPedidos.buscar(id_pedido))
                                    {
                                      if(funcionesCanciones.buscar(upc, isrc))
                                      {
                                          if(!funciones.buscar(id_pedido, upc, isrc))
                                          {
                                             
                                              PedidosCanciones pc = new PedidosCanciones(id_pedido, isrc, upc, cantidad);
                                              funciones.alta(pc);
                                              
                                              response.getWriter().print("Se cargó correctamene el ítem en el pedido.");
                                              
                                          } else {response.getWriter().print("El ítem ya se encuentra cargado al pedido.");}
                                          
                                      } else { response.getWriter().print("Cancion no encontrada."); }
                                        
                                    } else { response.getWriter().print("Pedido no encontrado."); }
                                   
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("ERROR OCURRIDO:  "+e);break;
                                    }
                                // </editor-fold>
                              }
                case "baja":  {// <editor-fold desc="BAJA">
                               try{
                                   
                                   break;
                               }
                                    
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR ES EL SIGUIENTE:  "+e);break;
                                    }     
                               // </editor-fold>
                              }
                case "modificar":{// <editor-fold desc="MODIFICAR">
                                   
                                try{
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e); break;
                                    } 
                    
                    
                    
                               // </editor-fold>
                              }
                case "getOne":{// <editor-fold desc="GETONE">
                                    
                                try{
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);break;
                                    }
                                    // </editor-fold>
                                 }
                
                default: break;
            }
        
        
        
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
