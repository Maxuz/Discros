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
           String email = sesion.getAttribute("email").toString();
            if(email!=null)
           {
               //VERIFICA QUE LA URL SEA CORRECTA
               if(request.getParameter("id")!=null && !request.getParameter("id").equals("") && request.getParameter("estado")!=null && !request.getParameter("estado").equals(""))
               {    
                   
                
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
