package Controller.Usuario;

import Json.JSONObject;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class uLoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession sesion = request.getSession(true); 
        Actions.Usuarios.UsuariosFunciones funciones = new Actions.Usuarios.UsuariosFunciones();
        try{
                                    String email = request.getParameter("email");
                                    String pass  = request.getParameter("pass");
                                    Usuario user = new Usuario(email, pass);
                                    
                                    String temp = (String)sesion.getAttribute("email"); 
                                    if( temp == null)        
                                    {if(funciones.login(user))
                                        {   
                                            user = funciones.getOne(email);
                                            //GUARDA LA INFORMACIÓN DEL USUARIO LOGUEADO
                                            
                                            /*
                                            *   NO ES LA MEJOR OPCIÓN, PUEDE MEJORAR, SE PUSO DE ESTA FORMA PARA PROBAR LA VARIABLE DE SESION
                                            *
                                            */
                                            
                                            sesion.setAttribute("email", email);
                                            sesion.setAttribute("pass", user.getPass());
                                            sesion.setAttribute("nombre", user.getNombre());
                                            sesion.setAttribute("apellido", user.getApellido());
                                            sesion.setAttribute("direccion", user.getDireccion());
                                            sesion.setAttribute("ciudad", user.getCiudad());
                                            sesion.setAttribute("dni", user.getdni());
                                            sesion.setAttribute("provincia", user.getProvincia());
                                            sesion.setAttribute("tipo", user.getTipo());    
                                            
                                            RequestDispatcher rd =null;
                                            rd=request.getRequestDispatcher("index.jsp");
                                            rd.forward(request, response);
                                                                                      
                                            
                                            
                                            
                                        }else{
                                                response.getWriter().write("Usuario no encontado.");
                                                
                                        }
                                    
                                    } else {response.getWriter().write("Ya hay un usuario registrado."); }
                                    
                                 
                                    }
                                catch (Exception e)
                                    {   sesion.setAttribute("errorCatch", e.toString());
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
