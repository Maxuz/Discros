package Controller.Pedidos;

import Actions.Pedidos.PedidosFunciones;
import Actions.Usuarios.UsuariosFunciones;
import Model.Disco;
import Model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
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
        PedidosFunciones funciones = new PedidosFunciones();
        UsuariosFunciones funcionesUsuario = new UsuariosFunciones();
        
       try{
                                    if(funcionesUsuario.buscar(sesion.getAttribute("email").toString()))
                                    {
                                         //SE INSTANCIA UN PEDIDO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                                                
                                                //DEFINIR ID AUTOINCREMENTADO
                                     
                                                
                                                //SETEO VARIABLES DEL PEDIDO
                                                String email = sesion.getAttribute("email").toString();
                                                float valor = Float.parseFloat(sesion.getAttribute("valorTotalCarrito").toString());
                                                Date fecha = new Date();
                                                
                                                String opt = request.getParameter("optradio");
                                                
                                                if(opt.equals("puerta"))
                                                {
                                                    
                                                }else{
                                                         
                                                     }
                                                
                                                
                                                //RECUPERO LISTA DEL CARRITO
                                                ArrayList<Disco> lista = (ArrayList<Disco>)sesion.getAttribute("listaCarrito");
                                                
                                         //       Pedido pedido = new Pedido(id, valor, fecha, "d", email);
                                         //       funciones.alta(pedido);

                                                response.getWriter().print("EL PEDIDO SE REGISTRÓ CORRECTAMENTE");
                                                 
                                    } else{
                                        response.getWriter().print("EL USUARIO NO SE ENCUENTRA REGISTRADO");
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
