

import Modelo.Pregunta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NuevaPregunta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("Nombre");
        String pregunta = request.getParameter("pregunta");
        int respuesta = Integer.parseInt(request.getParameter("respuesta"));
        String opcion1 = request.getParameter("opcion1");
        String opcion2 = request.getParameter("opcion2");
        String opcion3 = request.getParameter("opcion3");
        String opcion4 = request.getParameter("opcion4");
        
        Pregunta p = new Pregunta(0,nombre,pregunta,respuesta,opcion1,opcion2,opcion3,opcion4);
        p.crearPregunta();
        response.sendRedirect("/");
        
    }

}
