package API;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet("/stock.do")
public class NaverStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "https://finance.naver.com/item/main.naver?code=005930";
		
		Document document;
		
		try {
			document = Jsoup.connect(url).get();			
			//System.out.println(document);
			
			Elements elements = document.select(".date");
			System.out.println(elements);
			System.out.println();

			System.out.println(elements.text());
			System.out.println();
			String[] texts = elements.text().split(" ");
			for (int i = 0; i < texts.length; i++) {
				System.out.println(texts[i]);
			}
			System.out.println();
			
			Elements totayList = document.select(".new_totalinfo dl>dd");
			System.out.println(totayList);
			System.out.println();
		
			String stockPrice = totayList.get(3).text().split(" ")[1];
			System.out.println("주가 : " + stockPrice);
			
			String fluctuationRate = totayList.get(3).text().split(" ")[6];
			System.out.println("등락율 : " + fluctuationRate);
			
			String marketPrice = totayList.get(5).text().split(" ")[1];
			System.out.println("시가 : " + marketPrice);
			
			String highPrice = totayList.get(6).text().split(" ")[1];
			System.out.println("고가 : " + highPrice);
			
			String lowPrice = totayList.get(8).text().split(" ")[1];
			System.out.println("저가 : " + lowPrice);
			
			String tradingVolume = totayList.get(10).text().split(" ")[1];
			System.out.println("거래량 : " + tradingVolume);
			
			String comparedPrevDay = totayList.get(3).text().split(" ")[3];
			System.out.println("전일대비 : " + comparedPrevDay);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
