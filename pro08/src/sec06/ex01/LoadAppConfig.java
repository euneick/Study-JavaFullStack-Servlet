package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// loadOnStartup 속성으로 우선순위 1로 설정
@WebServlet(name = "loadConfig", urlPatterns = { "/loadConfig" }, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	
	private ServletContext context;

	public void init(ServletConfig config) throws ServletException {

		System.out.println("init 메소드 호출");
		context = config.getServletContext();
		
		// web.xml에서 초기 파라미터 get
		String menuMember = context.getInitParameter("menu_member");
		String menuOrder = context.getInitParameter("menu_order");
		String menuGoods = context.getInitParameter("menu_goods");
		
		// ServletContext에 바인딩 
		context.setAttribute("menu_member", menuMember);
		context.setAttribute("menu_order", menuOrder);
		context.setAttribute("menu_goods", menuGoods);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<html><body>"
				+ "<table border=1 cellspacing=0>"
				+ "<tr>메뉴 이름</tr>"
				+ "<tr><td>" + context.getAttribute("menu_member") + "</td></tr>"				
				+ "<tr><td>" + context.getAttribute("menu_order") + "</td></tr>"				
				+ "<tr><td>" + context.getAttribute("menu_goods") + "</td></tr>"				
				+ "</table>"
				+ "</body></html>");
		
		printWriter.close();
	}

}
