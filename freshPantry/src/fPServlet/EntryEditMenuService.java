package fPServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntryEditMenuService
 */
@WebServlet("/EntryEditMenuService")
public class EntryEditMenuService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* 遷移 */
	static final String TO_ENTRY = "001";
	static final String TO_RECIP_ENTRY = "002";
	static final String TO_EDIT = "003";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryEditMenuService() {
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
		String subMenuId = request.getParameter("sub_menu_id");
		RequestDispatcher rd = null;
		String url = "";

		// サブメニューIDによって遷移画面を決定する。
		try {
			switch (subMenuId){

			case TO_ENTRY:
				// 食材入力へ
				url = "/FoodEntry.jsp";
				break;

			case TO_RECIP_ENTRY:
				// レシピ入力へ
				url = "/RecipEntry.jsp";
				break;

			case TO_EDIT:
				// 登録内容変更・削除へ
				url = "/Edit.jsp";
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
