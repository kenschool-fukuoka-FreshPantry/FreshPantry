/**
 * 
 */
package exercise05;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 書籍情報を扱うMappingクラスです。
 */
public class BookMapping implements ResultSetBeanMapping<BookBean>{

	/**
	 * 検索結果を書籍情報に設定します。
	 *
	 * @param ResultSet 検索結果
	 * @return 書籍情報
	 */
	public BookBean createFromResultSet(ResultSet rs)
		throws SQLException {

		BookBean bookBean = new BookBean();

		bookBean.setId(rs.getInt("ID"));
		bookBean.setTitle(rs.getString("TITLE"));
		bookBean.setPrice(rs.getInt("PRICE"));

		return bookBean;
	}


}
