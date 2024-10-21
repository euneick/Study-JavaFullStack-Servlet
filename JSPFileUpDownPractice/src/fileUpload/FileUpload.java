package fileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 	파일업로드 기능을 처리하는 서블릿
 * 
 * 	라이브러리 파일에서 제공하는 DiskFileItemFactory 클래스를 이용
 * 		- 저장 위치와 업로드 가능한 최대 파일의 크기를 설정
 * 	
 * 	라이브러리 파일에서 제공하는 ServletFileUpload 클래스를 이용
 * 		- 파일 업로드 창에서 업로드된 파일과 매개변수에 대한 정보를 가져와 파일을 업로드하고 매개변수 값을 출력
 */

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String encoding = "utf-8";
		
		request.setCharacterEncoding(encoding);
		
		File currentDirectoryPath = new File("C:\\ProjectPlace\\JavaFullStack\\fileRepository");
		
		// 업로드 할 파일 데이터를 임시로 저장 할 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(1024 * 1024 * 1);		// 파일 업로드 시 사용 할 임시 메모리 최대 크기 1MB로 지정
		factory.setRepository(currentDirectoryPath);	// 임시 메모리에 파일 업로드 시 지정한 크기를 넘길 경우 업로드할 파일 경로
		
		// 파일 업로드를 실제로 처리 할 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// request 객체에 파라미터로 전달 받은 정보들을 리스트로 변환
			List<FileItem> items = upload.parseRequest(request);
			
			for (FileItem fileItem : items) {
				
				// fileItem 객체가 파일 아이템이 아닐 경우
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encoding));
				}
				// fileItem 객체가 파일 아이템일 경우
				else {
					System.out.println("파라미터 : " + fileItem.getFieldName());
					System.out.println("파일이름 : " + fileItem.getName());
					System.out.println("파일크기 : " + fileItem.getSize() + "Bytes");
					
					// 파일크기가 0보다 크다 = 업로드할 파일이 존재한다
					if (fileItem.getSize() > 0) {
						int index = fileItem.getName().lastIndexOf("\\");
						
						System.out.println("index : " + index);
						// 파일 명에 \ 가 포함되어 있지 않다면?
						if (index == -1) {
							index = fileItem.getName().lastIndexOf("/");
							System.out.println("index 2nd : " + index);
						}
						
						String fileName = fileItem.getName().substring(index + 1);
						
						File uploadFile = new File(currentDirectoryPath + "\\" + fileName);
						
						// 실제 파일 업로드
						fileItem.write(uploadFile);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}





























