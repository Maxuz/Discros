package Controller;

import Actions.Usuarios.UsuariosFunciones;
import Actions.Pedidos.PedidosFunciones;
import Actions.Util;
import Model.Pedido;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
        Util validar = new Util();
        String funcion = request.getParameter("funcion");
        
        PedidosFunciones funciones = new PedidosFunciones();
        UsuariosFunciones funcionesUsuario = new UsuariosFunciones();
        
        if(validar.estaVacio(funcion)==true)
        {  
            switch (funcion){
                case "alta": { // <editor-fold desc="ALTA">
                                try{
                                    if(funcionesUsuario.buscar(request.getParameter("email")))
                                    {
                                        if(funciones.buscar(Integer.parseInt(request.getParameter("id"))))
                                        {
                                            response.getWriter().print("EL PEDIDO YA SE ENCUENTRA REGISTRADO");
                                        
                                        }
                                        else { //SE INSTANCIA UN PEDIDO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                                                int id = Integer.parseInt(request.getParameter("id"));
                                                
                                                String email = request.getParameter("email");
                                                String estado = request.getParameter("estado");
                                                long fecha = Date.parse(request.getParameter("fecha"));
                                                
                                                float valor = Float.parseFloat(request.getParameter("valor"));
                                                Date fecha2 = null;
                                           //     Pedido pedido = new Pedido(id, valor, fecha2, estado, email);
                                             //   funciones.alta(pedido);

                                                response.getWriter().print("EL PEDIDO SE REGISTRÓ CORRECTAMENTE");
                                                
                                                }
                                        
                                    } else{
                                        response.getWriter().print("EL USUARIO NO SE ENCUENTRA REGISTRADO");
                                           } 
                                    
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
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("id"))))
                                    {
                                        funciones.baja(Integer.parseInt(request.getParameter("id")));
                                        response.getWriter().print("Pedido eliminado correctamente.");
                                    } else {
                                             response.getWriter().print("Pedido no encontrado.");
                                            }
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
                                        if(funciones.buscar(Integer.parseInt(request.getParameter("id"))))
                                        {
                                                int id = Integer.parseInt(request.getParameter("id"));
                                                
                                                String email = request.getParameter("email");
                                                String estado = request.getParameter("estado");
                                                String fecha = request.getParameter("fecha");
                                                
                                                float valor = Float.parseFloat(request.getParameter("valor"));
                                                
                                                Date fecha2 = null;
                                             //   Pedido pedido = new Pedido(id, valor, fecha2, estado, email);
                                            //    funciones.modificar(pedido);

                                                response.getWriter().print("EL PEDIDO SE ACTUALIZÓ CORRECTAMENTE");
                                        }
                                        else {
                                                response.getWriter().print("Pedido no encontrado.");
                                             }
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
                                    
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("id"))))
                                        {
                                            int id = Integer.parseInt(request.getParameter("id"));
                                            Pedido pedido = new Pedido();
                                            pedido = funciones.getOne(id);
                                            
                                            response.getWriter().print("El pedido ha sido obtenido correctamente");
                                                break;
                                        } else {
                                                response.getWriter().print("El pedido no ha sido encontrado.");break;
                                                }
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
