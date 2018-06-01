package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login/LoginControl.do")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 파라미터 -> DO 객체
		LoginBean login = new LoginBean();
		try {
			BeanUtils.copyProperties(login, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

		LoginDAO dao = new LoginDAO();
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			out.print("잘못된 명령입니다.");
		} else if (action.equals("insForm")) { // 등록폼
			response.sendRedirect("userRegister.jsp");
		} else if (action.equals("ins")) { // 등록처리
			request.getSession().setAttribute("login", request.getParameter("userId"));
			dao.registerUser(login);
			response.sendRedirect("loginConfirm.jsp");
		} else if (action.equals("selUser")) { // 비번 없을 때 아이디 조회
			// 단건조회
			LoginBean result = dao.selUser(login.getEmail(), login.getUserName());
			// 수정폼으로
			request.setAttribute("login", result);
			request.getRequestDispatcher("loginUpdateForm.jsp").forward(request, response);
		} else if (action.equals("updForm")) { // 수정폼
			// 단건조회
			LoginBean result = dao.forModifyselUser((String) request.getSession().getAttribute("login"));
			request.setAttribute("login", result);
			request.getRequestDispatcher("loginUpdateForm.jsp").forward(request, response);
		}
		// 수정처리
		else if (action.equals("upd")) {
			dao.updateUser(login);
			System.out.println(login.toString());
			response.sendRedirect("updateConfirm.jsp");
		}
		// 삭제처리
		else if (action.equals("del")) {
			dao.deleteUser((String) request.getSession().getAttribute("login"));
			response.sendRedirect("userDel.jsp");
		}
		// 단건조회
		else if (action.equals("sel")) {
			// 단건조회
			LoginBean result = dao.forModifyselUser((String) request.getSession().getAttribute("login"));
			// 상세보기폼으로
			System.out.println(login.toString());
			request.setAttribute("login", result);
			request.getRequestDispatcher("userMypage.jsp").forward(request, response);
		} else if (action.equals("list")) { // 전체처리
			ArrayList<LoginBean> datas = dao.userList();
			request.setAttribute("datas", datas);
			request.getRequestDispatcher("userList.jsp").forward(request, response);
		}
		// 로그인 체크
		else if (action.equals("check")) {
			System.out.println(login.getUserId());
			int result = dao.loginCheck(login);

			if (result == 1) {// 로그인
				// 세션에 로그인 정보를 저장
				request.getSession().setAttribute("login", request.getParameter("userId"));
				response.sendRedirect("loginConfirm.jsp");
			} else if (result == 0) { // 아이디가 없는 경우
				out.print("<html><script>");
				out.print("alert('없는 아이디입니다.');");
				out.print("history.back();");
				out.print("</script><body></body></html>");

			} else if (result == -1) { // 패스워드가 틀린 경우
				out.print("<html><script>");
				out.print("alert('패스워가 틀림.'); ");
				out.print("history.back();");
				out.print("</script><body></body></html>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}