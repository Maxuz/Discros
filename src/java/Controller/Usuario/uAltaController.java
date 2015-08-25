package Controller.Usuario;

import Actions.Util;
import Model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Actions.StringMD;

public class uAltaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Util validar = new Util();
        HttpSession sesion = request.getSession(true); 
        RequestDispatcher rd =null;
        Actions.Usuarios.UsuariosFunciones funciones = new Actions.Usuarios.UsuariosFunciones();
       
        try{
                            //VALIDA SI NO HAY UN USUARIO YA LOGUEADO
                            if(sesion.getAttribute("nombre")==null)
                            {
                                    String email = request.getParameter("email");
                                    String pass  = StringMD.getStringMessageDigest(request.getParameter("pass"), StringMD.SHA1);
                                    String email2 = request.getParameter("email2");
                                    String pass2 = StringMD.getStringMessageDigest(request.getParameter("pass2"), StringMD.SHA1);
                                    
                                    //VALIDA QUE LOS EMAILS SEAN IGUALES Y NO VACÍOS
                                    if(validar.esIgual(email, email2) && !validar.estaVacio(email) && !validar.estaVacio(email2))
                                    {
                                      //VALIDA QUE LOS PASS SEAN IGUALES Y NO VACÍOS   
                                      if(validar.esIgual(pass, pass2)&& !validar.estaVacio(pass) && !validar.estaVacio(pass2))
                                        {
                                            
                                        //VERIFICA SI EL USUARIO QUE SE QUIERE REGISTRAR YA ESTÁ REGISTRADO
                                        if(funciones.buscar(email))
                                            { 
                                                sesion.setAttribute("mensajeError", "El email ya se encuentra registrado. Por favor elija otro.");
                                                response.sendRedirect("u_alta.jsp");

                                            }else{

                                                String nombre = request.getParameter("nombre");
                                                String apellido = request.getParameter("apellido");
                                                String direccion = request.getParameter("direccion");
                                                String ciudad = request.getParameter("ciudad");
                                                String provincia = request.getParameter("provincia");
                                                Integer dni = Integer.parseInt(request.getParameter("dni"));

                                               
                                                Usuario user = new Usuario(email, pass, nombre, apellido, direccion, ciudad, provincia, dni);
                                                
                                                funciones.alta(user);
                                                
                                                sesion.setAttribute("email", email);
                                                sesion.setAttribute("nombre", user.getNombre());
                                                sesion.setAttribute("tipoUsuario", user.getTipo()); 
                                                
                                                sesion.setAttribute("mensajeExito", "Usuario logueado correctamene.");
                                                response.sendRedirect("u_alta.jsp");
                                                }
                                          }
                                    } 
                                    //terminar    
                                   }else {
                                        sesion.setAttribute("mensajeExito", "Ya se encuentra un usuario logueado.");
                                                                          
                                        response.sendRedirect("u_alta.jsp");
                                                                     
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
