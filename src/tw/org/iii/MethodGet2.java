package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MethodGet
 */
@WebServlet("/MethodGet2")
public class MethodGet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int x=0, y=0, result;
//		try{
//			x = Integer.parseInt(request.getParameter("x"));
//			y = Integer.parseInt(request.getParameter("y"));
//		}catch(Exception e){
//			x = 0;
//			y = 0;
//		}
//		result = x + y;
//		
		response.setContentType("text/html; chareset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form>");
		out.write("<input type='text' name='x' value='" +x+ "'/> ");
		out.write("<option> + </option>");
		out.write("<option> - </option>");
		out.write("<option> x </option>");
		out.write("<option> / </option>");
		out.write("<input type='text' name='y' value='" +y+ "' /> ");
		out.write("<input type='submit' value='='> ");
		out.write("<span><span>");
		out.write("</form>");
	}


}
