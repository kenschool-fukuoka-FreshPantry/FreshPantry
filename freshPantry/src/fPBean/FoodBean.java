package fPBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author 中山佳代子
 * @version 1.0
 * 赤星
 * 森川
 */
public class FoodBean {

	private int food_no;
	private String food_name;
	private int quantity;
	private String unit;
	private String unit_name;
	private String purchase_date;
	private String expiration_date;
	private String category_id;
	private String category_name;
	private ArrayList<FoodNutrientBean> nutrientList;

	/**  ゲッターの定義  **/
	public int getFoodNo() {
		return food_no;
	}
	public String getFoodName() {
		return food_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getUnit() {
		return unit;
	}
	public String getUnitName() {
		return unit_name;
	}
	public String getExpirationDate() {
		return purchase_date;
	}
	public String getPurchaseDate() {
		return expiration_date;
	}
	public String getCategoryId() {
		return category_id;
	}
	public String getCategoryName() {
		return category_name;
	}
	public ArrayList<FoodNutrientBean> getNutrientList() {
		return nutrientList;
	}

	/**  セッターの定義  **/
	public void setFoodNo(int food_no) {
		this.food_no = food_no;
	}
	public void setFoodName(String food_name) {
		this.food_name = food_name;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setUnitName(String unit_name) {
		this.unit_name = unit_name;
	}
	public void setExpirationDate(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public void setPurchaseDate(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public void setCategoryId(String category_id) {
		this.category_id = category_id;
	}
	public void setCategoryName(String category_name) {
		this.category_name = category_name;
	}
	public void setNutrientList(ArrayList<FoodNutrientBean> nutrientList) {
		this.nutrientList = nutrientList;
	}

	/**
	 *  登録メソッド
	 *
	 **/
	public static void addFoodData(FoodBean foodBean) {

		Connection con = null;
		Statement st = null;
		String sql = "";
		ResultSet rs= null;
		int setFoodNo = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch  (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 食材Noを取得する。
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			st = con.createStatement();
			sql ="SELECT MAX(food_no) AS max FROM FP_FOODMANAGE";
			rs = st.executeQuery(sql);

			if(rs.next()){
				setFoodNo = rs.getInt("max") + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				st.close();
				con.close();
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			String prDate = null;

			if(foodBean.getPurchaseDate() != null && !foodBean.getPurchaseDate().isEmpty() ){
				prDate = "'" +foodBean.getPurchaseDate()+"'"  ;
			}


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			st = con.createStatement();
			sql ="INSERT INTO FP_FOODMANAGE("
					+ "category_id,"
					+ "food_no,"
					+ "food_name,"
					+ "expiration_date,"
					+ "purchase_date,"
					+ "quantity,"
					+ "unit,"
					+ "registration_time,"
					+ "update_time)"
					+ "VALUES('"
					+ foodBean.getCategoryId() + "',"
					+ setFoodNo  + ",'"
					+ foodBean.getFoodName()  + "','"
					+ foodBean.getExpirationDate()  + "',"
					+ prDate  + ","
					+ foodBean.getQuantity()  + ",'"
					+ foodBean.getUnit()  + "',"
					+ "current_timestamp(),"
					+ "'0000-00-00 00:00:00')";
			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				st.close();
				con.close();
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			// 1件に紐づく栄養素複数県を登録
			ArrayList<FoodNutrientBean> foodNutrientList = foodBean.getNutrientList();

			int i = 1;
			for(FoodNutrientBean fnBeanData : foodNutrientList){

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
				st = con.createStatement();
				sql ="INSERT INTO FP_FOOD("
						+ "food_no,"
						+ "nutrient_no,"
						+ "nutrient,"
						+ "registration_time,"
						+ "update_time)"
						+ "VALUES("
						+ setFoodNo  + ","
						+ i  + ",'"
						+ fnBeanData.getNutrient()  + "',"
						+ "current_timestamp(),"
						+ "'0000-00-00 00:00:00')";
				st.executeUpdate(sql);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				st.close();
				con.close();
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static FoodBean getFoodData(int foodNo) {
		FoodBean resultFoodBean = new FoodBean();
		ArrayList<FoodNutrientBean> fnBeenList = new ArrayList<FoodNutrientBean>();

		Connection con = null;
		Statement st = null;
		String sql = "";
		ResultSet rs= null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch  (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
				st = con.createStatement();
				sql = "SELECT "
						+ "fm.category_id AS category_id,"
						+ "ca.category_name AS category_name,"
						+ "fm.food_no AS food_no,"
						+ "fm.food_name AS food_name,"
						+ "fm.expiration_date AS expiration_date,"
						+ "fm.purchase_date AS purchase_date,"
						+ "fm.quantity AS quantity,"
						+ "fm.unit AS unit,"
						+ "un.unit_name AS unit_name,"
						+ "fo.nutrient AS nutrient"
						+ " FROM FP_FOODMANAGE fm "
						+ "INNER JOIN FP_UNIT un USING(unit) "
						+ "INNER JOIN FP_CATEGORY ca USING(category_id) "
						+ "INNER JOIN FP_FOOD fo USING(food_no) "
						+ " WHERE fm.food_no = " + foodNo + ";"
						;
				rs = st.executeQuery(sql);

			if(rs.next()){

				resultFoodBean.setCategoryId(rs.getString("category_id"));
				resultFoodBean.setCategoryName(rs.getString("category_name"));
				resultFoodBean.setFoodNo(rs.getInt("food_no"));
				resultFoodBean.setFoodName(rs.getString("food_name"));

				if (rs.getDate("expiration_date") != null){
					resultFoodBean.setExpirationDate(rs.getDate("expiration_date").toString());
				}
				if (rs.getDate("purchase_date") != null){
					resultFoodBean.setPurchaseDate(rs.getDate("purchase_date").toString());
				}
				resultFoodBean.setQuantity(rs.getInt("quantity"));
				resultFoodBean.setUnit(rs.getString("unit"));
				resultFoodBean.setUnitName(rs.getString("unit_name"));

				FoodNutrientBean fnBeen = new FoodNutrientBean();
				fnBeen.setNutrient(rs.getString("nutrient"));
				fnBeenList.add(fnBeen);
			}

			resultFoodBean.setNutrientList(fnBeenList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				rs.close();
				st.close();
				con.close();
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}
		return resultFoodBean;
	}

	public static ArrayList<FoodBean> getFoodList(String categryId) {

		ArrayList<FoodBean> resultFoodBeanlist = new ArrayList<FoodBean>();
		Connection con = null;
		Statement st = null;
		String sql = "";
		ResultSet rs= null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch  (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// カテゴリIDがなければ食材全検索
		try {
			if (categryId == null || categryId.isEmpty()){
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
				st = con.createStatement();
				sql = "SELECT "
						+ "fm.category_id AS category_id,"
						+ "ca.category_name AS category_name,"
						+ "fm.food_no AS food_no,"
						+ "fm.food_name AS food_name,"
						+ "fm.expiration_date AS expiration_date,"
						+ "fm.purchase_date AS purchase_date,"
						+ "fm.quantity AS quantity,"
						+ "fm.unit AS unit,"
						+ "un.unit_name AS unit_name"
						+ " FROM FP_FOODMANAGE fm "
						+ "INNER JOIN FP_UNIT un USING(unit) "
						+ "INNER JOIN FP_CATEGORY ca USING(category_id) "
						+ " ORDER BY fm.food_name ASC ;"
						;
				rs = st.executeQuery(sql);

			}else{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
				st = con.createStatement();
				sql = "SELECT "
						+ "fm.category_id AS category_id,"
						+ "ca.category_name AS category_name,"
						+ "fm.food_no AS food_no,"
						+ "fm.food_name AS food_name,"
						+ "fm.expiration_date AS expiration_date,"
						+ "fm.purchase_date AS purchase_date,"
						+ "fm.quantity AS quantity,"
						+ "fm.unit AS unit,"
						+ "un.unit_name AS unit_name"
						+ " FROM FP_FOODMANAGE fm "
						+ "INNER JOIN FP_UNIT un USING(unit) "
						+ "INNER JOIN FP_CATEGORY ca USING(category_id) "
						+ " WHERE fm.category_id = '" + categryId + "'"
						+ " ORDER BY fm.food_name ASC ;"
						;
				rs = st.executeQuery(sql);
			}

			if(rs.next()){
				FoodBean resultFoodBeanData = new FoodBean();
				resultFoodBeanData.setCategoryId(rs.getString("category_id"));
				resultFoodBeanData.setCategoryName(rs.getString("category_name"));
				resultFoodBeanData.setFoodNo(rs.getInt("food_no"));
				resultFoodBeanData.setFoodName(rs.getString("food_name"));

				if (rs.getDate("expiration_date") != null){
					resultFoodBeanData.setExpirationDate(rs.getDate("expiration_date").toString());
				}
				if (rs.getDate("purchase_date") != null){
					resultFoodBeanData.setPurchaseDate(rs.getDate("purchase_date").toString());
				}
				resultFoodBeanData.setQuantity(rs.getInt("quantity"));
				resultFoodBeanData.setUnit(rs.getString("unit"));
				resultFoodBeanData.setUnitName(rs.getString("unit_name"));
				resultFoodBeanlist.add(resultFoodBeanData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				rs.close();
				st.close();
				con.close();
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}
		return resultFoodBeanlist;

	}


	public static ArrayList<FoodBean> getFoodData(String food_name) {
		ArrayList<FoodBean> resultFoodBean = new ArrayList<FoodBean>();
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
			sql = "SELECT * FROM FP_FOODMANAGE INNER JOIN CATEGORY USING (category_id) INNER JOIN UNIT USING(unit)"
					+ " WHERE food_name like '%" + food_name + "%'"
					+ " ORDER BY FP_FOODMANAGE.food_name ASC ;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while(rs.next()){
				FoodBean f = new FoodBean();

				f.setFoodNo(Integer.parseInt(rs.getString("food_no")));
				f.setFoodName(rs.getString("food_name"));
				f.setQuantity(Integer.parseInt(rs.getString("quantity")));
				f.setUnit(rs.getString("unit"));
				f.setUnitName(rs.getString("unit_name"));
				f.setExpirationDate(rs.getString("expiration_date"));
				f.setPurchaseDate(rs.getString("purchase_date"));
				f.setCategoryId(rs.getString("category_id"));
				f.setCategoryName(rs.getString("category_name"));
				//f.setNutrientList(rs.getString("nutrient_list"));


				resultFoodBean.add(f);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pst != null) pst.close();
				if(con != null) con.close();
				if(rs != null) rs.close();

			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return resultFoodBean;
	}



	public static void updateFoodData() {

	}
	public static void deleteFoodData() {

	}
	public static void deleteFoodList() {

	}
	public static void getNutrientData() {

	}
	public static void updateNutrientData() {

	}


}
