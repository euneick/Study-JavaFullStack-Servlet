package Services;

import java.util.ArrayList;

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
}
