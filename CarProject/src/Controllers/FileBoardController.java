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

import Services.FileBoardService;
import VOs.BoardVO;
import VOs.FileBoardVO;
import VOs.MemberVO;

@WebServlet("/FileBoard/*")
public class FileBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileBoardService fileBoardService;
	private PrintWriter printWriter;
	
	private String nextPage;

	public void init(ServletConfig config) throws ServletException {

		fileBoardService = new FileBoardService();
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

		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		switch (action) {
		case "/list.bo": openFileBoardListView(request, response); break;
		case "/searchlist.bo": processBoardSearch(request, response); break;
		case "/write.bo": openBoardWriteView(request, response); break;
		case "/writePro.bo": processBoardWrite(request, response); return;
		case "/read.bo": openBoardContentView(request, response); break;
		case "/fileDown.bo": processFileDownload(request, response); return;

		default:
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
	private void openFileBoardListView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loginedId = (String) session.getAttribute("id");
		
		ArrayList<FileBoardVO> boardsList = fileBoardService.selectFileBoards();

		request.setAttribute("boardsList", boardsList);
		request.setAttribute("id", loginedId);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		request.setAttribute("currentBlock", request.getParameter("currentBlock"));
		request.setAttribute("center", "fileBoard/list.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void processBoardSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<FileBoardVO> boardsList = fileBoardService.selectSearchedBoards(request);

		request.setAttribute("boardsList", boardsList);
		request.setAttribute("center", "fileBoard/list.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void openBoardWriteView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberVO member = fileBoardService.selectMember(request);
		
		request.setAttribute("member", member);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		request.setAttribute("currentBlock", request.getParameter("currentBlock"));
		request.setAttribute("center", "fileBoard/BoardWrite.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void processBoardWrite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int newBoardIdx = 0;
		printWriter = response.getWriter();
		
		try {
			newBoardIdx = fileBoardService.getInsertedBoardIdx(request, response);
			
			printWriter.print("<script>");
			printWriter.print("alert('게시글이 추가되었습니다.');");
			printWriter.print("location.href = '" + request.getContextPath() + "/FileBoard/list.bo';");
			printWriter.print("</script>");
			
			printWriter.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
			printWriter.print("<script>");
			printWriter.print("alert('게시글 추가에 실패했습니다.');");
			printWriter.print("location.href = '" + request.getContextPath() + "/FileBoard/write.bo';");
			printWriter.print("</script>");
			
			printWriter.close();
		}
		finally {
			if (printWriter != null) printWriter.close();
		}
	}
	
	private void openBoardContentView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FileBoardVO board = fileBoardService.selectBoard(request);		

		String currentPage = request.getParameter("currentPage");
		String currentBlock = request.getParameter("currentBlock");
		
		request.setAttribute("board", board);
		request.setAttribute("idx", request.getParameter("idx"));
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("currentBlock", currentBlock);
		request.setAttribute("center", "fileBoard/BoardRead.jsp");

		nextPage = "/CarMain.jsp";
	}
	
	private void processFileDownload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fileBoardService.downloadFile(request, response);
	}
}
