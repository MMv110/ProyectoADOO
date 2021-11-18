import Modelo.Pregunta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePregunta extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String pregunta = request.getParameter("pregunta");
            int respuesta = Integer.parseInt(request.getParameter("respuesta"));
            String opcion1 = request.getParameter("opcion1");
            String opcion2 = request.getParameter("opcion2");
            String opcion3 = request.getParameter("opcion3");
            String opcion4 = request.getParameter("opcion4");
        
            System.out.println(opcion1);
            Pregunta p = new Pregunta(id,nombre,pregunta,respuesta,opcion1,opcion2,opcion3,opcion4);
            p.updatePregunta();
            response.sendRedirect("/ProyectoTriangulo");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
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
