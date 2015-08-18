package Controller.Pedidos;

import Actions.Pedidos.PedidosFunciones;
import Actions.Usuarios.UsuariosFunciones;
import Model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pAltaController extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        PedidosFunciones funciones = new PedidosFunciones();
        UsuariosFunciones funcionesUsuario = new UsuariosFunciones();
        
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
                                                Date fecha = new Date();
                                                
                                                float valor = Float.parseFloat(request.getParameter("valor"));
                                                

                                                Pedido pedido = new Pedido(id, valor, fecha, estado, email);
                                                funciones.alta(pedido);

                                                response.getWriter().print("EL PEDIDO SE REGISTRÓ CORRECTAMENTE");
                                                
                                                }
                                        
                                    } else{
                                        response.getWriter().print("EL USUARIO NO SE ENCUENTRA REGISTRADO");
                                           } 
                                    
                                  
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("ERROR OCURRIDO:  "+e);
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
