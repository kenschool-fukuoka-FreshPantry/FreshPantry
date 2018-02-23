/**
 * 書籍情報を扱うDAOクラスです。
 */
package exercise05;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 佐藤裕章
 *
 */
public class BookDAO {
	/**
	 * 書籍一覧を取得します。
	 *
	 * @param String タイトル検索条件
	 * @return 書籍一覧
	 */
	public List<BookBean> find(String title) {

		// 検索用SQL記述
		String sql = "SELECT ID, TITLE, PRICE " +
					"FROM BOOK WHERE TITLE LIKE '%" + title + "%' " +
					"ORDER BY ID ";
		//List<BookBean> list = DBManager.simpleFind(sql, new BookMapping());
		System.out.println("SQL = " + sql);

		try {
			 return  DBManager.simpleFind(sql, new BookMapping());
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 書籍情報を登録します。
	 *
	 * @param BookBean 登録書籍情報
	 * @return 登録件数
	 */
	public int insert(BookBean bookBean){

		// 登録用SQL記述
		String sql = "INSERT INTO BOOK(ID, TITLE, PRICE) "
			+ "VALUES("
			+ bookBean.getId()
			+ ", '" + bookBean.getTitle()
			+ "' ," + bookBean.getPrice()
			+ ")";

		try {
			return DBManager.simpleUpdate(sql);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
