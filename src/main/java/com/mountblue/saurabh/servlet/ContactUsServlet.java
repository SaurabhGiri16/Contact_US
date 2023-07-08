package com.mountblue.saurabh.servlet;

import com.mountblue.saurabh.dao.RequestDao;
import com.mountblue.saurabh.model.Request;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("Submitted", "notNull");
		RequestDispatcher requestPage = request.getRequestDispatcher("contactus.jsp");
		requestPage.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		Request saveRequest = new Request();
		saveRequest.setFullName(name);
		saveRequest.setEmail(email);
		saveRequest.setMessage(message);

		RequestDao.saveRequest(saveRequest);

		HttpSession session = request.getSession();
		session.setAttribute("Submitted", null);

		RequestDispatcher requestPage = request.getRequestDispatcher("contactus.jsp");
		requestPage.forward(request, response);
	}
}
