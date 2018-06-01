package product;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class ProductControl
 */
@WebServlet("/product/ProductControl.do")
@MultipartConfig(
		maxFileSize=1024*1024*10,
		maxRequestSize=1024*1024*20
	)
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Product product = new Product();
		
		try {
			BeanUtils.copyProperties(product, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String action = request.getParameter("action");
		ProductDAO dao = new ProductDAO();
		
		if( action==null || action.isEmpty() )
			out.print("잘못된 action입니다.");
		
		// 카테고리 등록처리 후 목록으로
		else if( action.equals("ins") ) {
			
		}
		
		// 카테고리 수정처리 후 목록으로
		else if( action.equals("upd") ) {
			
		}
		
		// 카테고리 삭제 후 목록으로
		else if ( action.equals("del") ) {
			
		}
		
		// 특정 카테고리 조회
		else if ( action.equals("sel") ) {
			
		}
		
		/*
		// 카테고리 전체 조회
		else if ( action.equals("list") ) {
			ArrayList<Product> datas = dao.getProductList();
			request.setAttribute("productList", datas);
			request.getRequestDispatcher("productManage.jsp").forward(request, response);
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private Product imageUpload(HttpServletRequest request) throws ServletException, IOException {
		String contentType = request.getContentType();
		Product category = new Product();
		
		System.out.println("content: " + contentType);
		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			Collection<Part> parts = request.getParts();
			for (Part part : parts) {
				
				String partName = part.getName();
				System.out.println("Parameter Name : " + partName);
				String partContentType = part.getContentType();
				System.out.println("ContentType : " + partContentType);
				
				// 첨부파일 조건
				if (partContentType != null ) {
					long size = part.getSize();
					String fileName = getFileName(part);	// 실제 업로드한 파일명
					String uploadFileName = request.getParameter("") + "_" + fileName; // 서버에서 저장되는 파일명
					if (size > 0) {
						String path = request.getServletContext().getRealPath("/uploadedImg");
						String fullFileName = path + "/" + uploadFileName;
						File file = new File(fullFileName);
						// 기존 파일이 존재할 시 삭제
						if(file.exists()) {
							file.delete();
						}
						part.write(fullFileName);
						part.delete();
						
					}
				} else {	// 텍스트 필드
					String value = readParameterValue(part);
					if( partName.equals("categoryId") ) {
						
					} else if( partName.equals("categoryName") ) {
					
					} else if( partName.equals("price") ) {
						
					}
				}	// end of else
			}	// end of For(Part part ~)
			
		} else { // if ( multipart )
			System.out.println("else 넘어옴");
		}
		
		return category;
	}
	
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
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
