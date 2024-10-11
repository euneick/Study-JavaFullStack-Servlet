package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ServletContext context = getServletContext();
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<html><body>"
				+ "<table corder=1 cellspacing=0>"
				+ "<tr>메뉴 이름</tr>"
				+ "<tr><td>"+ context.getInitParameter("menu_member") +"</td></tr>"
				+ "<tr><td>"+ context.getInitParameter("menu_order") +"</td></tr>"
				+ "<tr><td>"+ context.getInitParameter("menu_goods") +"</td></tr>"
				+ "</body></html>");
		
		printWriter.close();
	}

}
