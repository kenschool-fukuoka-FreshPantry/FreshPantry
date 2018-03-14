package fPServlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class FoodSearchService
 */
@WebServlet("/FoodSearchService")
public class FoodSearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodSearchService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		//jspに入力された情報を取得
		String food_name = (String)request.getParameter("food_name");

		//bean値のセット
		ArrayList<FoodBean>resultFoodBean = FoodBean.getFoodData(food_name);

			request.setAttribute("resultList", resultFoodBean);

			request.getRequestDispatcher("FoodData.jsp").forward(request, response);

		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("FoodData.jsp");
	}

}
