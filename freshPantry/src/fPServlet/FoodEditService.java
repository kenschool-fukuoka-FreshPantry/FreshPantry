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
 * Servlet implementation class FoodEditService
 */
@WebServlet("/FoodEditService")
public class FoodEditService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodEditService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		//入力された項目の情報を取得
		request.setCharacterEncoding("UTF-8");
		String food_name = (String)request.getParameter("food_name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String purchase_date = (String)request.getParameter("purchase_date");
		String expiration_date = (String)request.getParameter("expiration_date");
		String category_id = (String)request.getParameter("category_id");

		//Beanへ格納
		FoodBean fb = new FoodBean();
		fb.setFoodName(food_name);
		fb.setQuantity(quantity);
		fb.setPurchaseDate(purchase_date);
		fb.setExpirationDate(expiration_date);
		fb.setCategoryId(category_id);


		response.setContentType("text/html;charset=UTF-8");
		String buttonOnValue = request.getParameter("buttonOn");

		RequestDispatcher rd = null;
		String url = "";


		if(buttonOnValue.equals("1")){
			request.setAttribute("result", buttonOnValue);
			// 1であれば、変更確認画面へ遷移

			url = "FoodEditConfirm.jsp";

		}else{
			request.setAttribute("result",buttonOnValue);
			// それ以外であれば前画面に戻る

			url = "FoodSelect.jsp";


			request.setAttribute("foodList", fb);

			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

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