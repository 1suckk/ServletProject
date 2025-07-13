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
 * Servlet implementation class BoardUpdateProcessServlet
 */
@WebServlet("/board/update")
public class BoardUpdateProcessServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		
		//num, pageNum을 읽어서 request 에 저장
		String pageNum = request.getParameter("pageNum");
		
		BoardDto dto = new BoardDto();
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setSubject(request.getParameter("subject"));
	    dto.setContent(request.getParameter("content"));
	    
	    dao.updateBoard(dto);
	    
		//다시 목록으로 이동
		response.sendRedirect("./detail?num="+dto.getNum()+"&pageNum="+pageNum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}