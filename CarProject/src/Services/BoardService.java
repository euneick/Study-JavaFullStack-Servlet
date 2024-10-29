package Services;

import DAOs.BoardDAO;

public class BoardService {

	private BoardDAO boardDAO;
	
	public BoardService() {

		boardDAO = new BoardDAO();
	}
}
