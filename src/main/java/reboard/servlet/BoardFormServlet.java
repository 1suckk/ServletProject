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

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class BoardFormServlet
 */
@WebServlet("/board/writeform")
public class BoardFormServlet extends HttpServlet {
	BoardDao dao = new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num, regroup, restep, relevel 을 읽는데 새글일 경우에는 null값, 답글일 경우에는
		//정수 타입의 숫자가 넘어온다
		int num, regroup, restep, relevel;
		String subject = "";
		
		try {
			num = Integer.parseInt(request.getParameter("num"));
			regroup = Integer.parseInt(request.getParameter("regroup"));
			restep = Integer.parseInt(request.getParameter("restep"));
			relevel = Integer.parseInt(request.getParameter("relevel"));
			//원글의 제목 얻기
			subject = dao.getData(num).getSubject();
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			num=regroup=restep=relevel=0;
		}
		
		//request 에 저장
		request.setAttribute("num", num);
		request.setAttribute("regroup", regroup);
		request.setAttribute("restep", restep);
		request.setAttribute("relevel", relevel);
		request.setAttribute("subject", subject);
		
		//포워드
		RequestDispatcher rd = request.getRequestDispatcher("./writeform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
