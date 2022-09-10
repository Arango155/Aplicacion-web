

import Clases.Alumno;
import Clases.AlumnoModell;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    AlumnoModell alumno;
    Alumno registroAlumno;
    AlumnoModell[] alumnosRegistrados;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
                   if(request.getMethod().equals("POST") && request.getParameter("code")!= null ) {
                            alumno = new AlumnoModell(
                                    request.getParameter("code"),
                                    request.getParameter("name"),
                                    request.getParameter("address"),
                                    request.getParameter("email"),
                                    request.getParameter("phone"),
                                    request.getParameter("tipo")
                            );
                            
                            if(registroAlumno == null){
                                registroAlumno = new Alumno();
                            }

                            if(!request.getParameter("code").equals("")){
                                registroAlumno.guardarAlumno(alumno);
                            }
                    }
                   
                   if(request.getParameter("position") != null){
                            String position = request.getParameter("position");
                            registroAlumno.remover(position);
                   }
                   
                    alumnosRegistrados = registroAlumno.getAlumnos();

                     out.println("<!DOCTYPE html>");
                     out.println("<html><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n" +
                     "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                     +"<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>"
                     +"<script src='js/script.js'></script>"
                     );
                     
                     out.println("<head>");
                     out.println("<title>Servlet ClienteController</title>");
                     out.println("</head>");
                     out.println("<body id=\"Vector\">");
            

                     out.println(
                     
                         );
                     for (int i = 0; i < alumnosRegistrados.length; i ++){
                         if(alumnosRegistrados[i] !=null){
                             out.println("<tr><td id=\"uno\">" + alumnosRegistrados[i].getCode()+  "</td>");
                             out.println("<td id=\"dos\">" + alumnosRegistrados[i].getName()+  "</td>");
                             out.println("<td id=\"tres\">" + alumnosRegistrados[i].getAddress()+   "</td>");
                             out.println("<td id=\"cuatro\">" + alumnosRegistrados[i].getEmail()+ "</td>");
                             out.println("<td id=\"cinco\">" + alumnosRegistrados[i].getPhone()+ "</td>");
                             out.println("<td id=\"seis\">" + alumnosRegistrados[i].getTipo()+ "</td>");
                             out.println("<td>"
                                        + "<button type=\"button\" class=\"btn btn-warning\" id=\"delete\"></i>Editar</button> "
                                        + "<button type=\"button\" class=\"btn btn-danger\" onclick='remove("+ i +");'>Eliminar</button>"
                                        + "</td></tr>");
                         }
                     }
                     out.println("</tbody></table>");
                     out.println("</div>");
                     out.println("<div class='container-lg d-flex'> <a href='index.html' class=\"btn btn-success ml-auto\">Registrar Nuevo Cliente</a></div><br>");
                     out.println("</form>");
                     
                     out.println("</body>");
                     out.println("</html>");

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
    
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        System.out.println("en dodelete");
//        System.out.println("postion=" + req.getParameter("position"));
//        processRequest(req, resp);
//        
//    }

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
