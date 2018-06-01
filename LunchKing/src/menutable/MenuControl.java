package menutable;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class CategoryControl
 */
@WebServlet("/menutable/MenuControl.do")
public class MenuControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MenuDO menu = new MenuDO();
		
		/*category.setCategoryId(request.getParameter("categoryId"));
		category.setCategoryName(request.getParameter("categoryName"));
		category.setCategoryPrice(request.getParameter("categoryPrice"));
		category.setCategoryImage(request.getParameter("categoryImage"));*/
		
		try {
			BeanUtils.copyProperties(menu, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String action = request.getParameter("action");
		MenuDAO dao = new MenuDAO();
		
		if( action==null || action.isEmpty() )
			out.print("잘못된 action입니다.");
		
		// 카테고리 등록처리 후 목록으로
		else if( action.equals("ins") ) {
			dao.insertMenu(menu);
			out.println(menu);
			response.sendRedirect("MenuControl.do?action=list");
		}
		
		// 카테고리 수정처리 후 목록으로
		else if( action.equals("upd") ) {
			dao.updateMenu(menu);
			response.sendRedirect("MenuControl.do?action=list");
		}
		
		// 카테고리 삭제 후 목록으로
		else if ( action.equals("del") ) {
			response.sendRedirect("MenuControl.do?action=list");
		}
		
		// 특정 카테고리 조회
		else if ( action.equals("list") ) {
			menu.setMenuMonth("201705");
			ArrayList<Map<String,String>> result = dao.selectMenu(menu);
			request.setAttribute("menu", result);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		}
		
		// 카테고리 전체 조회
/*		else if ( action.equals("list") ) {
			ArrayList<MenuDO> datas = dao.getCategoryList();
			request.setAttribute("categoryList", datas);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
