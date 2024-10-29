package Services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import DAOs.BoardDAO;
import DAOs.MemberDAO;
import VOs.BoardVO;

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
}
