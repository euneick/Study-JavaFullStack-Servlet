package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *	Servlet
 *		- 클라이언트의 요청 주소를 받아 처리하는 서버페이지 역할을 하는 자바 클래스
 *
 * 
 *	Servlet 인터페이스
 *		- 모든 서블릿 클래스가 구현해야하는 최상위 인터페이스
 *		- 서블릿의 생명주기를 관리하는 기본 메소드들이 포함되어있음
 *		  init(), service(), destroy(), getServletConfig(), getServletInfo() 등
 *	
 *	GenericServlet 클래스
 *		- Servlet 인터페이스를 구현한 추상클래스
 *		- 프로토콜에 독립적인 서블릿을 만들 때 사용
 *		- service() 메소드만 추상메소드로 남겨두며, 나머지 메소드는 기본구현을 제공
 *		- 보통 이 클래스를 사용하여 서블릿을 구현하지는 않음
 *
 *	HttpServlet 클래스
 *		- GenericServlet 클래스를 확장한 클래스
 *		- http 프로토콜을 기반으로 동작하는 서블릿을 만들기 위해 사용
 *		- http 요청에 따라 doGet(), doPost(), doPut(), doDelete() 등 메소드를 제공
 *		     클라이언트의 http요청 방식에 따라 처리 할 수 있음
 *		- 웹 애플리케이션에서 가장 많이 사용되는 서블릿 클래스
 *
 *	계층구조 요약
 *		Servlet (인터페이스)
 *			└ GenericServlet (추상클래스)
 *				└ HttpServlet (일반 클래스)
 */

public class FirstServlet extends HttpServlet {

	/*
	 * 호출 순서
	 * 	1. init()
	 * 		페이지 요청 시 한 번만 호출
	 * 
	 * 	2. service(ServletRequest req, ServletResponse res)
	 * 		요청을 받을 때마다 호출
	 * 		해당 메소드를 통해 http 요청 방식(get, post)를 처리
	 * 		doGet(), doPost() 같은 특정 메소드가 호출 시 처리
	 * 		 * req - 클라이언트로 부터 들어온 요청
	 * 		 * res - 페이지의 응답
	 * 	
	 * 	3. doGet(HttpServletRequest req, HttpServletResponse resp)
	 * 		전송방식이 Get 일 때 호출
	 * 		클라이언트가 요청한 데이터를 기반으로 응답할 데이터를 구현하는 메소드
	 * 
	 *  ...
	 *  
	 *  마지막. destroy()
	 *		페이지가 서버 메모리에서 소멸 될 때 한 번만 호출
	 *		서블릿이 사용 했던 각종 리소스, 스트림들을 메모리 해제 할 때 주로 사용
	 *
	 *	※ init(), destroy() 메소드 등은 생략 가능하나 doGet() 또는 doPost() 메소드는 반드시 구현해야 함 
	 */
	
	@Override
	public void init() throws ServletException {

		System.out.println("init 메소드 호출");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("doGet 메소드 호출");
	}
	
	@Override
	public void destroy() {
	
		System.out.println("destroy 메소드 호출");
	}
}
