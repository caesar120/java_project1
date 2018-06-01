package index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import menutable.MenuDAO;
import menutable.MenuDO;

/**
 * Servlet implementation class mainControl
 */
@WebServlet("/mainControl.do")
public class mainControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainControl() {
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
		
		// 메인페이지로
		else if( action.equals("main") ) {
			
			response.sendRedirect("main.jsp");
		}
		// 식단표
		else if( action.equals("table") ) {
			
			response.sendRedirect("./menutable/tableindex.jsp");
		}
		// 메뉴소개
		else if( action.equals("category") ) {
			
			response.sendRedirect("./product/categoryIntro.jsp");
		}
		// 로그인
		else if( action.equals("login") ) {
			
			response.sendRedirect("./login/login.jsp");
		}
		// 회원가입
		else if( action.equals("userRegist") ) {
			
			response.sendRedirect("./login/userRegister.jsp");
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
