/**
 * 書籍を表すクラスです。
 *
 */
package exercise05;

/**
 * @author 佐藤裕章
 *
 */
public class BookBean {

	/** ID */
	private int id;

	/** タイトル */
	private String title;

	/** 価格 */
	private int price;


	public BookBean() {
		// TODO 自動生成されたコンストラクター・スタブ

	}
	/**
	 * IDを取得します。
	 *
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * IDを設定します。
	 *
	 * @param id ID
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * タイトルを取得します。
	 *
	 * @return タイトル
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * タイトルを設定します。
	 *
	 * @param title タイトル
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 価格を取得します。
	 *
	 * @return 価格
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 価格を設定します。
	 *
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
