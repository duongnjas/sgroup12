package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookieControl
 */
@WebServlet(name = "/DeleteCookieControl", urlPatterns = { "/deletecookie" })
public class DeleteCookieControl extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		System.out.println(id);
		Cookie[] cookies = null;
		cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if(cookie.getValue()==id) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}

		request.getRequestDispatcher("/cookie").forward(request, response);
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
}
