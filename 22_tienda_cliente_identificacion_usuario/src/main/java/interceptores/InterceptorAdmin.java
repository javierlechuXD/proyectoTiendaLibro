package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorAdmin extends HandlerInterceptorAdapter{

	// Este método se ejecuta antes de las llamadas a la/s rutas asociadas al interceptor
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//Para el caso en el que se identifique en el admin en loginAdmin.jsp
		if (request.getParameter("pass") != null && 
			request.getParameter("pass").equals("123")) {
			//Metemos un pequeño toquen en sesión, para indicar que el usuario actual es administrador
			request.getSession().setAttribute("admin", "ok");
		}
		
		// Para sucesivas llamadas a cualquier ruta en /admin/
		
		if (request.getSession().getAttribute("admin") != null && 
			request.getSession().getAttribute("admin").equals("ok")) {
			return true;
		}else {
			// forzar redirección a loginAdmin.jsp
			response.sendRedirect("../loginAdmin.jsp");
			
			// Se indica si el interceptor ha actudado
			return false;
		}
	}

	
}
