package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class OrdersDetailControl
 */
@WebServlet("/order/OrdersDetailControl")
public class OrdersDetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersDetailControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		OrdersDetail orders = new OrdersDetail();
		try {
			BeanUtils.copyProperties(orders, request.getParameterMap());
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		String action = request.getParameter("action");
		OrdersDetailDAO dao = new OrdersDetailDAO();
		
		
		if ( action.equals("list") ) {	
			ArrayList<Map<String,Object>> od = dao.getOrdersDetailList();
			request.setAttribute("od", od);
			request.getRequestDispatcher("ordersDetailList.jsp").forward(request, response);
		} else if (action.equals("insert")){
			dao.insertOrderDetail(orders);
			response.sendRedirect("OrdersDetailControl?action=list");
		} else if (action.equals("delete")){
			
		} else if (action.equals("update")){
			
		} else if (action.equals("sel")){
			//단건조회
			OrdersDetail result = dao.getOrderDetail(request.getParameter("no"));
			System.out.println("======================");
			//상세보기폼으로
			request.setAttribute("orders", result);
			request.getRequestDispatcher("orders_sel.jsp").forward(request, response);
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
