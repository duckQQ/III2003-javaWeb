package tw.org.iii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUp
 */
@WebServlet("/FileUp")
public class FileUp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		request.getParameter("user");
		String type = request.getContentType();
		int len = request.getContentLength();
		out.print(type +": "+ len+ "<br>");
		
//		BufferedReader br = request.getReader();
//		String line; int i = 1;
//		while( (line = br.readLine()) != null)
//		{
//			out.print(i++ +"> "+ line + "<br>");
//		}
//		br.close();
		
		InputStream in = request.getInputStream();
		byte[] buf = new byte[len];
		in.read(buf);
		in.close();
		
		String cont = new String(buf);
		//out.println(cont);
		out.print(getFilename(cont));			
	}
	//讀檔名方法
	private String getFilename(String body)
	{
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start+10);
		String path = temp.substring(0, temp.indexOf("\""));
		String filename = path.substring(path.lastIndexOf("\\") +1);
		return filename;
	}

}
