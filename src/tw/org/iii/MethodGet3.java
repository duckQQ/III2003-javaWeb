package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.util.converter.IntegerStringConverter;

/**
 * Servlet implementation class MethodGet
 */
@WebServlet("/MethodGet3")
public class MethodGet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x, y,result ,op; 
		String i = "";
		try{
			x = Integer.parseInt(request.getParameter("x"));
			op = Integer.parseInt(request.getParameter("op"));
			y = Integer.parseInt(request.getParameter("y"));
		}catch(Exception e){
			x = 0;
			y = 0;
			op = 1;
		}
		switch(op){
		default:
			case 1 : result = x + y; break;
			case 2: result = x - y; break;
			case 3: result = x * y;break;
			case 4: 
			{
				result = x / y; 
				String resu = String.valueOf(result);
				int j = x%y;
				if(j!=0){
					 resu = i+ "......" + j;
				}
			break;}
			
		}
		//output
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form>");
		out.write("<input type='text' name='x' value='" +x+ "'/> ");
		out.write("<select name='op'>");
		out.write("<option value='1'"+ (op == 1?"selected":"")+"> + </option>");
		out.write("<option value='2'"+ (op == 2?"selected":"")+"> - </option>");
		out.write("<option value='3'"+ (op == 3?"selected":"")+"> x </option>");
		out.write("<option value='4'"+ (op == 4?"selected":"")+"> / </option>");
		out.write("</select>");
		out.write("<input type='text' name='y' value='" +y+ "' /> ");
		out.write("<input type='submit' value='='> ");
		out.write("<span>"+result+"<span>");
		
		out.write("</form>");
	}


}
