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

@WebServlet("/cget")
public class GetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		ServletContext context = getServletContext();
		ArrayList<Object> member = (ArrayList<Object>)context.getAttribute("member");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html><body>"
				+ member.get(0) + "<br>"
				+ member.get(1) + "<br>"
				+ "</body></html>");
		
		printWriter.close();
	}

}
