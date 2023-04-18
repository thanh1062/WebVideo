package edu.poly.site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDAO;
import edu.poly.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(urlPatterns = { "/register" })
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		
//		User user = new User();
//		try {
//				
//			BeanUtils.populate(user, request.getParameterMap());
//			
//			UserDAO dao = new UserDAO();
////			System.out.print(dao);
//			dao.insert(user);
//			
//			request.getRequestDispatcher("/login").forward(request, response);
//			return;
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("error", e.getMessage());
//		}
//		request.setAttribute("user", user);
//		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
//		
//		
		
		
		
		
		
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			System.out.print(user.getId());
			dao.insert(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Registration success!");
			response.sendRedirect("/login");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Registration failed!");
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	
	}

}
