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
 * Servlet implementation class FoodDeleteService
 */
@WebServlet("/FoodDeleteService")
public class FoodDeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodDeleteService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//jspのラジオボタンで選択された項目を取得
		request.setCharacterEncoding("UTF-8");
		// int food_no = Integer.parseInt(request.getParameter("食材リスト"));
		int food_no = 0;
		if (request.getParameter("食材リスト") != null){
			food_no = Integer.parseInt(request.getParameter("食材リスト"));

		}

		//Beanへ格納
		FoodBean fb = new FoodBean();
		fb.setFoodNo(food_no);


		response.setContentType("text/html;charset=UTF-8");
		String buttonOnValue = request.getParameter("buttonOn");

		RequestDispatcher rd = null;
		String url = "";

			if("1".equals(buttonOnValue)){
				request.setAttribute("result", buttonOnValue);
				// 1だったら、削除をよんで、元画面に戻る
				request.setAttribute("message", "削除ボタンおしました。");

				url = "FoodSelect.jsp";

			}else if("2".equals(buttonOnValue)){
				request.setAttribute("result", buttonOnValue);
				// 2だったら、次画面をよぶ

				url = "FoodEdit.jsp";

			}else{
				request.setAttribute("result",buttonOnValue);
				// それ以外であれば前画面に戻る

				url = "Edit.jsp";


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
