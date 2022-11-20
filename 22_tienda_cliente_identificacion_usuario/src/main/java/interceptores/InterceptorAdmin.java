package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorAdmin extends HandlerInterceptorAdapter{

	//este metodo se ejecuta antes de las llamadas a la/s rutas 
	//asociadas al interceptor
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		//para el caso en que se identifique el admin en loginAdmin.jsp
		if( request.getParameter("pass")!=null && 
			request.getParameter("pass").equals("123")){
			//metemos un pequeño token en sesion para indicar que el 
			//usuario actual es administrador
			request.getSession().setAttribute("admin", "ok");
		}//end if form loginAdmin.jsp
		
		//para sucesivas llamadas a cualquier ruta en /admin/
		if( request.getSession().getAttribute("admin") != null && 
			request.getSession().getAttribute("admin").equals("ok")) {
			return true;
		}else {
			//forzar redireccion a loginAdmin.jsp
			response.sendRedirect("../loginAdmin.jsp");
			return false;
		}//end else
		
	}//end preHandle
	
}//end class
