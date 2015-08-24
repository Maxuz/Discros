package Controller.Pedidos;

import Actions.Pedidos.PedidosFunciones;

import Model.Pedido;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class pModificarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        PedidosFunciones funciones = new PedidosFunciones();
        HttpSession sesion = request.getSession(true); 
         try{
           
            if(sesion.getAttribute("email")!=null)
           {   
               //VERIFICA QUE LA URL SEA CORRECTA
               if(request.getParameter("id")!=null && !request.getParameter("id").equals("") && request.getParameter("estado")!=null && !request.getParameter("estado").equals(""))
               {    
                   String estado = request.getParameter("estado");
                   
                   
                   if(estado.equals("Entregado") || estado.equals("Reclamado"))
                   {   int id = Integer.parseInt(request.getParameter("id"));
                       if(estado.equals("Entregado")){
                       funciones.actualizar(id, estado, "Pagado", "cliente");
                       sesion.setAttribute("mensajeExito", "Pedido modificado correctamente");
                       response.sendRedirect("exito.jsp");
                       }else{
                             funciones.actualizar(id, estado, "Pendiente", "cliente");
                             sesion.setAttribute("mensajeExito", "Pedido modificado correctamente");
                             response.sendRedirect("exito.jsp");
                            }
                   }
                   else{
                        if(estado.equals("Enviado"))
                        {    int id = Integer.parseInt(request.getParameter("id"));
                             Pedido ped = funciones.getOne(id);
                             
                             if(ped.getEmail() != null)
                             {
                                 if(!ped.getEstado().equals("Enviado") && !ped.getEstado().equals("Entregado") )
                                 {
                                    funciones.actualizar(id, estado, "", "admin");
                                    sesion.setAttribute("mensajeExito", "Pedido modificado correctamente");
                                    response.sendRedirect("exito.jsp");
                                    
                                 }
                                 else{
                                    sesion.setAttribute("mensajeError", "El pedido con ID:"+ id +" ya se encuentra enviado.");
                                    response.sendRedirect("p_informar.jsp?tipo=admin");
                                 }
                             }else{
                             sesion.setAttribute("mensajeError", "El pedido con ID:"+ id +" no ha sido encontrado.");
                             response.sendRedirect("p_informar.jsp?tipo=admin");
                             }
                        }
                   }
                
                //MENSAJE PARA LA URL INCORRECTA   
               }else{
                    response.sendRedirect("p_informar.jsp");
               }  
           //MENSAJE PARA USUARIOS NO LOGUEADOS
           }else{
                response.sendRedirect("p_informar.jsp");
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
