package board;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload/FileUploadServlet.do")
@MultipartConfig(
	location="c:/Temp",
	maxFileSize=1024000L,
	maxRequestSize=-1,
	fileSizeThreshold=-1)

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardBean board = new BoardBean();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String contentType = request.getContentType();
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			
			Collection<Part> parts = request.getParts();
			for (Part part : parts) {
			String partName = part.getName();
			out.println("parameter name: "+ partName +" :");
			
			String partContentType = part.getContentType();
			out.println("Content type : "+ partContentType +"<br>");
			
			if (partContentType != null ) { //첨부파일
			long size = part.getSize();
			String fileName = getFileName(part); // 업로드한 파일명
			String uploadfilename = System.currentTimeMillis() + ""; // 서버에 저장된
			out.println(fileName+ ","+ size+"<br>");
			if (size > 0) {
			part.write("d:/upload/" + uploadfilename);
			part.delete();
			
			board.setOriginalfileName(fileName);
			board.setUploadedfileName(uploadfilename);
			}
		} else { // 텍스트 필드
			String value = readParameterValue(part);
			out.println(value+"<br>");
			if( partName.equals("title") ) {
			board.setTitle(value);
			} else if( partName.equals("contents") ) {
				board.setContents(value);
				}
			else if( partName.equals("username") ) {
			board.setUserid(value);
			}
		 } 	
	  } 
		dao.insertDB(board); // db에 insert
} // multipart check
		
}//end of do get
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
		if (cd.trim().startsWith("filename")) {
		return cd.substring(cd.indexOf('=') + 1).trim()
		.replace("\"", "");
		}
		}
		return null;
		}
	
		private String readParameterValue(Part part) throws IOException {
		InputStreamReader reader = new InputStreamReader(part.getInputStream(), "utf-8");
		char[] data = new char[512];
		int len = -1;
		StringBuilder builder = new StringBuilder();
		while ((len = reader.read(data)) != -1) {
		builder.append(data, 0, len);
		}
		return builder.toString();
		}
}
