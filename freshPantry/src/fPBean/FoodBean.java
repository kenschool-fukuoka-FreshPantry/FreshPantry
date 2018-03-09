package fPBean;

/**
 * @author 中山佳代子
 *
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
	private int nutrient_no;
	private String nutrient;

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

	/** ここは今から作成する予定 S**/
	public void getNutrientList() {

	}
	/** ここは今から作成する予定 **/

	public int getNutrientNo() {
		return nutrient_no;
	}
	public String getNutrient() {
		return nutrient;
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
	public void setNutrientNo(int nutrient_no) {
		this.nutrient_no = nutrient_no;
	}
	public void setNutrient(String nutrient) {
		this.nutrient = nutrient;
	}


	/** ここから先は今から作成する予定 **/
	public void setNutrientList() {

	}
	/** ここから先は今から作成する予定 **/



	/** ここから先は今から作成する予定 **/
	public static void addFoodData() {

	}
	public static void getFoodData() {

	}
	public static void getFoodList() {

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
