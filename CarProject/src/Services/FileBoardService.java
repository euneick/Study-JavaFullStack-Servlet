package Services;

import DAOs.FileBoardDAO;

public class FileBoardService {
	
	private FileBoardDAO fileBoardDAO; 

	public FileBoardService() {
	
		fileBoardDAO = new FileBoardDAO();
	}
}
