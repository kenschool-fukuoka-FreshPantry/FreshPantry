package fPBean;

/**
 * @author 中山佳代子
 *
 */
public class RecipBean {

	private String category_id;
	private String category_name;

	public RecipBean(){
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



	/** ここから先は今から作成する予定 **/
	public void addRecipData(String al) {

	}
	public void getRecipData(String al) {

	}
	public void getRecipList(String al) {

	}
	public void updateRecipData(String al) {

	}
	public void deleteRecipData(String al) {

	}

}
