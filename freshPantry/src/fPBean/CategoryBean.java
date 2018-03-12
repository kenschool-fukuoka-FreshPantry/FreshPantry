package fPBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author 中山佳代子
 * @version 1.0
 *
 */
public class CategoryBean {

	private String category_id;
	private String category_name;

	public CategoryBean(){
		super();
	}

	/**  ゲッターの定義  **/
	public String getCategoryId() {
		return category_id;
	}
	public String getCategoryName() {
		return category_name;
	}

	/**  セッターの定義  **/
	public void setCategoryId(String category_id) {
		this.category_id = category_id;
	}
	public void setCategoryName(String category_name) {
		this.category_name = category_name;
	}

	public static ArrayList<CategoryBean> getCategoryIdList() throws SQLException {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;

		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql = "SELECT * FROM CATEGORY ORDER BY category_id ASC";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while(rs.next()){
				CategoryBean c = new CategoryBean();
				c.setCategoryId(rs.getString("category_id"));
				c.setCategoryName(rs.getString("category_name"));
				al.add(c);
			}
		}catch(Exception e){

		}finally{
			try{
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			}
			catch(Exception e){
			}
		}
		return al;

	}

}
