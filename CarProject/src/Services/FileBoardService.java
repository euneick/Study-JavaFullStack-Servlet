package Services;

import java.util.ArrayList;

import DAOs.FileBoardDAO;
import VOs.FileBoardVO;

public class FileBoardService {
	
	private FileBoardDAO fileBoardDAO; 

	public FileBoardService() {
	
		fileBoardDAO = new FileBoardDAO();
	}
	
	public ArrayList<FileBoardVO> selectFileBoards() {
		
		return fileBoardDAO.selectFileBoards();
	}
}
