package Services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAOs.BoardDAO;
import DAOs.MemberDAO;
import VOs.BoardVO;
import VOs.MemberVO;

public class BoardService {

	private BoardDAO boardDAO;
	private MemberDAO memberDAO;
	
	public BoardService() {

		boardDAO = new BoardDAO();
		memberDAO = new MemberDAO();
	}
	
	public ArrayList<BoardVO> selectBoards() {
		
		return boardDAO.selectBoards();
	}
	
	public ArrayList<BoardVO> selectSearchedBoards(HttpServletRequest request) {
		
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		
		return boardDAO.selectSearchedBoards(key, word);
	}
	
	public MemberVO selectMember(HttpServletRequest request) {
		
		HttpSession session = request.getSession();		
		String id = (String) session.getAttribute("id");
		
		return memberDAO.selectMember(id);
	}
	
	public int insertBoard(HttpServletRequest request) {

		BoardVO board = new BoardVO();
		
		board.setName(request.getParameter("writer"));
		board.setId(request.getParameter("id"));
		board.setEmail(request.getParameter("email"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setPw(request.getParameter("pass"));		
		
		return boardDAO.insertBoard(board);
	}
	
	public BoardVO selectBoard(HttpServletRequest request) {

		String idx = request.getParameter("idx");
		
		return boardDAO.selectBoard(idx);		
	}
	
	public boolean checkBoardPassword(HttpServletRequest request) {

		String idx = request.getParameter("idx");
		String pass = request.getParameter("pass");
		
		return boardDAO.checkBoardPassword(idx, pass);
	}
	
	public int updateBoard(HttpServletRequest request) {
		
		String idx = request.getParameter("idx");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		
		return boardDAO.updateBoard(idx, email, title, content);
	}
}
