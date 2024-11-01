package Services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import DAOs.FileBoardDAO;
import DAOs.MemberDAO;
import VOs.BoardVO;
import VOs.FileBoardVO;
import VOs.MemberVO;

public class FileBoardService {
	
	private static final String REPOSITORY_PATH = "C:\\ProjectPlace\\JavaFullStack\\fileRepository";
	
	private FileBoardDAO fileBoardDAO;
	private MemberDAO memberDAO;

	public FileBoardService() {
	
		fileBoardDAO = new FileBoardDAO();
		memberDAO = new MemberDAO();
	}
	
	public ArrayList<FileBoardVO> selectFileBoards() {
		
		return fileBoardDAO.selectFileBoards();
	}
	
	public ArrayList<FileBoardVO> selectSearchedBoards(HttpServletRequest request) {
		
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		
		return fileBoardDAO.selectSearchedBoards(key, word);
	}
	
	public MemberVO selectMember(HttpServletRequest request) {
		
		HttpSession session = request.getSession();		
		String id = (String) session.getAttribute("id");
		
		return memberDAO.selectMember(id);
	}
	
	public synchronized int getInsertedBoardIdx(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, String> articleMap = uploadFile(request, response);
		
		FileBoardVO board = new FileBoardVO();

		board.setName(articleMap.get("writer"));
		board.setId(articleMap.get("writer_id"));
		board.setEmail(articleMap.get("email"));
		board.setTitle(articleMap.get("title"));
		board.setContent(articleMap.get("content"));
		board.setPw(articleMap.get("pass"));
		
		String sfile = articleMap.get("fileName");
		board.setSfile(sfile);
		
		int articleNO = fileBoardDAO.getInsertedBoardIdx(board);
		
		
		synchronized (this) {
			if (sfile != null && sfile.length() != 0) {
				File srcFile = new File(REPOSITORY_PATH + "\\temp\\" + sfile);
				File destDir = new File(REPOSITORY_PATH + "\\" + articleNO);
				
				if (!destDir.exists())
					destDir.mkdirs();
				
				FileUtils.moveToDirectory(srcFile, destDir, true);
			}
		}
		
		return articleNO;
	}

	private synchronized Map<String, String> uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String> articleMap = new HashMap<String, String>();

		File repository = new File(REPOSITORY_PATH);
		
		// 업로드 할 파일 데이터를 임시로 저장 할 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(1024 * 1024 * 1);		// 파일 업로드 시 사용 할 임시 메모리 최대 크기 1MB로 지정
		factory.setRepository(repository);				// 임시 메모리에 파일 업로드 시 지정한 크기를 넘길 경우 업로드할 파일 경로

		// 파일 업로드를 실제로 처리 할 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// request 객체에 파라미터로 전달 받은 정보들을 리스트로 변환
			List<FileItem> items = upload.parseRequest(request);
			
			for (FileItem fileItem : items) {				
				// fileItem 객체가 파일 아이템일 경우
				// 파일크기가 0보다 크다 = 업로드할 파일이 존재한다
				if (!fileItem.isFormField() && fileItem.getSize() > 0) {
					int index = fileItem.getName().lastIndexOf("\\");
					
					// 파일 명에 \ 가 포함되어 있지 않다면?
					if (index == -1) {
						index = fileItem.getName().lastIndexOf("/");
					}
					
					String fileName = fileItem.getName().substring(index + 1);
					
					File uploadFile = new File(repository + "\\temp\\" + fileName);
					
					synchronized (this) {
						articleMap.put(fileItem.getFieldName(), fileName);
						
						fileItem.write(uploadFile);			// 실제 파일 업로드						
					}
				}
				else {
					articleMap.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleMap;
	}
	
	public FileBoardVO selectBoard(HttpServletRequest request) {

		String idx = request.getParameter("idx");
		
		return fileBoardDAO.selectBoard(idx);		
	}
}
