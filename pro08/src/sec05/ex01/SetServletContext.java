package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	ServletContext
 *	 - 현재 프로젝트에서 공유되는 데이터를 저장하고, 모든 서버페이지에서 공유하는 객체
 */
@WebServlet("/cset")
public class SetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ArrayList<Object> member = new ArrayList<Object>();
		member.add("이순신");
		member.add(30);

		ServletContext context = getServletContext();		// 톰캣 서버가 생성한 ServletContext 객체의 주소를 저장
		context.setAttribute("member", member);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html><body>"
				+ "이순신과 30 설정"
				+ "</body></html>");
		
		printWriter.close();
	}

}
