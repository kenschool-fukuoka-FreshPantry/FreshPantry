/**
 * DB接続、SQLの実行を行うクラスです。
 *
 */
package exercise05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 佐藤裕章
 *
 */
public class DBManager {

	/**
	 * DBとのコネクションを確立します。
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 検索SQLを実行して、検索結果を一覧にして返す。
	 *
	 * @param String 実行SQL文
	 * @param ResultSetBeanMapping 検索結果作成
	 * @return 一覧情報
	 */
	public static <T> List<T> simpleFind(String sql, ResultSetBeanMapping<T> mapping)
		throws SQLException{

		Connection con = null;
		Statement smt = null;

		try{
			// DB接続
			con = DBManager.getConnection();
			smt = con.createStatement();

			// SQL実行
			ResultSet rs = smt.executeQuery(sql);

			List<T> list = new ArrayList<T>();

			// SQL実行結果を取り出して一覧に追加
			while(rs.next()) {
				T bean = mapping.createFromResultSet(rs);
				list.add(bean);
			}

			return list;

		}finally{
			if(smt != null) {
				try{
					smt.close();
				} catch (SQLException igonre) {
				}
			}
			if(con != null) {
				try{con.close();
				} catch (SQLException igonre) {
				}
			}
		}
	}

	/**
	 * 更新SQLを実行する。
	 *
	 * @param String 実行SQL文
	 * @return 実行件数
	 */
	public static int simpleUpdate(String sql)
		throws SQLException{

		Connection con = null;
		Statement smt = null;

		try{
			// DB接続
			con = DBManager.getConnection();
			smt = con.createStatement();

			// SQL実行
			return smt.executeUpdate(sql);

		}finally{
			if(smt != null) {
				try{
					smt.close();
				} catch (SQLException igonre) {
				}
			}
			if(con != null) {
				try{con.close();
				} catch (SQLException igonre) {
				}
			}
		}
	}

}
