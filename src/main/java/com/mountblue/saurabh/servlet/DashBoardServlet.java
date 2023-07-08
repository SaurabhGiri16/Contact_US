package com.mountblue.saurabh.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mountblue.saurabh.dao.RequestDao;
import com.mountblue.saurabh.model.Request;

@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Request> activeRequests = RequestDao.fetchAllRequests(true);
		session.setAttribute("activeRequests", activeRequests);

		ArrayList<Request> archiveRequests = RequestDao.fetchAllRequests(false);
		session.setAttribute("archiveRequest", archiveRequests);

		RequestDispatcher requestPage = request.getRequestDispatcher("dashboard.jsp");
		requestPage.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String status = request.getParameter("status");

		if (status.equals("Active")) {
			RequestDao.changeStatus(userId, true);
		} else {
			RequestDao.changeStatus(userId, false);
		}
		response.sendRedirect("dashboard");
	}
}
