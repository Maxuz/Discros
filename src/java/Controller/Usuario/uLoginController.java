package Controller.Usuario;

import Model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Actions.StringMD;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;


public class uLoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession sesion = request.getSession(true); 
         //final String pathServlet = getServletContext().getRealPath("/uploads");
         //final String pathServletR = getServletContext().getContextPath();
         
        /*
         String direc = getServletContext().getRealPath("/");
         String p = System.getProperty("user.dir");
         String p1 = System.getProperty("user.home");
         String p2 = System.getProperty("java.home");
         String p3 = System.getProperty("user.name");
         Key	Meaning
        "file.separator"	Character that separates components of a file path. This is "/" on UNIX and "\" on Windows.
        "java.class.path"	Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a platform-specific character specified in the path.separator property.
        "java.home"	Installation directory for Java Runtime Environment (JRE)
        "java.vendor"	JRE vendor name
        "java.vendor.url"	JRE vendor URL
        "java.version"	JRE version number
        "line.separator"	Sequence used by operating system to separate lines in text files
        "os.arch"	Operating system architecture
        "os.name"	Operating system name
        "os.version"	Operating system version
        "path.separator"	Path separator character used in java.class.path
        "user.dir"	User working directory
        "user.home"	User home directory
        "user.name"	User account name*/
         
        Actions.Usuarios.UsuariosFunciones funciones = new Actions.Usuarios.UsuariosFunciones();
        RequestDispatcher rd =null;
        try{                        sesion.setAttribute("mensajeExito", null);
                                    String email = request.getParameter("email");
                                    String pass  = StringMD.getStringMessageDigest(request.getParameter("pass"), StringMD.SHA1);
                                    
                                    // REALIZAR MÉTODO PARA ENCRIPTAR
                                    
                                    //  String pass  = MÉTODOENCRIPTAR(request.getParameter("pass"));
                                    
                                    Usuario user = new Usuario(email, pass);
                                  
                                    if(funciones.login(user))
                                        {   
                                            user = funciones.getOne(email);
                                           
                                            if(user.getEstado())
                                            {
                                            sesion.setAttribute("email", email);
                                            sesion.setAttribute("nombre", user.getNombre());
                                            sesion.setAttribute("tipoUsuario", user.getTipo()); 
                                           
                                            response.sendRedirect("index.jsp");
                                            } else {
                                                        sesion.setAttribute("mensajeExito", "Usuario no habilitado");
                                                        response.sendRedirect("u_login.jsp");
                                                    }
                                        }else{  
                                                sesion.setAttribute("mensajeExito", "Usuario o contraseña incorrecta.");
                                                response.sendRedirect("u_login.jsp");
                                                
                                        }
                                    
                                                                      
                                    }
                                catch (Exception e)
                                    {   sesion.setAttribute("errorCatch", e.toString());
                                                                               
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
