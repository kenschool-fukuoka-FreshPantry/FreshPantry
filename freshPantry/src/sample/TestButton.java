package sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fPBean.FoodBean;

/**
 * Servlet implementation class TestButton
 */
@WebServlet("/sample/TestButton")
public class TestButton extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestButton() {
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
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		String buttonOnValue = request.getParameter("buttonOn");

		RequestDispatcher rd = null;
		String url = "";


		if(buttonOnValue.equals("1")){
			request.setAttribute("result", buttonOnValue);
			// 1だったら、削除をよんで、元画面に戻る
			request.setAttribute("message", "削除ボタンおしました。");

			url = "buttonIn.jsp";

		}else{
			// 単品ずついれる場合
			request.setAttribute("no", request.getParameter("no"));
			request.setAttribute("food_name", request.getParameter("food_name"));


			// Bean使う場合
			FoodBean fb = new FoodBean();
			fb.setFoodNo(Integer.parseInt(request.getParameter("no")));
			fb.setFoodName(request.getParameter("food_name"));
			request.setAttribute("foodB", fb);

			// ボタン判定用を渡す
			request.setAttribute("result", buttonOnValue);
			// 2だったら、次画面をよぶ

			url = "buttonOut.jsp";
		}
		// 最後にフォワード
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}

}
