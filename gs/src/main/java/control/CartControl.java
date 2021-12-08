/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class CookieControl
 */
@WebServlet(name = "/CookieControl", urlPatterns = { "/cookie" })
public class CartControl extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product pro = new Product();
		DAO dao = new DAO();
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("pid");
		Cookie abc = new Cookie(""+id+"", id);
		
		abc.setMaxAge(60*60);
		response.addCookie(abc);
		
		Cookie[] cookies = null;
		cookies = request.getCookies();
		
		List<Product> listcp = new ArrayList<>();
		double tong = 0;
		for (Cookie cookie : cookies) {
			String gid = cookie.getValue();
			System.out.println(gid);
			System.out.println(cookie.getName());
			pro = dao.getProductByID(gid);
			if (pro != null) {
				listcp.add(pro);
				tong += pro.getPrice();
			}else {
				System.out.println(0);
			}
		}
		double tongtien = tong + 10;
		request.setAttribute("Tong", tong);
		request.setAttribute("TongTien", tongtien);
		request.setAttribute("ListCP", listcp);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
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

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}