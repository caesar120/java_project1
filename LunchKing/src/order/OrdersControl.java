package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import category.Category;


/**
 * Servlet implementation class OrdersControl
 */
@WebServlet("/order/OrdersControl")
public class OrdersControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Orders orders = new Orders();
		try {
			BeanUtils.copyProperties(orders, request.getParameterMap());
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		String action = request.getParameter("action");
		OrdersDAO dao = new OrdersDAO();
		
		
		if ( action.equals("list") ) {	
			ArrayList<Orders> od = dao.getOrders();
			request.setAttribute("od", od);
			request.getRequestDispatcher("ordersList.jsp").forward(request, response);
		} else if (action.equals("insert")) {
			dao.insertOrder(orders);
			response.sendRedirect("OrdersControl?action=list");
		}  else if (action.equals("update")) {
			dao.updateOrder(orders);
			response.sendRedirect("OrdersControl?action=list");
		} else if (action.equals("sel")) {
			/*Orders orders1 = dao.getOrders(orders.getOrderId());
			request.setAttribute("orders", orders1);
			request.getRequestDispatcher("orders_sel.jsp").forward(request, response);*/
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
