package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUp2
 */
@MultipartConfig(location="C:/javaee/workspace/web1127/WebContent/upload2")
@WebServlet("/FileUp4")
public class FileUp4 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//取多個part, 多檔上傳
		Collection <Part> parts = request.getParts();
		for(Part part : parts)
		{
			String head = part.getHeader("Content-Disposition");
			out.print(head + "<br/>");
			String uploadFileName = getFilename(head);
			long size = part.getSize();
			if(size>0){
				part.write(uploadFileName);
			}
		}
		
		

	}
	
	private String getFilename(String body)
	{
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start+10);
		String path = temp.substring(0, temp.indexOf("\""));
		String filename = path.substring(path.lastIndexOf("\\") +1);
		return filename;
	}

}
