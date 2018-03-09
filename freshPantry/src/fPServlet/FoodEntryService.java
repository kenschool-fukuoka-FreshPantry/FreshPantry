package fPServlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * 新たに購入した食材の入力を行う
 *
 */
@WebServlet("/FoodEntryService")
public class FoodEntryService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoodEntryService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
		String url = "";
		try {
			// 食材入力１件のデータ
			FoodBean foodBeanData = new FoodBean();

			foodBeanData.setFoodName(request.getParameter("food_name"));
			foodBeanData.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			foodBeanData.setUnit(request.getParameter("unit"));
			foodBeanData.setPurchaseDate(request.getParameter("purchase_date"));
			foodBeanData.setExpirationDate(request.getParameter("expiration_date"));
			foodBeanData.setCategoryId(request.getParameter("category_id"));

			// 栄養素
			// TODO 栄養素のBean定義が決まったら差し替え
			ArrayList<FoodBean> foodBeanList = new ArrayList<FoodBean>();

			int i = 1;
			boolean endFlg = false;
			while(!endFlg){
				String nutrientName = request.getParameter("nutrient"+i);

				if(nutrientName == null){
					// 枠がなくなったら、処理をやめる
					endFlg = true;

				} else {
						// TODO 栄養素のBean定義が決まったら差し替え
						// 空栄養素以外を登録する
//						FoodBean nutrientData = new FoodBean();
//						nutrientData.setId(nutrientName);
//
//						foodBeanList.add(nutrientData);
				}
				i++; // 次の栄養素の判定へ
			}
			// TODO foodBeanData.setId(foodBeanList);
			request.setAttribute("foodData", foodBeanData);
			url = "/FoodEntryConfirm.jsp";
			// 最後にフォワード
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
