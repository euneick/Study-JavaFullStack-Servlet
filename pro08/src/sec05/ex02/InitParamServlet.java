package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	urlPatterns			웹 브라우저에서 서블릿 요청 시 사용하는 매핑 이름
 * 	name				서블릿 이름
 * 	loadOnStartup		컨테이너 실행 시 서블릿이 로드되는 순서 지정
 * 	initParams			@WebInitParam 어노테이션을 이용해 매개변수를 추가하는 기능
 * 	description			서블릿에 대한 설명
 */
@WebServlet(
		urlPatterns = { 
				"/sInit1", 
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")
		})
public class InitParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<html><body>"
				+ "<table>"
				+ "<tr>"
				+ "<td>email</td>"
				+ "<td>" + getInitParameter("email") + "</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>tel</td>"
				+ "<td>" + getInitParameter("tel") + "</td>"
				+ "</tr>"
				+ "</table>"
				+ "</body></html>");
		
		printWriter.close();
	}

}
