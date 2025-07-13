package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BoardDeletePassFormServlet
 */
@WebServlet("/board/deletepassform")
public class BoardDeletePassFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		//포워드
		RequestDispatcher rd = request.getRequestDispatcher("./deletepassform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
