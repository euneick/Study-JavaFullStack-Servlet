package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		Enumeration env = request.getParameterNames();
		while (env.hasMoreElements()) {

			String name = (String) env.nextElement();
			String[] values = request.getParameterValues(name);

			for (String value : values)
				System.out.printf("name : %s \t value : %s\n", name, value);
		}
	}

}
