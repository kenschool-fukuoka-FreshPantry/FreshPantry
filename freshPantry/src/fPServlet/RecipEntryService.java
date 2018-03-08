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
		
		
		
		String reqFood_Name1 = request.getParameter("food_name1");
		int reqQuantity1 = Integer.parseInt(request.getParameter("quantity1"));
		int reqUnit1 = Integer.parseInt(request.getParameter("unit1"));
		String reqFood_Name2 = request.getParameter("food_name2");
		int reqQuantity2 = Integer.parseInt(request.getParameter("quantity2"));
		int reqUnit2 = Integer.parseInt(request.getParameter("unit2"));

		RequestDispatcher rd = null;
		String url = "";

		String subMenuId = request.getParameter("sub_menu_id");
		try {
			switch (subMenuId){

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

			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

