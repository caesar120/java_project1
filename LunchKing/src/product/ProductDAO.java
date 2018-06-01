/**
 * 파일명 : ProductDAO.java
 * 작성자 : 박상철
 * 작성일 : 2017. 5. 1.
 * 파일설명 : 
 */
package product;

import java.sql.*;
import java.util.*;

import util.DBManager;

/**
 * @summary : 상품(Product) DAO
 * @author  : 박상철
 */
public class ProductDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	/**
	 * @method : addProduct
	 * @return : boolean 
	 * @summary: 상품 추가
	 */
	public boolean addProduct(Product product) {
		conn = DBManager.getConnection();
		
		String sql = "insert into product (prod_id, prod_name, description, detail, prod_image, category_id) "
				   + "values (PROD_SEQ.nextval, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProdName());
			pstmt.setString(2, product.getDescription());
			pstmt.setString(3, product.getDetail());
			pstmt.setString(4, product.getProdImage());
			pstmt.setString(5, product.getCategoryId());
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
	 * @method : updateProduct
	 * @return : boolean 
	 * @summary: 상품 수정
	 */
	public boolean updateProduct(Product product) {
		conn = DBManager.getConnection();
		String sql = "update product set "
				   + "prod_name = ?, "
				   + "description = ?, "
				   + "detail = ?, "
				   + "prod_image = ? "
				   + "where product_id = ?";
					// 여기 수정
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProdName());
			pstmt.setString(2, product.getDescription());
			pstmt.setString(3, product.getDetail());
			pstmt.setString(4, product.getProdImage());
			pstmt.setString(5, product.getProdId());	// 조건 수정에 따라 수정
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
	 * @method : deleteProduct
	 * @return : boolean 
	 * @summary: 상품 삭제
	 */
	public boolean deleteProduct(String prodId) {
		conn = DBManager.getConnection();
		String sql = "delete from product where prod_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodId);
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
	 * @method : getProduct
	 * @return : Product 
	 * @summary: 상품 단건 조회
	 */
	public Product getProduct(String prodId) {
		conn = DBManager.getConnection();
		String sql = "";
		Product product = new Product();
		
		try {
			pstmt = conn.prepareStatement(sql);
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
		return product;
	}
	
	/**
	 * @method : getProductList
	 * @return : ArrayList<Product> 
	 * @summary: 카테고리별 상품 전체 조회
	 */
	public ArrayList<Product> getProductList(String categoryId) {
		conn = DBManager.getConnection();
		ArrayList<Product> datas = new ArrayList<Product>();
		
		String sql = "select prod_id, prod_name, description, detail, prod_image, category_id "
				   + "from product "
				   + "where category_id = ? "
				   + "order by prod_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setProdId(rs.getString("prod_id"));
				product.setProdName(rs.getString("prod_name"));
				product.setDescription(rs.getString("description"));
				product.setDetail(rs.getString("detail"));
				product.setProdImage(rs.getString("prod_image"));
				product.setCategoryId(rs.getString("category_id"));
				datas.add(product);
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
