package sec05.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initFile")
public class ContextFileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		ServletContext context = getServletContext();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(context.getResourceAsStream("/WEB-INF/bin/init.txt")));

		String menu = null;
		String menuMember = null;
		String menuOrder = null;
		String menuGoods = null;

		while ((menu = bufferedReader.readLine()) != null) {

			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menuMember = tokens.nextToken();
			menuOrder = tokens.nextToken();
			menuGoods = tokens.nextToken();
		}
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<html><body>"
				+ menuMember + "<br>"
				+ menuOrder + "<br>"
				+ menuGoods + "<br>"
				+ "</body></html>");
		
		printWriter.close();
	}

}
