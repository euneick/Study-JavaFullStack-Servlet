package API;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NaverSearchAPI.do")
public class SearchAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 인증정보 설정*/
		String clientId = "kx8sREeigxnmZSoSZfkp";
		String clientSecret = "yGhFctOkbk";
		
		/* 검색 조건 설정 */
		int startNum = 0;		// 검색 시작 위치
		String text = null;		// 입력한 검색어
        try {
        	startNum = Integer.parseInt(request.getParameter("startNum"));
        	
        	String searchText = request.getParameter("keyword");
        	
			text = URLEncoder.encode(searchText, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
        }
        
        /* API 요청 주소 조합 */
        // display - 한번에 가져올 검색 결과의 수
        // start - 검색 시작 위치
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text
        		+ "&display=10&start=" + startNum;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과

        /* API 설정 */
		Map<String, String> requestHeaders = new HashMap<>();

		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);

		/* API를 호출하여  JSON을 문자열 형태로 반환 */
		String responseBody = get(apiURL, requestHeaders);
		
		System.out.println(responseBody);
	}
	
	private String get(String apiUrl, Map<String, String> requestHeaders) {

		HttpURLConnection con = connect(apiUrl);
		
		try {
			con.setRequestMethod("GET");
			
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			}
			else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		}
		catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		}
		finally {
			con.disconnect();
		}
	}

	private HttpURLConnection connect(String apiUrl) {

		try {
			URL url = new URL(apiUrl);
			
			return (HttpURLConnection) url.openConnection();
		}
		catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		}
		catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private String readBody(InputStream body) {

		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		}
		catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}
}
