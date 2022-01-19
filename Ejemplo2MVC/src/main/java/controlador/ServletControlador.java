package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.Procesamos los parametros
        String accion = request.getParameter("accion");

        //2.Creamos los JavaBeans que vamos a usar en nuestra aplicacion
        Rectangulo recRequest = new Rectangulo(4, 5);
        Rectangulo recSesion = new Rectangulo(6, 10);
        Rectangulo recApp = new Rectangulo(1, 3);

        if ("agregarVariables".equals(accion)) {
            //Alcance request
            request.setAttribute("rectanguloRequest", recRequest);

            //Alcance sesion
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion",recSesion);

            //Alcance app
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplicacion", recApp);

            //Ahora redireccionamos
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("listarVariables".equals(accion)){
            
            request.getRequestDispatcher("/WEB-INF/alcanceVariables.jsp").forward(request, response);
            
        }else{
            request.setAttribute("mensaje", "accion no proporcionada o accion desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}
