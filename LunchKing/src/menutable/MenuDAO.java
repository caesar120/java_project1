package menutable;

import java.sql.*;
import java.util.*;

import util.DBManager;

/**
 * File : DeptDAO.java
 * Desc : 부서관리 DAO 클래스
 * @author 노진형
 */

public class MenuDAO { 
	
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public ArrayList<Map<String,String>> selectMenu(MenuDO menu) {
		conn = DBManager.getConnection();
		ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
		HashMap<String,String> map = new HashMap<String, String>();
		
		
		
		String sql = "select prod_id, to_char(menu_month,'dd') menu_month, menu_category_id, menu_id "
					+ " from menusample";
				//	+ " where to_char(menu_month,'rrrrmm') = ? ";
	
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  menu.getMenuMonth());
		rs = pstmt.executeQuery();
		if(rs.next()){
			map.put("prod_id", rs.getString("prod_id"));
			map.put("menu_month", rs.getString("menu_month"));
			map.put("menu_category_id", rs.getString("menu_category_id"));
			map.put("menu_id", rs.getString("menu_id"));
			list.add(map);
		}
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		return list;
	}
	
	finally {
		try{
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return list;
}
	
	
	public boolean insertMenu(MenuDO menu) {
		conn = DBManager.getConnection();
		
		
		String sql = "insert into menusample "
					+ " (menu_id, menu_month, menu_category_id, prod_id) "
					+ " values (?,?,?,?) ";
	
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, menu.getMenuId());
		pstmt.setString(2, menu.getMenuMonth());
		pstmt.setString(3, menu.getMenuCategoryId());
		pstmt.setString(4, menu.getProdId());
		
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	finally {
		try{
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return true;
}

	public boolean updateMenu(MenuDO menu) {
		conn = DBManager.getConnection();
		
		
		String sql =  " update menusample "
					+ " set prod_id='?' "
					+ " where menu_month='?' ";
	
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, menu.getProdId());
		pstmt.setString(2, menu.getMenuMonth());
			
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	finally {
		try{
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return true;
}
	
	public boolean deleteMenu(MenuDO menu) {
		conn = DBManager.getConnection();
		
		
		String sql =  " delete from menusample "
					+ " where menu_month='?' ";
	
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, menu.getMenuMonth());
			
	}
	
	catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	finally {
		try{
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return true;
}
	

	
}