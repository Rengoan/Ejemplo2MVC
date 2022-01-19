package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        
        //1.Procesamos los parametros
//        String base = request.getParameter("base");
//        String altura = request.getParameter("altura");
        
        //2.Creamos los JavaBeans que vamos a usar en nuestra aplicacion
        Rectangulo rec = new Rectangulo(4,5);
        
        //3.Vamos a compartir nuestras variables en un determinado alcance
        request.setAttribute("mensaje", "Saludos clsae desde mi Servlet");
        
        //Tambien podemos compartir en alcance de Sesion
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //4.Redireccionamos a un JSP
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response);
    }
}
