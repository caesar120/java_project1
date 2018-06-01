package category;

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
 * Servlet implementation class CategoryControl
 */
@WebServlet("/product/CategoryControl.do")
@MultipartConfig(
	maxFileSize=1024*1024*10,
	maxRequestSize=1024*1024*20
)
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Category category = new Category();
		
		/*category.setCategoryId(request.getParameter("categoryId"));
		category.setCategoryName(request.getParameter("categoryName"));
		category.setCategoryPrice(request.getParameter("categoryPrice"));
		category.setCategoryImage(request.getParameter("categoryImage"));*/
		
		try {
			BeanUtils.copyProperties(category, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String action = request.getParameter("action");
		CategoryDAO dao = new CategoryDAO();
		
		if( action==null || action.isEmpty() )
			out.print("잘못된 action입니다.");
		
		// 카테고리 등록처리 후 목록으로
		else if( action.equals("ins") ) {
			dao.addCategory(imageUpload(request));
			response.sendRedirect("CategoryControl.do?action=list");
		}
		
		// 카테고리 수정처리 후 목록으로
		else if( action.equals("upd") ) {
			dao.updateCategory(imageUpload(request));
			response.sendRedirect("CategoryControl.do?action=list");
		}
		
		// 카테고리 삭제 후 목록으로
		else if ( action.equals("del") ) {
			dao.deleteCategory(category.getCategoryId());
			out.write("alert(" + category.getCategoryId() + "카테고리가 삭제되었습니다." + ");");
			response.sendRedirect("CategoryControl.do?action=list");
		}
		
		// 특정 카테고리 조회
		else if ( action.equals("sel") ) {
			Category result = dao.getCategory(category.getCategoryId());
			request.setAttribute("category", result);
			request.getRequestDispatcher("categorySel.jsp").forward(request, response);
		}
		
		// 카테고리 전체 조회
		else if ( action.equals("list") ) {
			ArrayList<Category> datas = dao.getCategoryList();
			request.setAttribute("categoryList", datas);
			request.getRequestDispatcher("productManage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public Category imageUpload(HttpServletRequest request) throws ServletException, IOException {
		String contentType = request.getContentType();
		Category category = new Category();
		
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
					String uploadFileName = request.getParameter("categoryId") + "_" + fileName; // 서버에서 저장되는 파일명
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
						category.setCategoryImage(uploadFileName);
					}
				} else {	// 텍스트 필드
					String value = readParameterValue(part);
					if( partName.equals("categoryId") ) {
						category.setCategoryId(value);
					} else if( partName.equals("categoryName") ) {
						category.setCategoryName(value);
					} else if( partName.equals("price") ) {
						category.setPrice(value);
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
