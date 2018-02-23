/**
 * Mappingインターフェイスです。
 */
package exercise05;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author 佐藤裕章
 *
 */
public interface ResultSetBeanMapping<T> {

	/**
	 * 検索結果を元に情報を設定する
	 *
	 * @param ResultSet 検索結果
	 * @return 情報
	 */
    public T createFromResultSet(ResultSet rs)
            throws SQLException;


}