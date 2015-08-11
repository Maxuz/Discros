package Controller.Pedidos;

import Actions.Pedidos.PedidosFunciones;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pBajaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        PedidosFunciones funciones = new PedidosFunciones();

         try{
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("id"))))
                                    {       
                                        //FALTA VERIFICAR SI NO HAY ALGUN PEDIDO REFERENCIADO EN PEDIDO - CANCIONES
                                        funciones.baja(Integer.parseInt(request.getParameter("id")));
                                        response.getWriter().print("Pedido eliminado correctamente.");
                                    } else {
                                             response.getWriter().print("Pedido no encontrado.");
                                            }
                                 
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR ES EL SIGUIENTE:  "+e);
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
