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
import java.util.List;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	BoardDao dao=new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int perPage = 5; //페이지당 게시글 수
		int perBlock = 5; //한 블럭 당 출력할 페이지의 수
		int totalCount;//전체 게시글 갯수
		int totalPage = 0; //총 페이지 수
		int startNum; //각 페이지에서 가져올 시작번호(mysql은 첫데이터가 0번 오라클은 1번)
		int startPage; //각 블럭에서 출력할 시작페이지
		int endPage; //각 블럭에서 출력할 끝페이지
		int no; //각 페이징서 출력한 시작 번호
		int pageNum; //현재 페이지 번호
		
		List<BoardDto> list=null; //페이징에 필요한 데이타
		
		//현재 페이지를 얻는다 (null 일경우 1페이지로)
		try
		{
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		catch(NumberFormatException e)
		{
			pageNum = 1;
		}
		
		totalCount=dao.getTotalCount(); //글의 총 갯수를 변수에 저장
		totalPage = totalCount/perPage+(totalCount%perPage>0?1:0); //총 페이지 갯수
		//시작페이지
		startPage = (pageNum-1)/perBlock*perBlock+1;
		//끝페이지
		endPage = startPage + perBlock - 1;
		//endPage는 totalPage를 넘을 수 없음
		if (endPage > totalPage)
			endPage = totalPage;
		//현재 페이지의 시작 번호 (가장 작은 번호; 내림차순이니까)
		startNum = perPage*(pageNum-1); //mysql은 첫 글이 0번, 오라클은 첫 글이 1번
		
		list=dao.getPagingList(startNum, perPage);
		
		//마지막 페이지의 1개 남은 글을 지우고 다시 해당페이지로
		//있을 경우 데이터가 안나오는 현상
		if(list.size()==0)
		{
			response.sendRedirect("./list?pageNum="+(pageNum-1));
			return;
		}
		
		//각 페이지의 글앞에 출력할 시작번호 (예: 총글이 20게일경우 1페이지는 20, 2페이지는 15)
		no = totalCount-(pageNum-1)*perPage;
		
		//request 에 저장
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		
		//페이지 출력에 필요한 모든 변수를 request에 넣는다
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("no", no);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		
		RequestDispatcher rd=request.getRequestDispatcher("./boardlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}