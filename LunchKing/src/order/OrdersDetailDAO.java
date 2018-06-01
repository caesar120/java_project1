/**
 * 파일명 : OrdersDetailDAO.java
 * 작성일 : 2017. 4. 28.
 * 파일설명 : 	
 */
package order;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.DBManager;

/**
 * @author User
 *
 */
public class OrdersDetailDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	// 신규상세 주문 추가
	public boolean insertOrderDetail(OrdersDetail ordersDetailDO) {
		conn = DBManager.getConnection();
		// sql 문자열

		String sql = "insert into orders_detail " 
				+ " (detail_id, order_id, category_id, ship_startdate, ship_enddate, ship_state, order_term, order_count, "
				+ " pause_start_date, pause_cancel_date, pause_request_date) "
				+ " values (?,?,?,?,?,?,?,?,?,?,?) ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ordersDetailDO.getDetailId());
			pstmt.setString(2, ordersDetailDO.getOrderId());
			pstmt.setString(3, ordersDetailDO.getCategoryId());
			pstmt.setString(4, ordersDetailDO.getShipStartDate());
			pstmt.setString(5, ordersDetailDO.getShipEndDate());
			pstmt.setString(6, ordersDetailDO.getShipState());
			pstmt.setString(7, ordersDetailDO.getOrderTerm());
			pstmt.setString(8, ordersDetailDO.getOrderCount());
			pstmt.setString(9, ordersDetailDO.getPauseStartDate());
			pstmt.setString(10, ordersDetailDO.getPauseCancelDate());
			pstmt.setString(11, ordersDetailDO.getPauseRequestDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 주문 삭제
	public boolean DeleteOrderDetail(OrdersDetail orders) {
		conn = DBManager.getConnection();
		// sql 문자열

		String sql = "Delete from orders_detail where order_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orders.getOrderId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 주문 전체 조회
	public ArrayList<Map<String, Object>> getOrdersDetailList() {
		ArrayList<Map<String, Object>> od = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = null;
		conn = DBManager.getConnection();
		
		String sql = "SELECT DETAIL_ID, o.ORDER_ID,  CATEGORY_ID, "
				+ " SHIP_STARTDATE, ORDER_TERM,  SHIP_ENDDATE, "
				+ " SHIP_STATE,  ORDER_COUNT,  PAUSE_START_DATE, "
				+ " PAUSE_REQUEST_DATE,  PAUSE_CANCel_DATE, "
				+ " order_addr FROM ORDERS_DETAIL od, ORDERS o "
				+ " where o.ORDER_ID = od.ORDER_ID order by detail_id";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("detailId", rs.getString("detail_id"));
				map.put("orderId", rs.getString("order_id"));
				map.put("categotyId", rs.getString("category_id"));
				map.put("orderCount", rs.getString("order_count"));
				map.put("orderTerm", rs.getString("order_term"));
				map.put("pauseCancelDate", rs.getString("pause_cancel_date"));
				map.put("pauseRequestDate", rs.getString("pause_request_date"));
				map.put("pauseStartDate", rs.getString("pause_start_date"));
				map.put("shipEndDate", rs.getString("ship_enddate"));
				map.put("shipStartDate", rs.getString("ship_startdate"));
				map.put("shipState", rs.getString("ship_state"));
				map.put("orderAddr", rs.getString("order_addr"));
				od.add(map);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return od;
	}
	//  detail_id 로 상세조회
		public ArrayList<Map<String, Object>> getOrderDetail(String detail_id) {
			ArrayList<Map<String, Object>> od = new ArrayList<Map<String, Object>>();
			HashMap<String, Object> map = null;
			conn = DBManager.getConnection();
			
			String sql = "select * from orders_detail where detail_id = ? ";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, detail_id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					map = new HashMap<String, Object>();
					map.put("detailId", rs.getString("detail_id"));
					map.put("orderId", rs.getString("order_id"));
					map.put("categotyId", rs.getString("category_id"));
					map.put("orderCount", rs.getString("order_count"));
					map.put("orderTerm", rs.getString("order_term"));
					map.put("pauseCancelDate", rs.getString("pause_cancel_date"));
					map.put("pauseRequestDate", rs.getString("pause_request_date"));
					map.put("pauseStartDate", rs.getString("pause_start_date"));
					map.put("shipEndDate", rs.getString("ship_enddate"));
					map.put("shipStartDate", rs.getString("ship_startdate"));
					map.put("shipState", rs.getString("ship_state"));
					map.put("orderAddr", rs.getString("order_addr"));
					od.add(map);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return od;
		}

	// 주문 수정 조회
	public boolean updateOrderDetail(OrdersDetail orders) {
		conn = DBManager.getConnection();

		String sql = "update orders_detail set " 
		+ " category_id = ?, ship_startdate = ?, ship_enddate = ? "
		+ " ship_state = ?, order_term = ?, order_count = ?, pause_start_date = ? "
		+ " pause_cancel_date = ?, pause_request_date = ? "
		+ " where detail_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orders.getCategoryId());
			pstmt.setString(2, orders.getShipStartDate());
			pstmt.setString(3, orders.getShipEndDate());
			pstmt.setString(4, orders.getShipState());
			pstmt.setString(5, orders.getOrderTerm());
			pstmt.setString(6, orders.getOrderCount());
			pstmt.setString(7, orders.getPauseStartDate());
			pstmt.setString(8, orders.getPauseCancelDate());
			pstmt.setString(9, orders.getPauseRequestDate());
			pstmt.setString(10, orders.getDetailId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// 특정 값 조회
	public ArrayList<OrdersDetail> selectOrderDetail(String select, String keyword) {
		ArrayList<OrdersDetail> od = new ArrayList<OrdersDetail>();
		conn = DBManager.getConnection();
		String sql = "";

		try {
			pstmt = conn.prepareStatement(sql);
			if (select.equals("detail_id")) {
				sql = "select * from orders_detail where detail_id = ?";
			} else if (select.equals("category_id")) {
				sql = "select * from orders_detail where category_id = ?";
			} else if (select.equals("ship_startdate")) {
				sql = "select * from orders_detail where ship_startdate = ?";
			} else if (select.equals("ship_enddate")) {
				sql = "select * from orders_detail where ship_enddate = ?";
			} else if (select.equals("ship_state")) {
				sql = "select * from orders_detail where ship_state = ?";
			} else if (select.equals("order_term")) {
				sql = "select * from orders_detail where order_term = ?";
			} else if (select.equals("order_count")) {
				sql = "select * from orders_detail where order_count = ?";
			} else if (select.equals("pause_start_date")) {
				sql = "select * from orders_detail where pause_start_date = ?";
			} else if (select.equals("pause_cancel_date")) {
				sql = "select * from orders_detail where pause_cancel_date = ?";
			} else if (select.equals("pause_request_date")) {
				sql = "select * from orders_detail where pause_request_date = ?";
			}
			pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				OrdersDetail ordersDO = new OrdersDetail();
				ordersDO.setOrderId(rs.getString("order_Id"));
				ordersDO.setDetailId(rs.getString("detail_Id"));
				ordersDO.setCategoryId(rs.getString("category_id"));
				ordersDO.setShipStartDate(rs.getString("ship_startdate"));
				ordersDO.setShipEndDate(rs.getString("ship_enddate"));
				ordersDO.setShipState(rs.getString("ship_state"));
				ordersDO.setOrderCount(rs.getString("order_count"));
				ordersDO.setOrderTerm(rs.getString("order_term"));
				ordersDO.setPauseStartDate(rs.getString("pause_start_date"));
				ordersDO.setPauseCancelDate(rs.getString("pause_cancel_date"));
				ordersDO.setPauseRequestDate(rs.getString("pause_request_date"));
				od.add(ordersDO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return od;
	}
}
