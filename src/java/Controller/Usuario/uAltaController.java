package Controller.Usuario;

import Actions.Validacion;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class uAltaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Validacion validar = new Validacion();
        HttpSession sesion = request.getSession(true); 
        Actions.Usuarios.UsuariosFunciones funciones = new Actions.Usuarios.UsuariosFunciones();
       
        try{
                                    String email = request.getParameter("email");
                                    String pass  = request.getParameter("pass");
                                    String email2 = request.getParameter("email2");
                                    String pass2 = request.getParameter("pass2");
                                    
                                    if(validar.esIgual(email, email2) && !validar.estaVacio(email) && !validar.estaVacio(email2))
                                    {
                                      if(validar.esIgual(pass, pass2)&& !validar.estaVacio(pass) && !validar.estaVacio(pass2))
                                        {
                                        if(funciones.buscar(email))
                                            {response.getWriter().print("EL USUARIO YA SE ENCUENTRA REGISTRADO");

                                            }else{

                                                String nombre = request.getParameter("nombre");
                                                String apellido = request.getParameter("apellido");
                                                String direccion = request.getParameter("direccion");
                                                String ciudad = request.getParameter("ciudad");
                                                String provincia = request.getParameter("provincia");
                                                Integer dni = Integer.parseInt(request.getParameter("dni"));

                                                Usuario user = new Usuario(email, pass);
                                                user.setDatospersonales(nombre, apellido, direccion, ciudad, provincia, dni);

                                                funciones.alta(user);
                                                
                                                sesion.setAttribute("nombre", user.getNombre());
                                                
                                                sesion.setAttribute("mensajeExito", "Usuario logueado correctamene.");
                                                RequestDispatcher rd =null;

                                                rd=request.getRequestDispatcher("u_alta.jsp");
                                                rd.forward(request,response);
                                                }
                                          }
                                    } 
                             
                                   }
                                catch (Exception e)
                                    {
                                        sesion.setAttribute("errorCatch", e.toString());
                                        RequestDispatcher rd =null;
                                                                               
                                        rd=request.getRequestDispatcher("error.jsp");
                                        rd.forward(request,response);
                                        
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
