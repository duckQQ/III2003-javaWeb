package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

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
@MultipartConfig
@WebServlet("/FileUp2")
public class FileUp2 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("upload");
		
		String head = part.getHeader("Content-Disposition");
		out.print(head + "<br/>");
		String uploadFileName = getFilename(head);
		String type = part.getContentType();
		String filename = part.getSubmittedFileName();
		long size = part.getSize();
		
		out.println("type:" + type + "<br/>"+ ":" +filename +":" +size);
		
		byte buf[] = new byte[(int)size];
		BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
		bin.read(buf);
		bin.close();
		
		ServletContext context = getServletContext();
		String uploadPath = context.getInitParameter("upload-path");
		out.println(uploadPath);
		
		FileOutputStream fout = new FileOutputStream(new File(uploadPath,uploadFileName));
		fout.write(buf);
		fout.flush();
		fout.close();
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
