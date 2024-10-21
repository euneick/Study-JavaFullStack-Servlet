package fileDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

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
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String fileRepository = "C:\\ProjectPlace\\JavaFullStack\\fileRepository";
		String fileName = (String) request.getParameter("fileName");
		
		File file = new File(fileRepository + "\\" + fileName);
		
		// 파일의 정보를 읽고 내보낼 출력 스트림 객체
		OutputStream out = response.getOutputStream();
		
		// no-cache로 설정하면 브라우저는 응답받은 결과를 캐싱하지 않음
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");	// 뒤로가기 등을 통해 페이지 이동하는 경우를 대비하여 no-store 추가
		
		/*
			Content-Disposition 속성
		 	 - attachment		모든 확장자에 대해 파일 다운로드 대화 상자가 뜨도록 하는 헤더 속성
		 	 - inline 			브라우저 인식 파일 확장자를 가진 파일들은 브라우저상에서 파일을 바로 열고
		 	 					그 외의 파일은 다운로드 대화 상자가 뜨도록 하는 헤더 속성
		 	 					
			파일명이 깨지는 현상을 방지 Content-Disposition 속성에 fileName 설정
		*/ 
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(fileName, "utf-8") + "\";");
		
		// 다운로드 할 파일을 바이트 단위로 읽어들일 버퍼 통로 생성
		FileInputStream in = new FileInputStream(file);
		
		// 다운로드 할 파일을 8KB 씩 읽어 저장할 버퍼
		byte[] buffer = new byte[1024 * 8];
		
		while (true) {
			int count = in.read(buffer);	// 파일의 내용을 8KB단위로 읽어 변수에 저장
			
			if (count == -1) break;
			
			out.write(buffer, 0, count);
		}
		
		in.close();
		out.close();
	}
}





























