package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.BoardService;
import VOs.BoardVO;
import VOs.MemberVO;

@WebServlet("/Board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter printWriter;
	private BoardService boardService;

	private String nextPage;

	public void init(ServletConfig config) throws ServletException {
		
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		printWriter = response.getWriter();

		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		switch (action) {
		case "/list.bo": openBoardListView(request, response); break;
		case "/write.bo": openBoardWriteView(request, response); break;
		case "/writePro.bo": processBoardWrite(request, response); return;
		case "/searchlist.bo": processBoardSearch(request, response); break;
		case "/read.bo": openBoardContentView(request, response); break;
		case "/password.bo": processBoardContentPassword(request, response); return;
		case "/update.bo": processBoardContentUpdate(request, response); return;
		case "/delete.bo": processBoardContentDelete(request, response); return;
		case "/reply.bo": openBoardReplyView(request, response); break;
		case "/replyPro.bo": processBoardReply(request, response); break;

		default:
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
	private void openBoardListView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loginedId = (String) session.getAttribute("id");
		
		ArrayList<BoardVO> boardsList = boardService.selectBoards();
				
		request.setAttribute("boardsList", boardsList);
		request.setAttribute("id", loginedId);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		request.setAttribute("currentBlock", request.getParameter("currentBlock"));
		request.setAttribute("center", "board/list.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void openBoardWriteView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberVO member = boardService.selectMember(request);
		
		request.setAttribute("member", member);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		request.setAttribute("currentBlock", request.getParameter("currentBlock"));
		request.setAttribute("center", "board/BoardWrite.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void processBoardWrite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result = boardService.insertBoard(request);
		
		printWriter.print(result);
	}
	
	private void processBoardSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<BoardVO> boardsList = boardService.selectSearchedBoards(request);

		request.setAttribute("boardsList", boardsList);
		request.setAttribute("center", "board/list.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void openBoardContentView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardVO board = boardService.selectBoard(request);		

		String currentPage = request.getParameter("currentPage");
		String currentBlock = request.getParameter("currentBlock");
		
		request.setAttribute("board", board);
		request.setAttribute("idx", request.getParameter("idx"));
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("currentBlock", currentBlock);
		request.setAttribute("center", "board/BoardRead.jsp");

		nextPage = "/CarMain.jsp";
	}
	
	private void processBoardContentPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result = boardService.checkBoardPassword(request);
		
		printWriter.print(result);
	}
	
	private void processBoardContentUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result = boardService.updateBoard(request);
		
		printWriter.print(result == 1);
	}
	
	private void processBoardContentDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result = boardService.deleteBoard(request);
		
		printWriter.print(result == 1);
	}
	
	private void openBoardReplyView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberVO replyMember = boardService.selectMember(request.getParameter("id"));
		
		request.setAttribute("replyMember", replyMember);
		request.setAttribute("parentIdx", request.getParameter("idx"));
		request.setAttribute("center", "board/BoardReply.jsp");

		nextPage = "/CarMain.jsp";
	}
	
	private void processBoardReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result = boardService.insertReplyBoard(request);

		nextPage = "/Board/list.bo";
	}
}
