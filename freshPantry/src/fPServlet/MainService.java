package fPServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fPBean.FoodBean;

/**
 * @author aka
 * @version 1.0
 *
 * メニュー画面を表示し、画面遷移をコントロールする。
 *
 */
@WebServlet("/MainService")
public class MainService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* 遷移 */
	static final String TO_ENTRY = "001";
	static final String TO_RECIP = "002";
	static final String TO_REFRIGERATOR = "003";
	static final String TO_LIST = "004";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String menuId = request.getParameter("menu_id");
		RequestDispatcher rd = null;
		String url = "";

		// 数量0かつ３か月更新がない場合、食材データを削除する。
		FoodBean.deleteFoodList();

		// メニューIDによって遷移画面を決定する。
		try {
			switch (menuId){

			case TO_ENTRY:
				// 新規登録・変更へ
				url = "/Entry.jsp";
				break;

			case TO_RECIP:
				// レシピ検索へ
				url = "/RecipSearch.jsp";
				break;

			case TO_REFRIGERATOR:
				// 庫内リストへ
				url = "/Refrigeratorjsp.jsp";
				break;

			case TO_LIST:
				// 必要リストへ
				url = "/List.jsp";
				break;

			default:
				url = "/Main.jsp";
				break;
			}

			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
