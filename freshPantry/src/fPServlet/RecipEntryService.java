package fPServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecipEntryService
 */
@WebServlet("/fPService/RecipEntryService")
public class RecipEntryService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 遷移
	static final String TO_BACK = "001";
	static final String TO_NEXT = "002";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipEntryService() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");



		//入力された情報を取得
		String reqRecip_Name = request.getParameter("recip_name");

		int i = 1;
		boolean endFlg = false;
		while(!endFlg){
			String x = request.getParameter("food_name"+ i);
			String y = request.getParameter("quantity" + i);
			String z = request.getParameter("unit" + i);

			//RecipBean rb = x + y + z;

			if(x == null){	// 枠がなくなったら、処理をやめる
				endFlg = true;
				break;
			}
			i++;

		}


	}

/*

		RequestDispatcher rd = null;
		String url = "";

		String UpDateMenuId = request.getParameter("update_menu_id");
		try {
			switch (UpDateMenuId){

			case TO_BACK:
				// 食材入力へ
				url = "/FoodEntry.jsp";
				break;

			case TO_NEXT:
				// 内容確認へ
				url = "/FoodConfirm.jsp";
				break;

			default:
				url = "/Main.jsp";
				break;
			}
*/
			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

