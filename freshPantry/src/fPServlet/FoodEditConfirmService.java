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
 * @author 森川
 * @version 1.0
 *
 * Servlet implementation class FoodEditConfirm
 */
@WebServlet("/FoodEditConfirmService")
public class FoodEditConfirmService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 遷移
		static final String ON_CANCEL = "001";
		static final String ON_ADD = "002";
		static final String ON_BACK = "003";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodEditConfirmService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
		String url = "";
		String buttonOnValue = request.getParameter("buttonOn");


		try{
			FoodBean fb = new FoodBean();

			switch (buttonOnValue){

				case ON_CANCEL:
					//登録内容変更・削除へ画面遷移のみ
					url = "/Edit.jsp";
					break;

				case ON_ADD:
					// 登録実施
					fb.setFoodName(request.getParameter("food_name"));
					fb.setQuantity(Integer.parseInt(request.getParameter("quantity")));
					fb.setUnit(request.getParameter("unit"));
					fb.setPurchaseDate(request.getParameter("purchase_date"));
					fb.setExpirationDate(request.getParameter("expiration_date"));
					fb.setCategoryId(request.getParameter("category_id"));


					//登録内容変更・削除へ
					url = "/Edit.jsp";
					break;

				case ON_BACK:
					//渡す値を設定して前の食材変更画面へ
					fb.setFoodName(request.getParameter("food_name"));
					fb.setQuantity(Integer.parseInt(request.getParameter("quantity")));
					fb.setUnit(request.getParameter("unit"));
					fb.setPurchaseDate(request.getParameter("purchase_date"));
					fb.setExpirationDate(request.getParameter("expiration_date"));
					fb.setCategoryId(request.getParameter("category_id"));

					//食材変更画面へ
					url = "/FoodEdit.jsp";
					break;
				}

				request.setAttribute("foodList", fb);

				// 最後にフォワード
				rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				return;


			}catch(Exception e) {
				e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
