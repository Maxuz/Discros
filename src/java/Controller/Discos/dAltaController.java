package Controller.Discos;

import Actions.Canciones.CancionesFunciones;
import Model.Cancion;
import Model.Disco;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class dAltaController extends HttpServlet {
    
   private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }     
        
       // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        Actions.Discos.DiscosFunciones funciones = new Actions.Discos.DiscosFunciones();
        HttpSession sesion = request.getSession(true); 
        try{
                        
                      
                                   /* if(funciones.buscar(upc))
                                    {   sesion.setAttribute("mensajeError", "El disco ya se encuentra registrado, por favor ingrese otro UPC.");
                                        response.sendRedirect("d_alta.jsp");
                                       
                                        
                                    } else if((ArrayList<Model.Cancion>)sesion.getAttribute("cancionesDisco") == null){
                                        sesion.setAttribute("mensajeError", "No puede registrar un disco sin canciones, por favor ingrese al menos una canción");
                                        response.sendRedirect("d_alta.jsp");
                                    }else{
                                         */
                                        //SE INSTANCIA UN DISCO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                                        String artista = "";
                                        String album = "";
                                        String genero = "";
                                        String descripcion = "";
                                        String stock = "";
                                        String fecha = "";
                                        String precio = "";
                                        String upc = "";
                                        
                                        String isrc = "";
                                        String track="";
                                        String nombre="";
                                        String duracion="";
                                        String precio2="";
                                        ArrayList<Model.Cancion> canciones = new ArrayList<Model.Cancion>();
                                        
                                        @SuppressWarnings("unchecked")
                                        List<FileItem> formItems = upload.parseRequest(request);
                                        String auxIMG= "";
                                        if (formItems != null && formItems.size() > 0) {
                                            // iterates over form's fields
                                            for (FileItem item : formItems) {
                                                // processes only fields that are not form fields
                                                if (!item.isFormField()) {
                                                    String fileName = new File(item.getName()).getName();
                                                    //Modificar el fileName 
                                                    String filePath = uploadPath + File.separator + upc +".jpg";
                                                    File storeFile = new File(filePath);
                                                    auxIMG = fileName;      
                                                    // saves the file on disk
                                                    item.write(storeFile);
                                                    request.setAttribute("message","Upload has been done successfully!");
                                                }else {
                                                    String fieldname = item.getFieldName();
                                                    String fieldvalue = item.getString();
                                                    if (fieldname.equals("upc")) {
                                                        upc = fieldvalue;
                                                    } else if (fieldname.equals("artista")) {
                                                        artista = fieldvalue;
                                                    }else if(fieldname.equals("album")){
                                                        album = fieldvalue;
                                                    }
                                                    else if (fieldname.equals("genero")){
                                                        genero = fieldvalue;
                                                    }else if(fieldname.equals("stock")){
                                                        stock = fieldvalue;
                                                    }else if(fieldname.equals("descripcion")){
                                                        descripcion = fieldvalue;
                                                    }else if(fieldname.equals("precio")){
                                                        precio = fieldvalue;
                                                    }else if(fieldname.equals("isrc")){
                                                       break;// isrc = fieldvalue;
                                                    }/*else if(fieldname.equals("track")){
                                                        track = fieldvalue;
                                                    }else if(fieldname.equals("nombre")){
                                                        nombre = fieldvalue;
                                                    }else if(fieldname.equals("duracion")){
                                                        duracion = fieldvalue;
                                                    }else if(fieldname.equals("precio2")){
                                                        precio2 = fieldvalue;
                                                        Model.Cancion cancion = new Model.Cancion(nombre,Float.parseFloat(precio2),Long.parseLong(isrc),Long.parseLong(upc),Integer.parseInt(duracion),Integer.parseInt(track));
                                                        canciones.add(cancion);
                                                    }*/
                                                    
                                                }
                                            }
                                        String imagen = "upload/"+upc+".jpg";
                                        canciones = (ArrayList<Model.Cancion>) sesion.getAttribute("cancionesDisco");
                                        String aux = "prueba";
                                        
                                        Disco disco = new Disco(artista, album, genero, descripcion, imagen, Long.parseLong(upc), Integer.parseInt(stock), String.valueOf(Date.from(Instant.EPOCH)));
                                        
                                        funciones.alta(disco,canciones,Float.parseFloat(precio));
                                           
                                        sesion.setAttribute("mensajeExito", "Disco agregado correctamente.");
                                        response.sendRedirect("d_alta.jsp");
                                        
                                        }
                                    }
                                catch (Exception e)
                                    {
                                        sesion.setAttribute("errorCatch", e.toString());
                                        response.sendRedirect("error.jsp");
                                    }
                                finally{
                                    
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