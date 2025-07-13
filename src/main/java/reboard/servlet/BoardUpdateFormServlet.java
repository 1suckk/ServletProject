package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

/**
 * Servlet implementation class BoardUpdateFormServlet
 */
@WebServlet("/board/updateform")
public class BoardUpdateFormServlet extends HttpServlet {
	
	BoardDao dao = new BoardDao();
	//BoardDto dto = new BoardDto();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		
		BoardDto dto = dao.getData(Integer.parseInt(num));
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		//수정 창으로 들어가면 원래 입력된 제목과 내용은 유지되어 있어야 한다
		request.setAttribute("subject", dto.getSubject());
	    request.setAttribute("content", dto.getContent());
		
		//포워드
		RequestDispatcher rd = request.getRequestDispatcher("./updateform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
