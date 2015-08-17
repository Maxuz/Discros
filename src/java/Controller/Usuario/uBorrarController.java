package Controller.Usuario;

import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "uBorrarController", urlPatterns = {"/uBorrar.do"})
public class uBorrarController extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(true); 
        Actions.Usuarios.UsuariosFunciones funciones = new Actions.Usuarios.UsuariosFunciones();
        
        try{
                                    String email = request.getParameter("email");
                                    String pass  = request.getParameter("pass");
                                        
                                    Usuario user = new Usuario(email, pass);
                                    

                                    if(funciones.login(user))
                                    {   
                                        user=funciones.getOne(email);
                                        if(user.getTipo().equals("cliente"))
                                        {
                                        funciones.setEstado(email, false);
                                        sesion.setAttribute("mensajeExiste", "");
                                        response.sendRedirect("u_borrar.jsp");
                                        }
                                        else{
                                              sesion.setAttribute("mensajeExiste", "No se puede deshabilitar a un administrador.");
                                              response.sendRedirect("u_borrar.jsp");
                                            }
                                    }else{
                                              sesion.setAttribute("mensajeExiste", "Cliente dado de baja correctamente.");
                                              response.sendRedirect("u_baja.jsp");
                                    }

                                    

                               
                                    }
                                catch (Exception e)
                                    {
                                        sesion.setAttribute("errorCatch", e.toString());
                                        RequestDispatcher rd =null;
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
