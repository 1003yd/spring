package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//구구단 출력 custom view
//spring customview를 만들기 위해서는 View Interface를 구현할 필요가 있음
public class TimesTablesView implements View {

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		int table = Integer.parseInt(request.getParameter("table"));
		

		PrintWriter pw = response.getWriter();	// => consle 창이 아닌 web browser에 띄울때  사용한다.
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset= \"UTF-8\">");
		pw.print("			<title> insert title here </title>");
		pw.print("		<head>");
		pw.print("		<body>");
		pw.print("<table border= 1>");
		int i = 1;
		while(i < table){
			pw.print("<tr>");
			for(int dan = 2; dan < 10 ; dan ++ ){
				int gugudan = dan * i;
				String result = dan + "*" + i + "=" + gugudan;
				pw.print("<td>" + result + "</td>" );
			}			
			pw.print("</tr>");
			i++;
		}
		pw.print("</table>");
		pw.print("		</body>");
		pw.print("	</html>");
		
	}

}
