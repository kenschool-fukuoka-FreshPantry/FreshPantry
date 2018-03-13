package fPBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author 中山佳代子
 * @version 1.0
 * 赤星
 *
 */
public class UnitBean {

	private String unit;
	private String unit_name;

	public UnitBean(){
		super();
	}

	/**  ゲッターの定義  **/
	public String getUnit() {
		return unit;
	}
	public String getUnitName() {
		return unit_name;
	}

	/**  セッターの定義  **/
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setUnitName(String unit_name) {
		this.unit_name = unit_name;
	}

	public static ArrayList<UnitBean> getUnitIdList() throws SQLException {
		ArrayList<UnitBean> al = new ArrayList<UnitBean>();
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		String sql = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch  (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			sql = "SELECT * FROM FP_UNIT ORDER BY unit ASC";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while(rs.next()){
				UnitBean u = new UnitBean();
				u.setUnit(rs.getString("unit"));
				u.setUnitName(rs.getString("unit_name"));
				al.add(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return al;
	}
}
