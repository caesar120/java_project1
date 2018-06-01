/**
 * 파일명 : CategoryDAO.java
 * 작성자 : 박상철
 * 작성일 : 2017. 4. 26.
 * 파일설명 : 
 */
package category;

import java.sql.*;
import java.util.*;

import product.*;

import util.DBManager;

/**
 * @summary : 상품분류(Category) DAO
 * @author  : 박상철
 */
public class CategoryDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	/**
	 * @method : addCategory
	 * @return : boolean 
	 * @summary: 카테고리 추가
	 */
	public boolean addCategory(Category category) {
		conn = DBManager.getConnection();
		
		String sql = "insert into category values (?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getCategoryId());
			pstmt.setString(2, category.getCategoryName());
			pstmt.setString(3, category.getPrice());
			pstmt.setString(4, category.getCategoryImage());
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
	
	/**
	 * @method : updateCategory
	 * @return : boolean 
	 * @summary: 카테고리 정보 수정
	 */
	public boolean updateCategory(Category category) {
		conn = DBManager.getConnection();
		String sql = "update category set "
						+ " category_name = ?, "
						+ " price = ?, "
						+ " category_image = ? "
						+ "where category_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getCategoryName());
			pstmt.setString(2, category.getPrice());
			pstmt.setString(3, category.getCategoryImage());
			pstmt.setString(4, category.getCategoryId());
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
	
	public boolean deleteCategory(String categoryId) {
		conn = DBManager.getConnection();
		
		String sql = "delete from category where category_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryId);
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
	
	/**
	 * @method : getCategory
	 * @return : Category 
	 * @summary: 카테고리 정보 단건 조회 
	 */
	public Category getCategory(String categoryId) {
		conn = DBManager.getConnection();
		String sql = "select category_id, category_name, price, category_image "
				   + "from category "
				   + "where category_id = ?";
		Category category = new Category();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryId);
			rs = pstmt.executeQuery();
			rs.next();
			category.setCategoryId(rs.getString("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			category.setPrice(rs.getString("price"));
			category.setCategoryImage(rs.getString("category_image"));
			rs.close();
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
		return category;
	}
	
	/**
	 * @method : getCategoryList
	 * @return : ArrayList<Category> 
	 * @summary: 카테고리 전체 조회
	 */
	public ArrayList<Category> getCategoryList() {
		conn = DBManager.getConnection();
		ArrayList<Category> datas = new ArrayList<Category>();
		ProductDAO productDao = new ProductDAO();
		
		String sql = "select category_id, category_name, price "
				   + "from category "
				   + "order by category_id";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getString("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setPrice(rs.getString("price"));
				category.setProductList(productDao.getProductList(category.getCategoryId()));
				datas.add(category);
			}
			rs.close();
			
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
		return datas;
	}
	
}
