package Services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import DAOs.FileBoardDAO;
import VOs.BoardVO;
import VOs.FileBoardVO;

public class FileBoardService {
	
	private FileBoardDAO fileBoardDAO; 

	public FileBoardService() {
	
		fileBoardDAO = new FileBoardDAO();
	}
	
	public ArrayList<FileBoardVO> selectFileBoards() {
		
		return fileBoardDAO.selectFileBoards();
	}
	
	public ArrayList<FileBoardVO> selectSearchedBoards(HttpServletRequest request) {
		
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		
		return fileBoardDAO.selectSearchedBoards(key, word);
	}
}
