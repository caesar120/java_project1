package index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class managerControl
 */
@WebServlet("/managerControl.do")
public class managerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		String action = request.getParameter("action");
	
		
		if( action==null || action.isEmpty() )
			out.print("잘못된 action입니다.");
		
		
		// 관리자메인
		else if( action.equals("manager") ) {
			response.sendRedirect("./manager/managermain.jsp");
		}
		// 메뉴관리
		else if( action.equals("productManage") ) {
			response.sendRedirect("./product/productManage.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
