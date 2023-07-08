package com.mountblue.saurabh.servlet;

import com.mountblue.saurabh.dao.UserRepository;
import com.mountblue.saurabh.model.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.setAttribute("isWrongPassword", "hi");

		RequestDispatcher requestPage = request.getRequestDispatcher("login.jsp");
		requestPage.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);

		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);

		if (UserRepository.isValidUser(user)) {
			response.sendRedirect("dashboard");
		} else {
			session.setAttribute("isWrongPassword", null);
			RequestDispatcher requestPage = request.getRequestDispatcher("login.jsp");
			requestPage.forward(request, response);
		}
	}
}
