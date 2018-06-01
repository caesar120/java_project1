package order;

import java.sql.*;
import java.util.*;


import util.DBManager;

public class OrdersDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
		
	//신규 주문 추가
	public boolean insertOrder(Orders orders) {
		conn = DBManager.getConnection();
		//sql 문자열
		
		String sql = "insert into orders "
					+ " (order_id, order_date, order_addr, user_id, "
					+ " total_price ) "
					+ " values (?,sysdate,?,?,?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orders.getOrderId());
			pstmt.setString(2, orders.getOrderAddr());
			pstmt.setString(3, orders.getUserId());
			pstmt.setString(4, orders.getTotalPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	//주문 삭제
	public boolean DeleteOrder(Orders orders) {
		conn = DBManager.getConnection();
		//sql 문자열
		
		String sql = "Delete from orders where order_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orders.getOrderId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	//주문 전체 조회
	public ArrayList<Orders> getOrders() {
		ArrayList<Orders> od = new ArrayList<Orders>();
		conn = DBManager.getConnection();
		
		String sql = "select * from orders order by order_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Orders ordersDo = new Orders();
				ordersDo.setOrderId(rs.getString("order_id"));
				ordersDo.setUserId(rs.getString("user_id"));
				ordersDo.setOrderDate(rs.getString("order_date"));
				ordersDo.setOrderAddr(rs.getString("order_addr"));
				ordersDo.setTotalPrice(rs.getString("total_price"));
				od.add(ordersDo);
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
	//주문 수정 조회
	public boolean updateOrder(Orders orders) {
		conn = DBManager.getConnection();
		
		String sql = "update Orders set "
					+" user_id = ?, order_Date = ?, order_Addr = ?, total_Price = ? "
					+" where order_Id = ? " ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orders.getUserId());
			pstmt.setString(2, orders.getOrderDate());
			pstmt.setString(3, orders.getOrderAddr());
			pstmt.setString(4, orders.getTotalPrice());
			pstmt.setString(5, orders.getOrderId());
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
	
	//특정 값 조회
	public ArrayList<Orders> selectOrder (String	select, String keyword) {
		ArrayList<Orders> od = new ArrayList<Orders>();
		conn = DBManager.getConnection();
		String sql = "select * from where "+ select +" = ?";
		
		 
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(select.equals("order_id")){
				sql = "select * from orders where order_id = ?";
			} else if (select.equals("user_id")){
				sql = "select * from orders  where user_id = ?";
			} else if (select.equals("order_addr")){
				sql = "select * from orders  where order_addr = ?";
			} else if (select.equals("order_date")){
				sql = "select * from orders  where order_date = ?";
			} else if (select.equals("total_price")){
				sql = "select * from orders  where total_price = ?";
			}
			pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Orders ordersDO = new Orders();
				ordersDO.setOrderId(rs.getString("order_id"));
				ordersDO.setUserId(rs.getString("user_id"));
				ordersDO.setOrderAddr(rs.getString("order_addr"));
				ordersDO.setOrderDate(rs.getString("order_date"));
				ordersDO.setTotalPrice(rs.getString("total_price"));
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
		} return od;
	}
}
